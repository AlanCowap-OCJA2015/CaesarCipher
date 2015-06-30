/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author Colm O'Sullivan
 *
 */
public class LawnMowerApp {

	
	public static void main(String[] args) {
		LawnMower lawnMower = new LawnMower(EngineType.ELECTRIC, "Black");
		System.out.println("LawnMower Engine is: " + lawnMower.isEnigneOn() + "\nEngineType: " + lawnMower.getEngineType() + "\nLawnMower Color: " + lawnMower.getColor());
		lawnMower.turnEngineOn();
		System.out.println("LawnMower Engine is: " + lawnMower.isEnigneOn() + "\nEngineType: " + lawnMower.getEngineType() + "\nLawnMower Color: " + lawnMower.getColor());
	}

}
