package com.accionlabs.container;

import com.accionlabs.DTO.Airplane;
import com.accionlabs.DTO.Amphibian;
import com.accionlabs.DTO.Boat;
import com.accionlabs.DTO.Car;
import com.accionlabs.DTO.Drone;
import com.accionlabs.DTO.Truck;
import com.accionlabs.DTO.VehicleData;

public class VehicleContainer {
		public static VehicleData getVehicle(VehicleData v) {
			VehicleData vehicle;
			switch (v.getType().toLowerCase()) {
			case "car":
				vehicle = new Car();
				break;
			case "truck":
				vehicle = new Truck();
				break;
			case "airplane":
				vehicle = new Airplane();
				break;
			case "drone":
				vehicle = new Drone();
				break;
			case "amphibian":
				vehicle = new Amphibian();
				break;
			case "boat":
				vehicle = new Boat();
				break;
			default:
				vehicle = new VehicleData();
				break;
			}
			vehicle.setType(v.getType());
			vehicle.setMakeYear(v.getMakeYear());
			vehicle.setPrice(v.getPrice());
			return vehicle;
		}
}
