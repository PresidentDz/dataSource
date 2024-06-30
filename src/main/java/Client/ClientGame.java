package Client;
import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;
public class ClientGame extends Thread {
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	Player player;
	
	GameForm gForm;
	
	public ClientGame(Socket socket,String sName) {
		if(!sName.equals("meachine")){
			this.socket=socket;	
				try {
					player=new Player();
					player.setName(sName);
					
					br=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
					pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")));
					
					
					sendMSG("LOGIN|"+sName);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
				if(comms[0].equals("GAMETABLES")){					
					//????????????  GAMETABLES|00_00_11
					ClientService.getClientService().genGameTables(comms[1]);
				}
				else if(comms[0].equals("UPATETABLES")){
					//更新桌面
					//UPATETABLES|tableIndex|side|Flag  
					
					int index=Integer.parseInt(comms[1]);
					int side=Integer.parseInt(comms[2]);
					ClientService.getClientService().updateGameTable(index,side,comms[3]);
					
				}
				else if(comms[0].equals("SITRESULT")){
					//?????????????    SITRESULT|tbindex|side|flag
					String sFlag=comms[3];
				
			    	if (sFlag.equals("1")) {
						//???
			    		int side=Integer.parseInt(comms[2]);
			    		
			    		gForm=new GameForm(Integer.parseInt(comms[1]), side);
			    		gForm.setVisible(true);
			    		ClientService.getClientService().setgForm(gForm);
			    		//????????????????????????????????
			    		ClientService.getClientService().setGFormSideName(side,this.player.getName());
			    		player.setPlayside(side);
					}
			    	else {
						JOptionPane.showMessageDialog(null, "???????? 已重置！");
					}
					
				}
				else if(comms[0].equals("SITDOWN")){
					//	SITDOWN|side|playername
					int side=Integer.parseInt(comms[1]);
					ClientService.getClientService().setGFormSideName(side,comms[2]);
					ClientService.getClientService().setbtnStartState();  
				}
				else if(comms[0].equals("MSG")){
					//MSG|username|msg
					ClientService.getClientService().setLogTxt(comms[1]+":"+comms[2]);
				}
				else if(comms[0].equals("GAMESTART")){
                    //?????????????    GAMESTART@ISCLICK 
					boolean isClick=comms[1].equals("1")?true:false;
					
					ClientService.getClientService().setGameIsClick(isClick);			
				}
				else if (comms[0].equals("UPDATEPOS")) 
				{
					//UPDATEPOS|x|y|chessColor|isClick
					boolean IsClick=comms[4].equals("1")?true:false;
					ClientService.getClientService().setGameIsClick(IsClick);
					
					//???????????????????
					int iColor=Integer.parseInt(comms[3]);//?????????
					int x=Integer.parseInt(comms[1]);//?????????λ??
					int y=Integer.parseInt(comms[2]);
					
					//???????????
					ClientService.getClientService().setGameData(x, y, iColor);
					ClientService.getClientService().updatePicPanel();					
					
				}
				else if (comms[0].equals("WIN")) 
				{
					//WIN|side
					String strInfo=comms[1].equals("0")?"黑方胜！":"红方胜！";
					ClientService.getClientService().setLogTxt(strInfo);
					JOptionPane.showMessageDialog(null, strInfo);
					
					//?????????????ó??
					ClientService.getClientService().setGameIsClick(false);
					ClientService.getClientService().setGameIsStart(false);
					
					//???????
					ClientService.getClientService().resetData();
					ClientService.getClientService().updatePicPanel();
				}
				else if (comms[0].equals("GAMEEXIT")) 
				{
					//GAMEEXIT|playname|side
					int side=Integer.parseInt(comms[2]);
					
					ClientService.getClientService().setLogTxt(comms[1]+"逃跑了！");
					//???????????????
					ClientService.getClientService().setGameIsStart(false);
					ClientService.getClientService().setGameIsClick(false);
					
					ClientService.getClientService().resetData();
					ClientService.getClientService().updatePicPanel();
					
					//???????????????
					ClientService.getClientService().setGFormSideName(side,"");
					//???????????????????
					ClientService.getClientService().setbtnStartState();  
			    	
			    	JOptionPane.showMessageDialog(null, "逃跑了！");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(br!=null)
					br.close();
				if(pw!=null)
					pw.close();
				if(socket!=null)
					socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}
