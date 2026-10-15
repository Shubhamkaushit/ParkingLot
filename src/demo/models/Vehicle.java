package demo.models;

import demo.models.enums.VehicleType;

public class Vehicle extends BaseModel{
	private String vehicleNo;
	private VehicleType vehicleType;
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
