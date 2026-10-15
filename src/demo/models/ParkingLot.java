package demo.models;

import demo.models.enums.VehicleType;

import java.util.List;
import java.util.Map;

public class ParkingLot extends BaseModel {
	
	private String address;
	private List<Spot> spots;
	private List<Gate> gates;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Spot> getSpots() {
		return spots;
	}
	
	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}
	
	public List<Gate> getGates() {
		return gates;
	}
	
	public void setGates(List<Gate> gates) {
		this.gates = gates;
	}
}
