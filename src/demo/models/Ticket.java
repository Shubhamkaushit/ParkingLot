package demo.models;

import java.util.Date;

public class Ticket extends BaseModel{
	private Vehicle vehicle;
	private Gate entryGate;
	private Operator operator;
	private Date entryTime;
	private Spot assignedSpot;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Gate getEntryGate() {
		return entryGate;
	}
	
	public void setEntryGate(Gate entryGate) {
		this.entryGate = entryGate;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public Date getEntryTime() {
		return entryTime;
	}
	
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	
	public Spot getAssignedSpot() {
		return assignedSpot;
	}
	
	public void setAssignedSpot(Spot assignedSpot) {
		this.assignedSpot = assignedSpot;
	}
}
