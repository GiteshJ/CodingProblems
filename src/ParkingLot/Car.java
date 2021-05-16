package ParkingLot;

import java.util.ArrayList;

public class Car extends Vehicle{

	
	public Car() {
		parkingSpots = new ArrayList<>();
		spotsNeeded = 1;
		size = VehicleSize.COMPACT;
		
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSpotSize() == this.getVehicleSize() || spot.getSpotSize() == VehicleSize.LARGE;
	}
	
	public void print() {
		System.out.print("C");
	}
	
}
