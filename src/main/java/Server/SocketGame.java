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
					//坐游戏桌 SELECT|tbIndex|side   side(0:黑方；1：红方)

					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					GameTable gtable=GameService.getgameService().getGameTable(index);

					//1、判断是否能够成功坐下
					SocketGame currSG=gtable.getSocketGameByIndex(side); //当前要坐下的socket
					
					String strResult="SITRESULT|"+index+"|"+side+"|";  //是否坐成功的交互串
					if(currSG!=null){
						//已经有人坐下失败
						strResult+="0";
						sendMSG(strResult);
					}
					else{
						
						strResult+="1";
						sendMSG(strResult);
						
						//用户坐到游戏桌上
						GameService.getgameService().setTableSide(gtable,side,this);
						
						this.player.setPlayside(side);
						//2、//对方是否坐下人，如果已经有人，信息通知我方（游戏主界面的信息通知用）
						String strmsg="SITDOWN|";  //SITDOWN|side|playername
						SocketGame anotherSG=gtable.getAnotherSocketGame(this);
						if(anotherSG!=null){
							//对方游戏者名称通知我方
							sendMSG(strmsg+anotherSG.player.getPlayside()+"|"+anotherSG.player.getName());
							//我方的游戏者名称通知对方
							anotherSG.sendMSG(strmsg+side+"|"+this.player.getName());
						}
						//update座位给所有人
						//UPATETABLES|tabindex|side|flag
						GameService.getgameService().sendAllSitdownMSG(this,index,side,"1");
						
					}		
				}
				else if(comms[0].equals("GAMESTART")){
					//GAMESTART|tableindex|side
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					player.setReady(true);  //将本用户设置成准备状态
					
					//得到对方用户对象
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					sgAnother.sendMSG("MSG|"+player.getName()+"|同意开始游戏。");  // MSG|playname|同意开始游戏
					
					//如果对方也点击了开始游戏 ，两人可以开始正式游戏，设置游戏主界面的isClick
					//GAMESTART|ISCLICK  1：开以点击放棋子，0:不可以
					if(sgAnother.player.isReady()){
						//红方先开局0：黑子，1：白子
						String strMsg="GAMESTART|";
						if(side==0){
							this.sendMSG(strMsg+"0");
							sgAnother.sendMSG(strMsg+"1");
						 }
						else{
							this.sendMSG(strMsg+"1");
							sgAnother.sendMSG(strMsg+"0");
						} 
						//游戏数据的初始化
						GameService.getgameService().gtables[index].resetData();
					}
				}
				else if(comms[0].equals("SETPOS")){
					//// 发送格式：SETPOS|桌号|座位号|行|列|棋子类型	
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					int iColor=Integer.parseInt(comms[5]);
					int i=Integer.parseInt(comms[3]);
					int j=Integer.parseInt(comms[4]);
					//修改游戏数据
					GameService.getgameService().getGameTable(index).setGameData(i, j,iColor);
					
					
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					
					//出子信息 ，同步到双方的客户端
					//UPDATEPOS|x|y|chessColor|isClick
					String sPos="UPDATEPOS|"+i+"|"+j+"|"+iColor+"|";
					
					sgAnother.sendMSG(sPos+"1");//对方用户的出子数据，并将是否出子改为true
					
					if(GameService.getgameService().isWin(index, i,j, side)){
						//赢棋  
						//向双方通知获胜者的结果     //WIN|side
						this.sendMSG("WIN|"+side);
						sgAnother.sendMSG("WIN|"+side);
					}
					
				}
				else if(comms[0].equals("GAMEOVER")){
					//GAMEOVER@TABLEINDEX@SIDE
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					SocketGame sgAnother=GameService.getgameService().getGameTable(index).getAnotherSocketGame(this);
					 
					//更新游戏桌信息
					GameService.getgameService().getGameTable(index).cancelSide(side);
					//通知对方，我方下线（对方在线时）  //GAMEEXIT|playname|side
					if (sgAnother!=null){
						sgAnother.sendMSG("GAMEEXIT|"+player.getName()+"|"+side);
					}
					//更新游戏桌的信息
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
					//删除Arraylist中的数据
					
					GameService.getgameService().removeList(this);
					this.closeSocket();
					GameService.getgameService().setLogTxt(comms[1]+"已退出连接！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
