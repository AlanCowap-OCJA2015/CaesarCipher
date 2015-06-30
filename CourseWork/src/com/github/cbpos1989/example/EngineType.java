package com.github.cbpos1989.example;

public enum EngineType {
	PETROL(135, 50.0F), 
	ELECTRIC(70, 35.5F), 
	HYBRID(100, 40.7F), 
	NONE(0,0.0F);
	
	private int power;
	private float fuelCapacity;
	
	private EngineType(int power, float fuelCapacity){
		this.power = power;
		this.fuelCapacity = fuelCapacity;
	}
	
	public String toString(){
		return super.toString() + " Engine Power(Watts): " + this.power + " Fuel Capacity(Litres): "+ this.fuelCapacity;
	}
}
