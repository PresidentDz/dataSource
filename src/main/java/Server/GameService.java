package Server;

import java.util.ArrayList;

public class GameService {
	
	GameTable []gtables;
	
	private static final GameService gameservice=new GameService();
	private GameService(){}
	public static GameService getgameService(){
		return gameservice;
	}
	

	//窗口界面操作
	private ServerForm sForm;
	public void setForm(ServerForm sf){
		sForm=sf;
	}
	
	public void setLogTxt(String str){
		sForm.txtLog.append(str+"\r\n");
	}
	
	ArrayList<SocketGame> alOnlines=new ArrayList<SocketGame>();  //存储在线用户
	public synchronized void addList(SocketGame sg){  
		alOnlines.add(sg);
	}
	public synchronized void removeList(SocketGame sg){
		
    	removeList(sg);
	}
	
	//生成游戏桌
	public void genGameTables(int count){
		gtables=new GameTable[count];		
		for (int i = 0; i < gtables.length; i++) {
			gtables[i]=new GameTable();
		}
	}
	//查找游戏桌
	public GameTable getGameTable(int index){
		return gtables[index];
	}
	
	//得到所有游戏桌及选定状况：11_01等
	public String getAllGameTables(){
		String str="";
		for (int i = 0; i < gtables.length; i++) {
			str+=gtables[i].getTableFalgs()+"_";
		}
		return str;      
	}
	
	public void setTableSide(GameTable gtable,int side,SocketGame sg){
		gtable.setSide(side,sg);
    }
	
	//
	public void sendAllSitdownMSG(SocketGame sg,int index,int side,String sFlag){
		
		//UPATETABLES|tabindex|side|flag
		for (int i = 0; i < alOnlines.size(); i++) {
			SocketGame sGame=alOnlines.get(i);
			if(!sGame.equals(sg)){
				sGame.sendMSG("UPATETABLES|"+index+"|"+side+"|"+sFlag);
			}
		}
		
	}
	
	//判断输赢
    public boolean isWin(int index,int x, int y, int Side) {
		// =======对水平方向的连接棋子数进行判断
    	int [][]GameData=gtables[index].getGameData();
    	//int chess=GameData[x][y];
    	//判断落子的位置是否是将或帅
    	int side=Side;//获取下棋的一方
    	//0黑方  1红方
    	int count=0;
    	//System.out.println(side+"win");
		if (side==1) {
			for(int i=0;i<=2;i++){
				for(int j=3;j<=5;j++){
				//	System.out.println(GameData[j][i]);
					if(GameData[j][i]==170){
						count++;
					}
				}
			}
		}else if(side==0){
			for(int i=7;i<=9;i++){
				for(int j=3;j<=5;j++){
				//	System.out.println(GameData[j][i]);
					if(GameData[j][i]==270){
						count++;
					}
				}
			}
		}
	//	System.out.println("side:"+side+"count:"+count);
		if(count==0)
			return true;
		else
			return false;
		
	}
}
