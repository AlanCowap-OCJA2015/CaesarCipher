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
		boolean invalidChoice = true;
		Scanner scan = new Scanner(System.in);
		do{

			String oldChoice ;
			System.out.println("---Eircode\u00A9 App Menu---\n1) Enter eircode\n2) Quit");
			try {
				oldChoice = scan.nextLine();
				int choice = Integer.parseInt(oldChoice);
				if(choice==1){
					System.out.print("Please enter a valid Eircode");
					String temp = scan.nextLine();
					System.out.print(checkForAddress(temp));
					invalidChoice = false;
				}else if(choice==2){
					System.out.println("Thank You for using the Eircode\u00A9 app");
					invalidChoice = false;
				}else{
					System.out.println("Please enter a valid option from the menu!!");
				}


			} catch (Exception e) {
				System.out.println("Please enter a valid option from the menu!!");

			}



		}while(invalidChoice);
		scan.close();

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
