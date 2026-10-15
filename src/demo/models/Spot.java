package demo.models;

import demo.models.enums.SpotStatus;
import demo.models.enums.VehicleType;

public class Spot extends BaseModel {
	
	private String number;
	private SpotStatus spotStatus;
	private VehicleType vehicleType;
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public SpotStatus getSpotStatus() {
		return spotStatus;
	}
	
	public void setSpotStatus(SpotStatus spotStatus) {
		this.spotStatus = spotStatus;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
