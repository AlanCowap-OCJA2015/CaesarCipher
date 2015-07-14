/**
 * 
 */
package com.github.cbpos1989.codingChallenge;

import java.util.Scanner;

/**
 * @author User1
 *
 */
public class EircodeApp {
	String eircodes[] = {"D02 Y006","D04 C932", "D15 XR2R", "D03 RR27", "D24 H510"};
	String address[] = {"5 Merrion Square North, Dublin 2","10 Burlington Road, Dublin 4","Dunsink Observatory, Dunsink Lane, Dublin 15","26 KINCORA ROAD, Clontarf, Dublin 3.","Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24"};
	
	public static void main(String[] args) {
		EircodeApp ea = new EircodeApp();
		ea.initialiseApp();

	}
	
	void initialiseApp(){
		//System.out.print("Working");
		Scanner scan = new Scanner(System.in);
		System.out.println("---Eircode Menu---");
	}
	
	String checkForAddress(String eircode){
		for (int i = 0; i < eircodes.length; ++i) {
			if(eircodes[i].equals(eircode)){
				return address[i];
			} 
		}
		
		return "No valid address found";
	}

}
