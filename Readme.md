# Vehicle Inventory System

End Points: 

1) Get all vehicles
Method : GET
```
$ curl http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/getAllVehicle
```
2) Get single vehicle
Method: Get
```
$ curl http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/getSingleVehicle/5
```

3) Insert a vehicle
Method:POST
```
$ curl --header "Content-Type: application/json" --request POST --data '{"type":"car","makeYear":2018,"price":450000}'
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/insertVehicle
```

4) Update a vehicle
Method:PUT
```
$ curl --header "Content-Type: application/json" --request PUT --data '{"id":5,"type":"car","makeYear":2015,"price":115000}' 
http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/updateVehicle
```

5) Delete a vehicle
Method:DELETE
```
$ curl --request DELETE http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/deleteVehicle/5
```

6) Delete last vehicle
Method: DELETE
```
$ curl --request DELETE http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/deleteLastVehicle
```
7) Search based on type
Method: GET
```
$ curl http://localhost:6161/accionlabs-vehicle-service/vehicleInventory/searchVehicleOnType?searchQuery="b"
```


## SQL Query (H2 Database):

```
CREATE TABLE vehicle (
	id IDENTITY,
	type VARCHAR(25),
    makeyear INTEGER(10),
    price DECIMAL(5,2),
    mode VARCHAR(25),
    maxspeed INT,
	CONSTRAINT vehicleId PRIMARY KEY (id)
);
```
