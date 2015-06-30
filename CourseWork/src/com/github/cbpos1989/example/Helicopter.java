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
	
	public Helicopter(EngineType engineType, double maxElevation, double currentElevation){
		this.engineType = engineType;
		this.maxElevation = maxElevation;
		this.currentElevation = currentElevation;
	}
	
	public String getEngineType(){
		return engineType.toString();
	}

	
	public void setCurrentElevation(double currentElevation){
		if(currentElevation <= this.maxElevation){
			this.currentElevation = currentElevation;
		} else {
			this.currentElevation = maxElevation;
		}
	}
	
	public String toString(){
		return "EngineType: " + this.engineType + "\nCurrent Elevation: " + this.currentElevation + "\nMax Elevation: " + this.maxElevation;
	}
}
