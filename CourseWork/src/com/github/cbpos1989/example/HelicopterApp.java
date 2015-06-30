/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class HelicopterApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Helicopter apache = new Helicopter(EngineType.HYBRID, 10000.0D, 0.0D);
		apache.setCurrentElevation(4000.56D);
		System.out.println(apache.toString());
	}

}
