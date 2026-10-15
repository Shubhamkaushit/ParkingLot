package demo.dtos;

import demo.models.Gate;
import demo.models.Operator;
import demo.models.Spot;
import demo.models.Vehicle;
import demo.models.enums.ResponseStatus;

import java.util.Date;

public class GenerateTicketResponseDto {
	private Long id;
	private Vehicle vehicle;
	private Gate entryGate;
	private Operator operator;
	private Date entryTime;
	private Spot assignedSpot;
	private ResponseStatus responseStatus;
	private String message;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
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
	
	@Override
	public String toString() {
		return "GenerateTicketResponseDto{" +
			"id=" + id +
			", vehicle=" + vehicle +
			", entryGate=" + entryGate +
			", operator=" + operator +
			", entryTime=" + entryTime +
			", assignedSpot=" + assignedSpot +
			", responseStatus=" + responseStatus +
			", message='" + message + '\'' +
			'}';
	}
}
