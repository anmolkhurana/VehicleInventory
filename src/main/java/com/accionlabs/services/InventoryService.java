package com.accionlabs.services;

import org.springframework.stereotype.Service;

import com.accionlabs.DTO.Response;
import com.accionlabs.DTO.VehicleData;

@Service
public interface InventoryService {
		
	Response getAllVehicles();
	Response getSingleVehicle(int id);
	Response insertVehicle(VehicleData vehicle);
	Response updateVehicle(VehicleData vehicle);
	Response deleteVehicle(int id);
	Response deleteLastVehicle();
	Response searchVehicle(String searchQuery);
}
