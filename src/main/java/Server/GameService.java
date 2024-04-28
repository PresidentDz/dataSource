package Server;

import java.util.ArrayList;

public class GameService {
	
	GameTable []gtables;
	
	private static final GameService gameservice=new GameService();
	private GameService(){}
	public static GameService getgameService(){
		return gameservice;
	}
	

	//���ڽ������
	private ServerForm sForm;
	public void setForm(ServerForm sf){
		sForm=sf;
	}
	
	public void setLogTxt(String str){
		sForm.txtLog.append(str+"\r\n");
	}
	
	ArrayList<SocketGame> alOnlines=new ArrayList<SocketGame>();  //�洢�����û�
	public synchronized void addList(SocketGame sg){  
		alOnlines.add(sg);
	}
	public synchronized void removeList(SocketGame sg){
		
    	removeList(sg);
	}
	
	//������Ϸ��
	public void genGameTables(int count){
		gtables=new GameTable[count];		
		for (int i = 0; i < gtables.length; i++) {
			gtables[i]=new GameTable();
		}
	}
	//������Ϸ��
	public GameTable getGameTable(int index){
		return gtables[index];
	}
	
	//�õ�������Ϸ����ѡ��״����11_01��
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
	
	//�ж���Ӯ
    public boolean isWin(int index,int x, int y, int Side) {
		// =======��ˮƽ��������������������ж�
    	int [][]GameData=gtables[index].getGameData();
    	//int chess=GameData[x][y];
    	//�ж����ӵ�λ���Ƿ��ǽ���˧
    	int side=Side;//��ȡ�����һ��
    	//0�ڷ�  1�췽
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
