package demo.repositories;

import demo.models.Vehicle;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
	
	private final Map<Long, Vehicle> vehicleTableMock = new HashMap<>();
	private Long autoIncrement = 0L;
	
	public Vehicle save(Vehicle vehicle){
	
		if(vehicle.getId() == null){
			autoIncrement++;
			vehicle.setId(autoIncrement);
			vehicleTableMock.put(autoIncrement, vehicle);
		}
		else{
			vehicleTableMock.put(vehicle.getId(), vehicle);
		}
		
		return vehicle;
	}
	
	public Optional<Vehicle> fetchVehicleByNumber(String vehicleNumber){
		for(Vehicle vehicle: vehicleTableMock.values()){
			if(vehicle.getVehicleNo().equals(vehicleNumber)) return Optional.of(vehicle);
		}
		
		return Optional.empty();
	}
	
	public Optional<Vehicle> fetchVehicleById(Long vehicleId){
		if(vehicleTableMock.containsKey(vehicleId)) return Optional.of(vehicleTableMock.get(vehicleId));
		return Optional.empty();
	}
}
