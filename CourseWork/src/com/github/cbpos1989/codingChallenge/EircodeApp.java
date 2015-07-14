/**
 * 
 */
package com.github.cbpos1989.codingChallenge;

import java.util.Scanner;

/**
 * Class that allows user to interact with menu and search for address or eircodes. 
 * 
 * @author Colm O'Sullivan, Conor Brennan, Craig McGarry
 * @version 1.0  
 * @dependencies None
 */
public class EircodeApp {

	String eircodes[] = {"D02 Y006","D04 C932", "D15 XR2R", "D03 RR27", "D24 H510","D02 XE81","D02 P656","null","null","null"};

	String address[] = {"5 Merrion Square North, Dublin 2","10 Burlington Road, Dublin 4","Dunsink Observatory,"
			+ "Dunsink Lane, Dublin 15","26 Kincora Road, Clontarf, Dublin 3.",
			"Partas, 4A Brookfield Enterprise Centre, Dublin 24","Hodges Figgis , 56-58 Dawson Street , Dublin 2"
			,"Central Bank of Ireland , Dame Street , Dublin 2","null","null","null"};

	public static void main(String[] args) {
		EircodeApp ea = new EircodeApp();
		ea.initialiseApp();
	}

	void initialiseApp(){
		boolean invalidChoice = true;
		Scanner scan = new Scanner(System.in);
		do{

			String oldChoice ;
			System.out.println("\n---Eircode\u00A9 App Menu---\n1) Enter eircode\n2) Enter address\n3) Enter postcode"
					+ "\n4) Enter custom eircode and address\n5) Quit");
			try {
				oldChoice = scan.nextLine();
				int choice = Integer.parseInt(oldChoice);

				switch(choice){
				case 1: System.out.print("Please enter a valid Eircode: ");
				String temp = scan.nextLine();
				System.out.print("Eircode Address: " + checkForAddress(temp.toUpperCase(),true));
				//invalidChoice = false; 
				break;
				case 2: System.out.print("Please enter a valid address : ");
				String temp1 = scan.nextLine();
				
				System.out.print("Eircode : " + checkForAddress(temp1,false));
				//invalidChoice = false; 
				break;
				case 3: System.out.print("Please enter a valid postcode : ");
				String userInput = scan.nextLine();
				CharSequence postCode = userInput.toUpperCase();
				System.out.print("Addresses at " + postCode + "\n" + checkPostCode(postCode));
				//invalidChoice = false;
				break;
				case 4:	enterAddress();
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

	public void enterAddress() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean invalidEircode = true;
		boolean invalidChoice = true;
		
		do{
			System.out.println("How many addresses/eir codes do you want to add (1-3)");
			String uiOldChoice = scan.nextLine();
			int uiChoice = Integer.parseInt(uiOldChoice);


			if(uiChoice>3||uiChoice<1){
				System.out.println("Please pick a number between 1 and 3");
			}else{
				invalidChoice = false;
				for(int i = 8;i<(8+uiChoice);++i){
					System.out.println("Enter address please : ");
					String userAddress = scan.nextLine();

					address[i]=userAddress;
					do{
						System.out.println("Enter eir code please : ");
						String userEircode = scan.nextLine();
						userEircode = userEircode.replaceAll("[^A-Za-z0-9]", "");

						if(userEircode.length() == 7){
							eircodes[i]=userEircode.toUpperCase();
							invalidEircode = false;
						}else{
							System.out.println("Enter a valid eircode (7 characters)");
						}
					} while(invalidEircode);
				}
			}
		} while (invalidChoice);
	}

	String checkForAddress(String str, boolean isEircode){
		String strNoSpace = str.replaceAll("[^A-Za-z0-9]", "");
		String strArrayNoSpace = null;

		if(isEircode){
			for (int i = 0; i < eircodes.length; ++i) {
				strArrayNoSpace = eircodes[i].replaceAll("[^A-Za-z0-9]", "");

				if(strArrayNoSpace.equals(strNoSpace)){
					return address[i];
				} 
			}

			return "No valid address found for " + str;

		} else {
			for (int i = 0; i < address.length; ++i) {
				strArrayNoSpace = address[i].replaceAll("[^A-Za-z0-9]", "");
				
				if(strArrayNoSpace.equalsIgnoreCase(strNoSpace)){
					return eircodes[i];
				} else if (checkPartialString(strNoSpace, strArrayNoSpace)){
					return eircodes[i];
				}

			}

			return "No valid eircode found for " + str;

		}

	}

	boolean checkPartialString(String subStr, String str){
		str = str.toUpperCase();
		String strStart = subStr.substring(0, 5);
		String strEnd = subStr.substring(subStr.length() -5 , subStr.length());
	
		if (str.startsWith(strStart) && str.endsWith(strEnd)) {
			return true;
		} else {
			return false;
		}

	}

	StringBuilder checkPostCode(CharSequence postCode){
		StringBuilder output = new StringBuilder("");

		for (int i = 0; i < eircodes.length; ++i) {
			if(eircodes[i].contains(postCode)){
				output.append(address[i] + "\n");
			}
		}

		return output;
	}

}
