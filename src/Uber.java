import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uber {

	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Manager m = new Manager();
			boolean flag = true;
			while(flag){
				System.out.println();
				System.out.println("**********************************");
				System.out.println("Welcome to UBER servie.........");
				System.out.println("Press 1 to add Rider");
				System.out.println("Press 2 to add Cab");
				System.out.println("Press 3 to book a ride");
				System.out.println("Press 4 to start a ride");
				System.out.println("Press 5 to stop a ride");
				System.out.println("Press 6 to list all riders");
				System.out.println("Press 7 to list all cabs");
				System.out.println("Press 8 to list all trips");
				System.out.println("Press 9 to Exit");
				System.out.println();
				int option = Integer.parseInt(br.readLine());
				switch(option){
				case 1:
					System.out.println("You Selected to Add New Rider");
					System.out.println("Enter name : ");
					int id = m.addRider(br.readLine());
					System.out.println("Rider Added " + id);
					break;
				case 2:
					System.out.println("You Selected to Add Cab");
					System.out.println("Enter name : ");
					String n = br.readLine();
					System.out.println("Enter Location X  : ");
					int x = Integer.parseInt(br.readLine());
					System.out.println("Enter Location Y  : ");
					int y = Integer.parseInt(br.readLine());
					Location l = new Location(x, y);
					int cid = m.addCab(n, l);
					System.out.println("Cab Added " + cid);
					break;
				case 3:
					System.out.println("You Selected to Book ride");
					System.out.println("Enter Rider Id : ");
					int rid = Integer.parseInt(br.readLine());
					System.out.println("Enter Rider Pickup Location X  : ");
					 x = Integer.parseInt(br.readLine());
					System.out.println("Enter Rider Pickup Location Y  : ");
					 y = Integer.parseInt(br.readLine());
					Location pickUp = new Location(x, y);
					System.out.println("Enter Rider Drop Location X  : ");
					x = Integer.parseInt(br.readLine());
					System.out.println("Enter Rider Drop Location Y  : ");
					y = Integer.parseInt(br.readLine());
					Location drop = new Location(x, y);
					Trip t  = m.requestRide(rid, pickUp, drop);
					if(t != null)
					{
						System.out.println("Ride request Complete");
						System.out.println("Trip id is " + t.getTripId());
						System.out.println("Cab id is " + t.getCab().getId());
					}else{
						System.out.println("Sorry Request Not Completed");
					}
					
					break;
				case 4:
					System.out.println("You Selected to Start a ride");
					System.out.println("Enter Trip Id : ");
					int tid = Integer.parseInt(br.readLine());
					if(m.startRide(tid))
						System.out.println("Trip started for Trip id " + tid);
					else
						System.out.println("Sorry Request Not Completed");
					break;
				case 5:
					System.out.println("You Selected to Stop a ride");
					System.out.println("Enter Trip Id : ");
					tid = Integer.parseInt(br.readLine());
					if(m.stopRide(tid))
						System.out.println("Trip Completed for Trip id " + tid);
					else
						System.out.println("Sorry Request Not Completed");
					break;
				case 6:
					System.out.println("You Selected to List All Riders");
					m.listAllRiderStatus();
					break;
				case 7:
					System.out.println("You Selected to List All Cabs");
					m.listAllCabStatus();
					break;
				case 8:
					System.out.println("You Selected to List All Trips");
					m.listAllOnGoingTrips();
					break;
				case 9:
					System.out.println("Thanks for using Uber "); 
					System.out.println("Exiting...");
					flag = false;
					break;
				}
				
			}
			br.close();
		}catch(Exception e){
			System.out.println("Sorry due to technical glitch, your request failed ");
			e.printStackTrace();
		}

	}

}
