package UI;

//On appelerai Point (par la suite) un couple de coordonnées X et Y d'un indice dans un board !

public class Indexes {
	private int x;
	private int y;
	
	public Indexes(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}