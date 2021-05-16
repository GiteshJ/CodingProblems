package ParkingLot;

public class ParkingLot {
	public int NUM_OF_LEVELS = 5;
	public int NUM_OF_SPOTS = 30;
	Level[] levels;
	
	public ParkingLot() {
		levels = new Level[NUM_OF_LEVELS];
		for(int i=0;i<levels.length;i++) {
			levels[i] = new Level(i+1,NUM_OF_SPOTS);
		}
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		
		for(int i=0;i<levels.length;i++) {
			if(levels[i].parkVehicle(vehicle)) return true;
		}
		return false;
		
	}
	
	public void print() {
		for (int i = 0; i < levels.length; i++) {
			System.out.print("Level - " + (i+1) + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}
	

}
