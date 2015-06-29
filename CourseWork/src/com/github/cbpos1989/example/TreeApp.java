/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class TreeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree oakTree = new Tree();
		oakTree.setSpecies("Oak");
		oakTree.setTrunkDiameter(25);
		oakTree.setEvergreen(false);
		
		System.out.println("Species: " + oakTree.getSpecies() +  "\nTrunk Diameter: " + oakTree.getTrunkDiameter() + "\nEvergreen: " + oakTree.isEvergreen());
	}

}
