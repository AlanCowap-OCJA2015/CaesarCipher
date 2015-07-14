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
	String eircodes[] = {"D02 Y006","D04 C932", "D15 XR2R", "D03 RR27", "D24 H510","D02 XE81","DO2 P656","null","null","null"};
	String address[] = {"5 Merrion Square North, Dublin 2","10 Burlington Road, Dublin 4","Dunsink Observatory,"
			+ " Dunsink Lane, Dublin 15","26 Kincora Road, Clontarf, Dublin 3.",
			"Partas, 4A Brookfield Enterprise Centre, Dublin 24","Hodges Figgis , 56-58 Dawson Street , Dublin 2"
			,"Central Bank of Ireland , Dame Street , Dublin 2","null","null","null"};

	public static void main(String[] args) {
		EircodeApp ea = new EircodeApp();
		ea.initialiseApp();
		String userAddress1 = "";
		String userAddress2 = "";
		String userAddress3 = "";
	}

	void initialiseApp(){
		boolean invalidChoice = true;
		Scanner scan = new Scanner(System.in);
		do{

			String oldChoice ;
			System.out.println("---Eircode\u00A9 App Menu---\n1) Enter eircode\n2) Enter address\n3) Enter postcode"
					+ "\n4) Enter custom eircode and address\n5) Quit");
			try {
				oldChoice = scan.nextLine();
				int choice = Integer.parseInt(oldChoice);


				switch(choice){
				case 1: System.out.print("Please enter a valid Eircode: ");
						String temp = scan.nextLine();
						System.out.print("Eircode Address: " + checkForAddress(temp.toUpperCase()));
						invalidChoice = false; 
						break;
				case 2: System.out.print("Please enter a valid address : ");
						String temp1 = scan.nextLine();
						System.out.print("Eircode : " + checkForAddress(temp1.toUpperCase()));
						invalidChoice = false; 
						break;
				case 3: System.out.print("Please enter a valid postcode : ");
						String postCode = scan.nextLine();
						invalidChoice = false;
						break;
				case 4:	System.out.println("How many addresses/eir codes do you want to add ");
						String uiOldChoice = scan.nextLine();
						int uiChoice = Integer.parseInt(uiOldChoice); 
						for(int i = 8;i<(8+uiChoice);++i){
							System.out.println("Enter address please : ");
							address[i]=scan.nextLine();
							System.out.println("Enter eir code please : ");
							eircodes[i]=scan.nextLine();
							
						}
						
						break;
				case 5: System.out.println("Thank You for using the Eircode\u00A9 app");
						
						invalidChoice = false;
						break;
				default:System.out.println("Please enter a valid option from the menu!!");
						break;

				}




			} catch (Exception e) {
				System.out.println("Please enter a valid option from the menu!!");

			}



		}while(invalidChoice);
		scan.close();

	}

	String checkForAddress(String eircode){
		String eircodeNoSpace = eircode.replaceAll("[^A-Za-z0-9]", "");
		String eircodesNoSpace = null;
		for (int i = 0; i < eircodes.length; ++i) {
			eircodesNoSpace = eircodes[i].replaceAll("[^A-Za-z0-9]", "");
			if(eircodesNoSpace.equals(eircodeNoSpace)){
				return address[i];
			} 

		}
		return "No valid address found for " + eircode ;
	}
}
