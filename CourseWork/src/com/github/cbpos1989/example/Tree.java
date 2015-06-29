/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class Tree {
	private String species;
	private int trunkDiameter;
	private boolean evergreen;
	private int water;
	private int carbonDioxide;
	private int sunlight;
	private int sugar;
	
	public String getSpecies(){
		return species;
	}
	
	public void setSpecies(String species){
		this.species = species;
	}
	
	public int getTrunkDiameter(){
		return trunkDiameter;
	}
	
	public void setTrunkDiameter(int trunkDiameter){
		this.trunkDiameter = trunkDiameter;
	}
	
	public boolean isEvergreen(){
		return evergreen;
	}
	
	public void setEvergreen(boolean evergreen){
		this.evergreen = evergreen;
	}
	
	public int photosynthesize(int water, int carbonDioxide, int sunlight){
		sugar = (water + carbonDioxide) / sunlight;
		return sugar;
	}
}
