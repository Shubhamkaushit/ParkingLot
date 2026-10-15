package demo.repositories;

import demo.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

	private final Map<Long, Ticket> ticketTableMock = new HashMap<>();
	private Long autoIncrement = 0L;
	
	public Ticket save(Ticket ticket){
		if (ticket.getId() == null){
			autoIncrement++;
			ticket.setId(autoIncrement);
			ticketTableMock.put(autoIncrement, ticket);
		}
		else{
			ticketTableMock.put(ticket.getId(), ticket);
		}
		
		return ticket;
	}
}
