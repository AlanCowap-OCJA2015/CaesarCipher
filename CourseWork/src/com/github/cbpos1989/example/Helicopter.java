/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class Helicopter {
	private EngineType engineType;
	private double maxElevation;
	private double currentElevation;
	private int numPassengers;
	private int numCrew;
	
	
	private static final double FEET_TO_METERS = 3.28084D;
	
	public Helicopter(EngineType engineType, double maxElevation, boolean isMetric){
		this.engineType = engineType;
		this.maxElevation = maxElevation;
		if(isMetric){
			
		}
	}
	
	public int getNumPassengers(){
		return this.numPassengers;
	}
	
	public void setNumPassengers(int numPassengers){
		this.numPassengers = numPassengers;
	}
	
	public int getNumCrew(){
		return this.numCrew;
	}
	
	public void setNumCrew(int numCrew){
		this.numCrew = numCrew;
	}
	
	public double ElevationInMeters(){
		return this.currentElevation / FEET_TO_METERS;
	}
	
	public void setCurrentElevation(double currentElevation){
		if(currentElevation <= this.maxElevation){
			this.currentElevation = currentElevation;
		} else {
			this.currentElevation = maxElevation;
		}
	}
	
	public String toString(){
		return "EngineType: " + this.engineType 
				+ "\nCurrent Elevation: " + this.currentElevation 
				+ "\nMax Elevation: " + this.maxElevation
				+ "\nNumber of Passengers: " + this.numPassengers
				+ "\nNumber of Crew: " + this.numCrew;
	}
}
