import java.util.HashMap;

public class Manager implements TravelManager{

	HashMap<Integer, Rider> riderList = new HashMap<Integer,Rider>();
	HashMap<Integer, Cab> cabList = new HashMap<Integer,Cab>();
	HashMap<Integer, Trip> tripList = new HashMap<Integer, Trip>();
	@Override
	public int addRider(String riderName) {
		Rider r = new Rider(riderName);
		riderList.put(r.getId(),r);
		return r.getId();
	}

	@Override
	public int addCab(String cabName, Location current) {
		Cab c = new Cab(cabName,current);
		cabList.put(c.getId(), c);
		return c.getId();
	}

	@Override
	public Trip requestRide(int riderId, Location pickup, Location drop) {
		Rider r = riderList.get(riderId);
		if(r.getStatus()!=0)
		{
			System.out.println("Rider is already Travelling/Waiting ");
			return null;
		}
		Cab freeCab = getNearbyFreeCab(pickup);
		if(freeCab == null){
			System.out.println("No Cabs Available");
			return null;
		}
		Trip t = new Trip(freeCab, r,pickup,drop);
		freeCab.setStatus(1); // Cab is on the way
		r.setStatus(1); // rider is waiting
		tripList.put(t.getTripId(),t);
		return t;
	}
	
	public Cab getNearbyFreeCab(Location pickup){
		double dist =Integer.MAX_VALUE;
		int freeCabId = -1;
		for(Integer cabId:cabList.keySet()){
			Cab c = cabList.get(cabId);
			if(c.getStatus() == 0)
			{
				double td  = Location.getDistance(pickup,c.getLocation());
				if(td < dist){
					dist = td;
					freeCabId = cabId; 
				}
			}
		}
		if(freeCabId == -1) return null;
		return cabList.get(freeCabId);
	}

	@Override
	public boolean startRide(int tripId) {
		Trip ct = tripList.get(tripId);
		if(ct.getStatus() != 0){
			System.out.println("This Trip Can not be started ");
			return false;
		}
		ct.getCab().setStatus(1);
		ct.getCab().setLocation(ct.getStart());
		ct.getRider().setStatus(2);
		ct.setStatus(1);
		return true;
	}

	@Override
	public boolean stopRide(int tripId) {
		Trip ct = tripList.get(tripId);
		if(ct.getStatus() != 1){
			System.out.println("This Trip Can not be stopped ");
			return false;
		}
		ct.getCab().setStatus(0);
		ct.getCab().setLocation(ct.getStop());
		ct.getRider().setStatus(0);
		ct.setStatus(2);
		return true;
	}

	@Override
	public boolean listAllCabStatus() {
		for(Integer id:cabList.keySet()){
			Cab c = cabList.get(id);
			System.out.println("-----------------------------------------------");
			System.out.println("Cab Id is " + c.getId() );
			System.out.println("Cab Name is " + c.getName());
			System.out.println("Cab Location is " + c.getLocation().getX() + " " + c.getLocation().getY() );
			if(c.getStatus() ==0)
				System.out.println("Cab is Free");
			else if(c.getStatus() ==1){
				System.out.println("Cab is on the way to pickup");
			}else{
				System.out.println("Cab is on the trip with rider");
			}
			System.out.println("-----------------------------------------------");
			System.out.println();
		}
		return true;
	}

	@Override
	public boolean listAllRiderStatus() {
		for(Integer id:riderList.keySet()){
			Rider r = riderList.get(id);
			System.out.println("-----------------------------------------------");
			System.out.println("Rider Id is " + r.getId() );
			System.out.println("Rider Name is " + r.getName());
			if(r.getStatus() ==0)
				System.out.println("Rider is not travelling and is in initial stage");
			else if(r.getStatus() ==1){
				System.out.println("Rider is waiting for the Cab");
			}else{
				System.out.println("Rider is travelling in the Cab");
			}
			System.out.println("-----------------------------------------------");
			System.out.println();
			
		}
		return true;
	}

	@Override
	public boolean listAllOnGoingTrips() {
		for(Integer id:tripList.keySet()){
			Trip t = tripList.get(id);
			System.out.println("-----------------------------------------------");
			System.out.println("Trip Id is " + t.getTripId() );
			System.out.println("Trip Start Location " + t.getStart().getX() + "  " + t.getStart().getY());
			System.out.println("Trip Stop Location " + t.getStop().getX() + "  " + t.getStop().getY());
			System.out.println("Rider is " + t.getRider().getId() + "  " + t.getRider().getName());
			System.out.println("Cab is " + t.getCab().getId() + "  " + t.getCab().getName());
			if(t.getStatus() ==0)
				System.out.println("Trip Started, Cab is on the way to pick Rider");
			else if(t.getStatus() ==1){
				System.out.println("Trip started, Rider is in the cab");
			}else{
				System.out.println("Trip Completed.");
			}
			System.out.println("-----------------------------------------------");
			System.out.println();
			
		}
		return true;
	}

}
