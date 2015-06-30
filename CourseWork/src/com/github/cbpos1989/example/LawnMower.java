/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author Colm O'Sullivan
 *
 */
public class LawnMower {
	//State
	private boolean engineOn;
	private enum engineType{PETROL, ELECTRIC, HYBRID, NONE};
	private String mowerColor; 
	
	//Behaviour
	public void turnEngineOn(){
		this.engineOn = true;
	}
	
	public void turnEngineOff(){
		this.engineOn = false;
	}
	
	public String isEnigneOn(){
		if(engineOn == false){
			return "Off";
		} else {
			return "On";
		}
	}
}
