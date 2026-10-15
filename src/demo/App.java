package demo;

import demo.controllers.TicketController;
import demo.dtos.GenerateTicketRequestDto;
import demo.dtos.GenerateTicketResponseDto;
import demo.models.enums.ResponseStatus;
import demo.models.enums.VehicleType;
import demo.repositories.*;
import demo.services.GateService;
import demo.services.TicketService;
import demo.services.VehicleService;
import demo.services.strategies.NearestEmptySpotStrategy;
import demo.services.strategies.ParkingSpotAllocationStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        
        TicketRepository ticketRepository = new TicketRepository();
        
        TicketService ticketService = getTicketService(ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        
        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(2L);
        requestDto.setVehicleNo("KA01JL1223");
        requestDto.setVehicleType(VehicleType.MEDIUM);
        
        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        if (responseDto.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDto.getMessage());
        }
        else System.out.print("Ticket Generated with details: "+responseDto);
    }
    
    private static TicketService getTicketService(TicketRepository ticketRepository) {
        GateRepository gateRepository = new GateRepository();
        GateService gateService = new GateService(gateRepository);
        
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        BoothRepository boothRepository = new BoothRepository();
        ParkingSpotAllocationStrategy parkingSpotAllocationStrategy =
            new NearestEmptySpotStrategy(parkingLotRepository, boothRepository);
        
        TicketService ticketService = new TicketService(ticketRepository, gateService, vehicleService, parkingSpotAllocationStrategy);
        return ticketService;
    }
}
