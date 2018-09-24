package com.accionlabs.testcontroller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accionlabs.DTO.Response;
import com.accionlabs.controller.VehicleController;
import com.accionlabs.entity.Vehicle;
import com.accionlabs.services.InventoryService;
import com.accionlabs.testconfig.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestController {
	
	private MockMvc mockMvc;
	
	@Mock
	private InventoryService inventoryService;
	
	@InjectMocks
	private VehicleController vehicleController;
	
	@Before
	public void init() throws Exception{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
	}
	
	@Test
	public void testGetAllVehicles() throws Exception {
		List<Vehicle> list = new ArrayList<Vehicle>();
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		list.add(vehicle);
		vehicle.setId(2);
		list.add(vehicle);
		vehicle.setId(3);
		list.add(vehicle);
		
		Response response = new Response();
		response.setCode(200);
		response.setStatus("success");
		response.setMessage("Inserted successfully");
		response.setData(list);
		
		when(inventoryService.getAllVehicles()).thenReturn(response);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/vehicleInventory/getAllVehicle")
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(jsonPath("$.code").value(200))
		        .andExpect(jsonPath("$.status").value("success"))
		        .andExpect(jsonPath("$.message").value("Inserted successfully"))
		        .andExpect(jsonPath("$.data").isArray());
		        
		verify(inventoryService).getAllVehicles();        
	}
}
