package com.accionlabs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accionlabs.entity.Vehicle;

@Repository
public interface VehicleDao {
		
		List<Vehicle> getAllVehicles();
		Vehicle getSingleVehicle(int id);
		Vehicle getLast();
		void insertVehicle(Vehicle vehicle);
		void updateVehicle(Vehicle vehicle);
		void deleteVehicle(int id);
		void deleteLastVehicle();
		List<Vehicle> searchVehicle(String searchQuery);
}
