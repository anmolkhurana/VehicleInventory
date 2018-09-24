package com.accionlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accionlabs.DTO.Response;
import com.accionlabs.DTO.VehicleData;
import com.accionlabs.services.InventoryService;

@RestController
@RequestMapping("/vehicleInventory")
@CrossOrigin
public class VehicleController {
	
		@Autowired
		private InventoryService inventoryService;
		
		@RequestMapping(value="/getAllVehicle",method = RequestMethod.GET)
		public Response getAllVehicles() {
			return inventoryService.getAllVehicles();
		}
		
		@RequestMapping(value = "/getSingleVehicle/{id}", method = RequestMethod.GET)
		public Response getVehicle(@PathVariable("id") int id) {
			return inventoryService.getSingleVehicle(id);
		}
		
		@RequestMapping(value="/insertVehicle",method = RequestMethod.POST)   
		public Response insertVehicle(@RequestBody VehicleData vehicle) {
			return inventoryService.insertVehicle(vehicle);
		}
		
		@RequestMapping(value="/updateVehicle", method = RequestMethod.PUT)
		public Response updateVehicle(@RequestBody VehicleData vehicle) {
			return inventoryService.updateVehicle(vehicle);
		}
		
		
		@RequestMapping(value="/deleteVehicle/{id}", method = RequestMethod.DELETE)
		public Response deleteVehicle(@PathVariable("id") int id) {
			return inventoryService.deleteVehicle(id);
		}
		
		@RequestMapping(value="/deleteLastVehicle", method= RequestMethod.DELETE)
		public Response deleteLastVehicle() {
			return inventoryService.deleteLastVehicle();
		}
		
		@RequestMapping(value = "/searchVehicleOnType", method = RequestMethod.GET)
		public Response searchVehicleOnType(@RequestParam("searchQuery") String searchQuery) {
			return inventoryService.searchVehicle(searchQuery);
		}
}
