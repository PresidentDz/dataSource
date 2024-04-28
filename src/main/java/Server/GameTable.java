package Server;

public class GameTable {

	
	private int [][] GameData=new int[9][10];
	private SocketGame [] socketgames=new SocketGame[2];
	private String seatFlag="00";  //��ʾ��Ϸ����ռ����� 00��������10��01��11
	
	//�õ���Ϸ����ռ�����
	public String getTableFalgs(){
		return seatFlag;
	}
	
	//ͨ������ֵ�õ���Ϸ�������е�Socket����
	public SocketGame getSocketGameByIndex(int index){
		return socketgames[index];
	}
	
	//�õ���Ϸ���жԷ���Socket����
	public SocketGame getAnotherSocketGame(SocketGame curr){
		for (int i = 0; i < socketgames.length; i++) {
			SocketGame socket=socketgames[i];
			if(socket!=curr)
				return socket;
		}
		return null;
	}
	
	public void setTableFlags(int side,char flag){
		//side�ߣ�flag0��ʾ������1����
		if(side==0){
			seatFlag=flag+""+seatFlag.charAt(side+1);
        }
        else{
            seatFlag=seatFlag.charAt(side-1)+""+flag;
        }
    }
	
	//���±��
	public void setSide(int side, SocketGame sg){
		//side:0��1
		socketgames[side]=sg;
		setTableFlags(side,'1');
    }
	public void cancelSide(int side){
		//side:0��1
		socketgames[side]=null;
		setTableFlags(side,'0');
    }
	
	//��Ϸ����
    public void resetData(){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				GameData[i][j]=0;
			}			
		}
		GameData[0][0]=131;
		GameData[1][0]=141;
		GameData[2][0]=151;
		GameData[3][0]=161;
		GameData[4][0]=170;
		GameData[5][0]=162;
		GameData[6][0]=152;
		GameData[7][0]=142;
		GameData[8][0]=132;
		//3��
		GameData[1][2]=121;
		GameData[7][2]=122;
		//4����
		GameData[0][3]=111;
		GameData[2][3]=112;
		GameData[4][3]=113;
		GameData[6][3]=114;
		GameData[8][3]=115;

		//����6-10�з��ú���
		//7��
		GameData[0][6]=211;
		GameData[2][6]=212;
		GameData[4][6]=213;
		GameData[6][6]=214;
		GameData[8][6]=215;
		//8��
		GameData[1][7]=221;
		GameData[7][7]=222;
		//10��
		GameData[0][9]=231;
		GameData[1][9]=241;
		GameData[2][9]=251;
		GameData[3][9]=261;
		GameData[4][9]=270;
		GameData[5][9]=262;
		GameData[6][9]=252;
		GameData[7][9]=242;
		GameData[8][9]=232;
	}
    public int [][]getGameData(){
    	return GameData;
    }
    
    public void setGameData(int i,int j,int posValue){
    	GameData[i][j]=posValue;
	}
}
