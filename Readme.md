Vehicle Inventory System

End Points: 

1) Get all vehicles
Method : GET
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/getAllVehicle

2) Get single vehicle
Method: Get
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/getSingleVehicle/6

3)Insert a vehicle
Method:POST
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/insertVehicle

4)Update a vehicle
Method:PUT
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/updateVehicle

5)Delete a vehicle
Method:DELETE
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/deleteVehicle/6

6)Delete last vehicle
Method: DELETE
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/deleteLastVehicle

7)Search based on type
Method: GET
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/searchVehicleOnType?searchQuery="b"



SQL Query (H2 Database):

CREATE TABLE vehicle (
	id IDENTITY,
	type VARCHAR(25),
    makeyear INTEGER(10),
    price DECIMAL(5,2),
    mode VARCHAR(25),
    maxspeed INT,
	CONSTRAINT vehicleId PRIMARY KEY (id)
);
