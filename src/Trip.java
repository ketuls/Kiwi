
public class Trip {
	static int count =0;
	private Cab c;
	private Rider r;
	private int tripId;
	private Location start;
	private Location stop;
	private int status; //status is 0 if rider is not in and 1 if rider is in and 2 if it is completed.
	
	Trip(Cab c, Rider r, Location start, Location stop){
		this.c = c;
		this.r = r;
		this.start = start;
		this.stop = stop;
		status = 0; //Trip is started
		count +=1;
		this.tripId = count; 
	}

	public Location getStart() {
		return start;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	public Location getStop() {
		return stop;
	}

	public void setStop(Location stop) {
		this.stop = stop;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public Cab getCab() {
		return c;
	}

	public void setCab(Cab c) {
		this.c = c;
	}

	public Rider getRider() {
		return r;
	}

	public void setRider(Rider r) {
		this.r = r;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
