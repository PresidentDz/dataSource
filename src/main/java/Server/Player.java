package Server;

public class Player {
	private String name;
	private float score;
	private boolean isReady;
	private int playside=-1;   //������һ�� 0����ߺڷ�  ��1���ұ߰׷�
	public int getPlayside() {
		return playside;
	}
	public void setPlayside(int playside) {
		this.playside = playside;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
}
