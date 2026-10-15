package demo.services.strategies;

import demo.models.Gate;
import demo.models.Spot;
import demo.models.enums.VehicleType;

import java.util.Optional;

public interface ParkingSpotAllocationStrategy {

	Optional<Spot> assignParkingSpot(Gate gate, VehicleType vehicleType);
}
