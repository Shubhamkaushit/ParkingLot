package demo.services;

import demo.dtos.GenerateTicketRequestDto;
import demo.exceptions.BoothNotAvailableException;
import demo.exceptions.GateNotFoundException;
import demo.models.Gate;
import demo.models.Spot;
import demo.models.Ticket;
import demo.models.Vehicle;
import demo.repositories.TicketRepository;
import demo.services.strategies.ParkingSpotAllocationStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
	
	TicketRepository ticketRepository;
	GateService gateService;
	VehicleService vehicleService;
	ParkingSpotAllocationStrategy parkingSpotAllocationStrategy;
	
	public TicketService(TicketRepository ticketRepository, GateService gateService,
	                     VehicleService vehicleService, ParkingSpotAllocationStrategy parkingSpotAllocationStrategy) {
		this.ticketRepository = ticketRepository;
		this.gateService = gateService;
		this.vehicleService = vehicleService;
		this.parkingSpotAllocationStrategy = parkingSpotAllocationStrategy;
	}
	
	public Ticket generateTicket(GenerateTicketRequestDto requestDto) throws GateNotFoundException, BoothNotAvailableException {
		
		Gate gate = gateService.getGateById(requestDto.getGateId());
		Vehicle vehicle = vehicleService.getVehicle(requestDto.getVehicleNo(), requestDto.getVehicleType());
		
		Optional<Spot> assignedSpotWrapper = parkingSpotAllocationStrategy.assignParkingSpot(gate, vehicle.getVehicleType());
		
		if (assignedSpotWrapper.isEmpty()) throw new BoothNotAvailableException("Parking Spot not Available");
		
		Ticket ticket = new Ticket();
		
		ticket.setEntryTime(new Date());
		ticket.setEntryGate(gate);
		ticket.setAssignedSpot(assignedSpotWrapper.get());
		ticket.setOperator(gate.getOperator());
		ticket.setVehicle(vehicle);
		
		Ticket savedTicket = ticketRepository.save(ticket);
		
		return ticket;
	}
}
