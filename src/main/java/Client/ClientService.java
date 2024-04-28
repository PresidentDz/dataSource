package Client;

import java.net.*;


public class ClientService {
	private final static ClientService cService=new ClientService();//单例游戏服务对象
	private ClientService(){
		resetData();
	}
	public static ClientService getClientService(){
		return cService;
	}
	
	//操作游戏数据
	private int [][] gameData=new int[9][10];
	public int[][] getGameData(){//获取游戏数据gamedata数组
		return gameData;
	}
	public void setGameData(int i,int j,int posValue){
		gameData[i][j]=posValue;//在第i行j列放置棋子 
	}
	public void resetData(){//重新设置游戏桌的状态
		//棋盘1-5行放置黑棋
		//1行3行4行
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){
				gameData[i][j]=0;
			}
		}
		gameData[0][0]=131;
		gameData[1][0]=141;
		gameData[2][0]=151;
		gameData[3][0]=161;
		gameData[4][0]=170;
		gameData[5][0]=162;
		gameData[6][0]=152;
		gameData[7][0]=142;
		gameData[8][0]=132;
		//3行
		gameData[1][2]=121;
		gameData[7][2]=122;
		//4行卒
		gameData[0][3]=111;
		gameData[2][3]=112;
		gameData[4][3]=113;
		gameData[6][3]=114;
		gameData[8][3]=115;

		//棋盘6-10行放置红旗
		//7行
		gameData[0][6]=211;
		gameData[2][6]=212;
		gameData[4][6]=213;
		gameData[6][6]=214;
		gameData[8][6]=215;
		//8行
		gameData[1][7]=221;
		gameData[7][7]=222;
		//10行
		gameData[0][9]=231;
		gameData[1][9]=241;
		gameData[2][9]=251;
		gameData[3][9]=261;
		gameData[4][9]=270;
		gameData[5][9]=262;
		gameData[6][9]=252;
		gameData[7][9]=242;
		gameData[8][9]=232;
	}
	
	
	//游戏桌操作
	public void genGameTables(String strtables){
		String [] tables=strtables.split("_");
		cWin.setCheckBoxCount(tables.length);  //设置复选框
		for (int i = 0; i < tables.length; i++) {
			String st1=tables[i].charAt(0)+"";
			String st2=tables[i].charAt(1)+"";
			//调用主界面的插入一个游戏桌
			cWin.addTable(i,st1,st2);			
		}
	}
	//更新游戏桌的选定状态
	public void updateGameTable(int tbIndex, int side, String tableFlag){
        
        cWin.updateTable(tbIndex,side,tableFlag);
    }
	
	private ClientForm cWin;
	public void setForm(ClientForm form){
		cWin=form;
	}
	
	private GameForm gForm; 
	public void setgForm(GameForm gf){
		gForm=gf;
	}
	public void setGFormSideName(int side,String sName){
		gForm.lbNames[side].setText(sName);
	}
	
	//设置游戏主界面的消息框
	public void setLogTxt(String str){
		gForm.txtLog.append(str+"\r\n");
	}
	
	public void setbtnStartState(){
		gForm.setBtnStartStat();
	}
	
	//设置游戏界面的点击状态
	public void setGameIsClick(boolean flag){
		gForm.isClick=flag;
	}
	public void setGameIsStart(boolean flag){
		gForm.isStart=flag;
	}
	public void updatePicPanel(){
		gForm.panelDraw.repaint();//重新画棋盘
	}
	
	//连接服务器
	private ClientGame cGame;
	public void connect(String ip,int port,String sName){
		Socket socket=null;
		try {
			socket=new Socket(ip, port);
			cGame=new ClientGame(socket, sName);
			cGame.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//人机对战
	private GameForm meachinegameform;
	public void MeachineGame(GameForm mgf){
		meachinegameform=mgf;
		
	}
	//人机对战函数
		public void meachineGame(){
			gForm=new GameForm(0, 3);
			gForm.setVisible(true);
			ClientService.getClientService().setgForm(gForm);
			//将当前游戏者的名称，设置到游戏主界面中
			ClientService.getClientService().setGFormSideName(0,"Meachine");
			ClientService.getClientService().setGFormSideName(1,"human");
		}
	
	public ClientGame getClientGame(){
		return cGame;
	}
}
