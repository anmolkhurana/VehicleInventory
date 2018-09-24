package com.accionlabs.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accionlabs.entity.Vehicle;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class VehicleDaoImpl implements VehicleDao {
		
		@Autowired
		SessionFactory sessionFact;
		
		@Override
		public List<Vehicle> getAllVehicles(){
			@SuppressWarnings("unchecked")
			List<Vehicle> list = sessionFact.getCurrentSession().createQuery("from Vehicle").getResultList();
			return list;
		}
		
		@Override
		public Vehicle getSingleVehicle(int id) {
			return sessionFact.getCurrentSession().get(Vehicle.class, id);
		}
		
		@Override
		public Vehicle getLast() {
			return (Vehicle) sessionFact.getCurrentSession().createQuery("from Vehicle order by id desc").setMaxResults(1).uniqueResult();
		}
		
		@Override
		public void insertVehicle(Vehicle vehicle) {
			sessionFact.getCurrentSession().save(vehicle);
		}
		
		@Override
		public void updateVehicle(Vehicle vehicle) {
			sessionFact.getCurrentSession().update(vehicle);
		}

		@Override
		public void deleteVehicle(int id) {
			Vehicle vehicle = getSingleVehicle(id);
			if(vehicle!=null) {
				sessionFact.getCurrentSession().delete(vehicle);
			}
		}

		@Override
		public void deleteLastVehicle() {
			Vehicle vehicle = getLast();
			if(vehicle!=null) {
				sessionFact.getCurrentSession().delete(vehicle);
			}
		}

		@SuppressWarnings("deprecation")
		@Override
		public List<Vehicle> searchVehicle(String searchQuery) {
			@SuppressWarnings("rawtypes")
			Query query = sessionFact.getCurrentSession().createQuery("from Vehicle where type like :searchQuery");
			query.setParameter("searchQuery", "%" + searchQuery + "%");
			@SuppressWarnings("unchecked")
			List<Vehicle> vehicles = query.getResultList();
			return vehicles;
		}
}
