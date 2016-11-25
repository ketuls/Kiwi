
public class Cab {

	static int cabCount =0 ;
	private String name;
	private int id;
	//Status 0 is free, 1 is on the route to pickup, 2 is on the trip
	private int status;
	private Location currentLocation; 

	Cab(String name, Location l){
		this.name=name;
		cabCount += 1;
		this.id = cabCount;
		this.currentLocation = l;
		this.status = 0;
	}

	public String getName() {
		return name;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int s) {
		status = s;
	}
	public int getId() {
		return id;
	}
	
	public Location getLocation(){
		return currentLocation;
	}
	
	public void setLocation(Location l){
		currentLocation = l;
	}
	
}
