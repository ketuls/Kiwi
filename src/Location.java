
public class Location {
	private int x;
	private int y;
	Location(int x, int y){
		this.x =x;
		this.y =y;
	}
	
	public static double getDistance(Location l1, Location l2){
		int xd = (l1.x -l2.x);
		int yd = (l1.y -l2.y);
		return Math.sqrt(xd*xd + yd*yd);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
