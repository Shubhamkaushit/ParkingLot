package demo.services.strategies;

import demo.models.Gate;
import demo.models.ParkingLot;
import demo.models.Spot;
import demo.models.enums.SpotStatus;
import demo.models.enums.VehicleType;
import demo.repositories.BoothRepository;
import demo.repositories.ParkingLotRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FarthestEmptySpotStrategy {
	
	private ParkingLotRepository parkingLotRepository;
	private BoothRepository boothRepository;
	
	public FarthestEmptySpotStrategy(ParkingLotRepository parkingLotRepository, BoothRepository boothRepository) {
		this.parkingLotRepository = parkingLotRepository;
		this.boothRepository = boothRepository;
	}
	
	public Optional<Spot> assignParkingSpot(Gate gate, VehicleType vehicleType){
		ParkingLot parkingLot = parkingLotRepository.fetchByGateId(gate.getId());
		List<Spot> spots = boothRepository.fetchAllSpotsByParkingLot(parkingLot.getId());
		
		Collections.reverse(spots);
		
		for(Spot spot: spots){
			if(spot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
			spot.getVehicleType().equals(vehicleType)){
				return Optional.of(spot);
			}
		}
		
		return Optional.empty();
	}
}
