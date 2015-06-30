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
	private String mowerColor; 
	private EngineType engine;
	
	public LawnMower(EngineType engine, String mowerColor){
		this.engineOn = false;
		this.engine = engine;
		this.mowerColor = mowerColor;
	}
	
	
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
	
	public EngineType getEngineType(){
		return engine;
	}
	
	public String getColor(){
		return mowerColor;
	}
}
