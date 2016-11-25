
public interface TravelManager {
		int addRider(String riderName);
		int addCab(String cabName, Location current);
		Trip requestRide(int riderId, Location pickup, Location drop);
		//Cab requestRide(Location pickup, Location drop, CabType c);
		boolean	startRide(int tripId);
		boolean	stopRide(int tripId);
		boolean listAllCabStatus();
		boolean listAllRiderStatus();
		boolean listAllOnGoingTrips();
		
}
