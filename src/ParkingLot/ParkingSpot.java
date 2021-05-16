package ParkingLot;



public class ParkingSpot {

	VehicleSize spotSize;
	Vehicle vehicle;
	int row;
	int spotNumber;
	Level level;
	
	public ParkingSpot(Level level,int row, int spotNumber, VehicleSize spotSize) {
		this.spotNumber = spotNumber;
		this.row = row;
		this.spotSize = spotSize;
		this.level = level;
		
	}
	
	public boolean isAvailable() {
		return this.vehicle==null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		if(!canFitVehicle(vehicle)) return false;
		this.vehicle = vehicle;
		this.vehicle.parkInSpot(this);
		return true;
	}
	
	public int getRow() {
		 return this.row;
	}
	
	public int getSpotNumber() {
		return this.spotNumber;
	}
	public VehicleSize getSpotSize() {
		return spotSize;
	}
	
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}
	
	public void print() {
		if (vehicle == null) {
			if (spotSize == VehicleSize.COMPACT) {
				System.out.print("c");
			} else if (spotSize == VehicleSize.LARGE) {
				System.out.print("l");
			} else if (spotSize == VehicleSize.MOTORCYCLE) {
				System.out.print("m");
			}
		} else {
			vehicle.print();
		}
	}
}
