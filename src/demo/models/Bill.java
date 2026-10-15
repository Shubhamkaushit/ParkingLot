package demo.models;

import java.util.Date;

public class Bill extends BaseModel {
	private int amount;
	private Gate exitGate;
	private Operator operator;
	private Date exitTime;
	private Ticket ticket;
	private String invoiceNumber;
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Gate getExitGate() {
		return exitGate;
	}
	
	public void setExitGate(Gate exitGate) {
		this.exitGate = exitGate;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public Date getExitTime() {
		return exitTime;
	}
	
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
}
