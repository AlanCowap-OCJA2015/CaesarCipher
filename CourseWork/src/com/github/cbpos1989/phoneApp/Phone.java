package com.github.cbpos1989.phoneApp;

public class Phone {
	private String manufacturer;
	private String model;
	private float screenSize;
	private int memoryCapacity;
	
	public Phone(String manufacturer, String model, float screenSize, int memoryCapacity){
		this.manufacturer = manufacturer;
		this.model = model;
		this.screenSize = screenSize;
		this.memoryCapacity= memoryCapacity;
		
	}
	
	public float getScreenSize(){
		return this.screenSize;
	}
	
	public int getMemoryCapacity(){
		return this.memoryCapacity;
	}
	
	public String toString(){
		return "Manufacturer: " + this.manufacturer + "\nModel: "+ this.model
				+ "\nScreensize: " + this.screenSize + "\nMemory Capacity: " + this.memoryCapacity + "\n";
	}
}
