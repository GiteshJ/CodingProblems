package ParkingLot;

import java.util.ArrayList;

public class MotorCycle extends Vehicle{
	
	public MotorCycle() {
		parkingSpots = new ArrayList<>();
		spotsNeeded = 1;
		size = VehicleSize.MOTORCYCLE;
		
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}
	
	public void print() {
		System.out.print("M");
	}
	
	
}
