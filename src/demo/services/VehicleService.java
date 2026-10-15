package demo.services;

import demo.models.Vehicle;
import demo.models.enums.VehicleType;
import demo.repositories.VehicleRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleService {
	
	VehicleRepository vehicleRepository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
	
	public Vehicle getVehicle(String vehicleNo, VehicleType vehicleType){
		
		Optional<Vehicle> vehicleWrapper = vehicleRepository.fetchVehicleByNumber(vehicleNo);
		
		if (vehicleWrapper.isEmpty()){
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleNo(vehicleNo);
			vehicle.setVehicleType(vehicleType);
			
			return vehicleRepository.save(vehicle);
		}
		else{
			return vehicleWrapper.get();
		}
	}
}
