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
		LawnMower lawnMower = new LawnMower();
		System.out.println("LawnMower Engine is: " + lawnMower.isEnigneOn());
		lawnMower.turnEngineOn();
		System.out.println("LawnMower Engine is: " + lawnMower.isEnigneOn());
	}

}
