
public class Rider {
	static int riderCount =0 ;
	private String name;
	private int id;
	private int status; // 0 mean initial state, 1 means waiting/requestedCab, 2 means in the Cab/travelling

	Rider(String name){
		this.name=name;
		riderCount += 1;
		status = 0;
		this.id = riderCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
