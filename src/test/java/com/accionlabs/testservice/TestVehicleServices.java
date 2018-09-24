package com.accionlabs.testservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accionlabs.dao.VehicleDao;
import com.accionlabs.entity.Vehicle;
import com.accionlabs.testconfig.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestVehicleServices {
	
	@Mock
	VehicleDao vehicleDao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllVehicles() {
		List<Vehicle> list = new ArrayList<Vehicle>();
		when(vehicleDao.getAllVehicles()).thenReturn(list);
		assertEquals(vehicleDao.getAllVehicles(), list);
	}
	
	@Test
	public void testGetSingleVehicle() {
		Vehicle vehicle = new Vehicle();
		when(vehicleDao.getSingleVehicle(1)).thenReturn(vehicle);
		assertEquals(vehicleDao.getSingleVehicle(1), vehicle);
	}
}
