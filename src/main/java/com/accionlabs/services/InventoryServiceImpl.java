package com.accionlabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accionlabs.DTO.Response;
import com.accionlabs.DTO.VehicleData;
import com.accionlabs.container.VehicleContainer;
import com.accionlabs.dao.VehicleDao;
import com.accionlabs.entity.Vehicle;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	Response response;
	
	public Vehicle getVehicleModel(VehicleData v) {
		v = VehicleContainer.getVehicle(v);
		Vehicle vehicle = new Vehicle();
		vehicle.setType(v.getType());
		vehicle.setMakeYear(v.getMakeYear());
		vehicle.setPrice(v.getPrice());
		vehicle.setMode(v.getMode());
		vehicle.setMaxSpeed(v.getMaxSpeed());
		return vehicle;
	}
	
	@Override
	public Response getAllVehicles() {
		try {
			
		response.setStatus("success");
		response.setCode(200);
		response.setMessage("");
		response.setData(vehicleDao.getAllVehicles());
		}catch (Exception e) {
		response.setStatus("error");
		response.setCode(500);
		response.setMessage("Failed");
		response.setData(null);
	}
		
	return response;
	}

	@Override
	public Response getSingleVehicle(int id) {
		try {
			Vehicle vehicle = vehicleDao.getSingleVehicle(id);
			if(vehicle!=null) {
				response.setCode(200);
				response.setMessage("");
				response.setData(vehicle);
			}else {
				response.setCode(204);
				response.setData(null);
				response.setMessage("No record found");
				response.setData(null);
			}
			    response.setStatus("success");
		}catch(Exception e) {
			    response.setStatus("error");
			    response.setCode(500);
			    response.setMessage("Failed");
			    response.setData(null);
		}
		return response;
	}

	@Override
	public Response insertVehicle(VehicleData vehicleData) {
		try {
			Vehicle vehicle = getVehicleModel(vehicleData);
			vehicleDao.insertVehicle(vehicle);
			response.setCode(201);
			response.setStatus("Success");
			response.setMessage("Insertion Successfull");
			response.setData(null);
		}catch(Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response updateVehicle(VehicleData vehicleData) {
		try {
			Vehicle vehicle = getVehicleModel(vehicleData);
			vehicle.setId(vehicleData.getId());
			vehicleDao.updateVehicle(vehicle);
			response.setStatus("success");
			response.setCode(200);
			response.setData(null);
			response.setMessage("Updated Successfully");
		}catch(Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response deleteVehicle(int id) {
		try {
			vehicleDao.deleteVehicle(id);
			response.setStatus("success");
			response.setCode(204);
			response.setMessage("Deleted Successfully");
		}catch(Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response deleteLastVehicle() {
		try {
			vehicleDao.deleteLastVehicle();
			response.setStatus("success");
			response.setCode(204);
			response.setMessage("Last Recod Deleted Successfully");
			
		}catch(Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response searchVehicle(String searchQuery) {
		try {
			response.setCode(200);
			response.setStatus("success");
			response.setData(vehicleDao.searchVehicle(searchQuery));
		}catch(Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed");
			response.setData(null);
		}
		return response;
	}
}
