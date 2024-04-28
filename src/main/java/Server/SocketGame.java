package Server;
import java.net.*;
import java.io.*;
public class SocketGame extends Thread{
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	private Player player=new Player();
	
	public SocketGame(Socket socket) {
		this.socket=socket;	
		try {
			br=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeSocket(){
		try {
			if(socket!=null)
				socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void sendMSG(String str){
		pw.println(str);
		pw.flush();
	}
	
	public void run() {
		String str="";
		try {
			while((str=br.readLine())!=null){
				String [] comms=str.split("[|]");
				if(comms[0].equals("LOGIN")){
					//LOGIN|username
					String stables=GameService.getgameService().getAllGameTables();
					player.setName(comms[1]);					
					sendMSG("GAMETABLES|"+stables);
					GameService.getgameService().addList(this);

				}
				else if(comms[0].equals("SELECT")){
					//����Ϸ�� SELECT|tbIndex|side   side(0:�ڷ���1���췽)

					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					GameTable gtable=GameService.getgameService().getGameTable(index);

					//1���ж��Ƿ��ܹ��ɹ�����
					SocketGame currSG=gtable.getSocketGameByIndex(side); //��ǰҪ���µ�socket
					
					String strResult="SITRESULT|"+index+"|"+side+"|";  //�Ƿ����ɹ��Ľ�����
					if(currSG!=null){
						//�Ѿ���������ʧ��
						strResult+="0";
						sendMSG(strResult);
					}
					else{
						
						strResult+="1";
						sendMSG(strResult);
						
						//�û�������Ϸ����
						GameService.getgameService().setTableSide(gtable,side,this);
						
						this.player.setPlayside(side);
						//2��//�Է��Ƿ������ˣ�����Ѿ����ˣ���Ϣ֪ͨ�ҷ�����Ϸ���������Ϣ֪ͨ�ã�
						String strmsg="SITDOWN|";  //SITDOWN|side|playername
						SocketGame anotherSG=gtable.getAnotherSocketGame(this);
						if(anotherSG!=null){
							//�Է���Ϸ������֪ͨ�ҷ�
							sendMSG(strmsg+anotherSG.player.getPlayside()+"|"+anotherSG.player.getName());
							//�ҷ�����Ϸ������֪ͨ�Է�
							anotherSG.sendMSG(strmsg+side+"|"+this.player.getName());
						}
						//update��λ��������
						//UPATETABLES|tabindex|side|flag
						GameService.getgameService().sendAllSitdownMSG(this,index,side,"1");
						
					}		
				}
				else if(comms[0].equals("GAMESTART")){
					//GAMESTART|tableindex|side
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					player.setReady(true);  //�����û����ó�׼��״̬
					
					//�õ��Է��û�����
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					sgAnother.sendMSG("MSG|"+player.getName()+"|ͬ�⿪ʼ��Ϸ��");  // MSG|playname|ͬ�⿪ʼ��Ϸ
					
					//����Է�Ҳ����˿�ʼ��Ϸ �����˿��Կ�ʼ��ʽ��Ϸ��������Ϸ�������isClick
					//GAMESTART|ISCLICK  1�����Ե�������ӣ�0:������
					if(sgAnother.player.isReady()){
						//�췽�ȿ���0�����ӣ�1������
						String strMsg="GAMESTART|";
						if(side==0){
							this.sendMSG(strMsg+"0");
							sgAnother.sendMSG(strMsg+"1");
						 }
						else{
							this.sendMSG(strMsg+"1");
							sgAnother.sendMSG(strMsg+"0");
						} 
						//��Ϸ���ݵĳ�ʼ��
						GameService.getgameService().gtables[index].resetData();
					}
				}
				else if(comms[0].equals("SETPOS")){
					//// ���͸�ʽ��SETPOS|����|��λ��|��|��|��������	
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					int iColor=Integer.parseInt(comms[5]);
					int i=Integer.parseInt(comms[3]);
					int j=Integer.parseInt(comms[4]);
					//�޸���Ϸ����
					GameService.getgameService().getGameTable(index).setGameData(i, j,iColor);
					
					
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					
					//������Ϣ ��ͬ����˫���Ŀͻ���
					//UPDATEPOS|x|y|chessColor|isClick
					String sPos="UPDATEPOS|"+i+"|"+j+"|"+iColor+"|";
					
					sgAnother.sendMSG(sPos+"1");//�Է��û��ĳ������ݣ������Ƿ���Ӹ�Ϊtrue
					
					if(GameService.getgameService().isWin(index, i,j, side)){
						//Ӯ��  
						//��˫��֪ͨ��ʤ�ߵĽ��     //WIN|side
						this.sendMSG("WIN|"+side);
						sgAnother.sendMSG("WIN|"+side);
					}
					
				}
				else if(comms[0].equals("GAMEOVER")){
					//GAMEOVER@TABLEINDEX@SIDE
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					 
					//������Ϸ����Ϣ
					GameService.getgameService().getGameTable(index).cancelSide(side);
					//֪ͨ�Է����ҷ����ߣ��Է�����ʱ��  //GAMEEXIT|playname|side
					if (sgAnother!=null){
						sgAnother.sendMSG("GAMEEXIT|"+player.getName()+"|"+side);
					}
					//������Ϸ������Ϣ
					GameService.getgameService().sendAllSitdownMSG(this,index,side,"0");
				}
				else if(comms[0].equals("MSG")){
					// MSG|Tableindex|side|Messagecontent
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					
					sgAnother.sendMSG("MSG|"+this.player.getName()+":|"+comms[3]);
				}
				else if(comms[0].equals("CLOSE")){
					////CLOSE|name
					//ɾ��Arraylist�е�����
					
					GameService.getgameService().removeList(this);
					this.closeSocket();
					GameService.getgameService().setLogTxt(comms[1]+"���˳����ӣ�");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
