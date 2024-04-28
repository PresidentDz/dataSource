package Client;

public class Player {
	private String name;
	private int playside=-1;   //×øÔÚÄÇÒ»±ß
	public int getPlayside() {
		return playside;
	}
	public void setPlayside(int playside) {
		this.playside = playside;
	}
	private float score;
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
