package ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {

	ArrayList<ParkingSpot> parkingSpots;
	String licensePlate;
	int spotsNeeded;
	VehicleSize size;
	
	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	
	public VehicleSize getVehicleSize() {
		return size;
	}
	
	public void parkInSpot(ParkingSpot spot) {
		parkingSpots.add(spot);
	}
	
	public void clearSpot() {
		parkingSpots.stream().forEach(spot -> spot.removeVehicle());
		parkingSpots.clear();
	}
	
	public abstract boolean canFitInSpot(ParkingSpot spot);
	public abstract void print();
	
}
