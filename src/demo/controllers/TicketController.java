package demo.controllers;

import demo.dtos.GenerateTicketRequestDto;
import demo.dtos.GenerateTicketResponseDto;
import demo.models.Ticket;
import demo.models.enums.ResponseStatus;
import demo.services.TicketService;

public class TicketController {
	
	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
		
		GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
		
		try {
			Ticket ticket = ticketService.generateTicket(requestDto);
			generateTicketResponseDto = convertToResponseTicketDto(ticket);
			generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
		} catch (Exception e) {
			generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
			generateTicketResponseDto.setMessage(e.getMessage());
		}
		return generateTicketResponseDto;
	}
	
	public GenerateTicketResponseDto convertToResponseTicketDto(Ticket ticket){
		
		GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
		generateTicketResponseDto.setId(ticket.getId());
		generateTicketResponseDto.setAssignedSpot(ticket.getAssignedSpot());
		generateTicketResponseDto.setEntryGate(ticket.getEntryGate());
		generateTicketResponseDto.setEntryTime(ticket.getEntryTime());
		generateTicketResponseDto.setOperator(ticket.getOperator());
		generateTicketResponseDto.setVehicle(ticket.getVehicle());
		
		return generateTicketResponseDto;
	}
}
