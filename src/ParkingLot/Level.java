package ParkingLot;

public class Level {

	public int floor;
	public ParkingSpot[] spots;
	public int availableSpots;
	public static final int SPOTS_PER_ROW = 10;
	
	public void spotFreed() {
		availableSpots++;
	}
	
	public int availableSpots() {
		return availableSpots;
	}
	
	public Level(int flr, int numOfSpots) {
		
		this.availableSpots = numOfSpots;
		this.floor = flr;
		spots = new ParkingSpot[numOfSpots];
		int largeSpots = numOfSpots/4;
		int bikeSpots = numOfSpots/4;
		int compactSpots = numOfSpots - largeSpots - bikeSpots;
		
		for(int i=0;i<numOfSpots;i++) {
			
			VehicleSize vehSize = VehicleSize.MOTORCYCLE;
			if(i<largeSpots) vehSize = VehicleSize.LARGE;
			else if(i<largeSpots + compactSpots) vehSize = VehicleSize.COMPACT;
			int row = i/SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this,row,i,vehSize);
		}
		
		
	}

	public int findAvailableSpots(Vehicle vehicle) {
		
		int spotsNeeded = vehicle.getSpotsNeeded();
		int spotsFound = 0;
		int lastRow = -1;
		
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (lastRow != spot.getRow()) {
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFitVehicle(vehicle)) {
				spotsFound++;
			} else {
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded) {
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}

	public boolean ParkVehicleAtSpot(int spotNumber, Vehicle vehicle) {
		
		vehicle.clearSpot();
		boolean success = true;
		for(int i=spotNumber;i<spotNumber+vehicle.getSpotsNeeded();i++) {
			success &= spots[i].parkVehicle(vehicle);
		}
		availableSpots -= vehicle.getSpotsNeeded();
		return success;
		
	}
	public boolean parkVehicle(Vehicle vehicle) {
		
		if(availableSpots < vehicle.getSpotsNeeded()) return false;
		
		int spotNumber = findAvailableSpots(vehicle);
		if(spotNumber<0) return false;
		
		return ParkVehicleAtSpot(spotNumber,vehicle);
	}
	
	public void print() {
		int lastRow = -1;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (spot.getRow() != lastRow) {
				System.out.print("  ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
}
