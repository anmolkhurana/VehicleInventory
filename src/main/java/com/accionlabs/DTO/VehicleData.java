package com.accionlabs.DTO;

public class VehicleData {
		
	private int id;
	private String type;
	private String makeYear;
	private double price;
	private String mode;
	private int maxSpeed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
