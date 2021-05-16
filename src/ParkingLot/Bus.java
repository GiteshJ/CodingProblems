package ParkingLot;

import java.util.ArrayList;

public class Bus extends Vehicle{

	public Bus() {
		parkingSpots = new ArrayList<>();
		spotsNeeded = 5;
		size = VehicleSize.LARGE;
		
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSpotSize() == this.getVehicleSize();
	}
	
	public void print() {
		System.out.print("B");
	}
}
