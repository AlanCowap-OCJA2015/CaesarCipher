/**
 * Definition: Simple encryption app that shifts user input to the right by 1
 * 
 * @author Artjoms Porss, Peter Clarke, Marcos Ceasar
 * Version No: 1.0
 * 
 */
package com.artjomsporss.ocja.cipherapp;

import java.util.Scanner;

public class EncryptionApp {
	private boolean isRight = true;
	private int magnitude = 1;
	private int direction = -1;


	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		EncryptionApp ea = new EncryptionApp();
		ea.runApp();

	}


	public void runApp(){
		encryptionMenu();

	}

	//prompt user for initial menu
	public void encryptionMenu(){
		boolean isRunning = true;
		
		System.out.println("---Encryption App---");
		System.out.println("1)Encrypt text");
		System.out.println("2)Decrypt text");
		System.out.println("3)Quit");
		System.out.print("Choose an option: ");
		do{
			String userOption = scan.nextLine();

			switch(userOption){
			case "1" : encryptText(); break;//run encrypt text method
			case "2" : dencryptText();break;//run decrypt text method
			case "3" : isRunning = false;break;//run quit method
			default: System.out.print("Enter a valid option: ");
			}
		}while(isRunning);
	}






	private void encryptText() {

		//prompt user for input
		String userInput = getUserText();	//user input text
		getShiftDirection();
		this.magnitude = getShiftMagnitude();
		
		String shiftedText = shiftText(userInput, this.magnitude, true);
		
		//System.out.println(new String(inputChars) + isRight);
		//System.out.println(shiftDirection);


		System.out.println("Encrypted output is: " + shiftedText);

	}
	
	private void dencryptText() {

		//prompt user for input
		String userInput = getUserText();	//user input text
		getShiftDirection();
		this.magnitude = getShiftMagnitude();
		
		String shiftedText = shiftText(userInput, this.magnitude, false);
		
		//System.out.println(new String(inputChars) + isRight);
		//System.out.println(shiftDirection);


		System.out.println("Dencrypted output is: " + shiftedText);

	}


	//get shift magnitude form user
	private int getShiftMagnitude() {
		int mangitude = 0;
		System.out.print("Enter encryption magnitude: ");
		do{
			try{
				mangitude = scan.nextInt();
				mangitude = setDirection(mangitude);
				break;
				//int mangitude = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe){
				System.out.print("Please enter a valid number ");
			}
		}while(true);
		
		
		
		return mangitude;
	}


	//prompts user for input
	private String getUserText(){
		//get user input
		boolean invalidInput = true;
		String userInput = "";
	
		do{
			System.out.print("Enter text to be encrypted: " );
			userInput = scan.next();
			if(userInput.length() > 140){
				System.out.println("Message to long only 140 characters allowed" );
				invalidInput = true;
			} else {
				invalidInput = false;
				
			}
		} while(invalidInput);
		
		//store user input in char[]
		return userInput;
		
	}


	//prompts user for shifting direction
	private void getShiftDirection(){
		boolean haveDirection = false;
		Scanner scan = new Scanner(System.in);
		//prompt user does he wants to shift left or right?
		
		do{
			System.out.print("Do you want to shift the text left or right? (l/r): ");
			String shiftDirection = scan.nextLine();
			shiftDirection = shiftDirection.toLowerCase();
			
			switch(shiftDirection){
				case "r" :  isRight = true; 
							haveDirection = true; break;
				case "l" : isRight = false; 
						   this.magnitude = this.magnitude * -1; 
						   haveDirection = true; break;
				default: System.out.println("Please type 'l' or 'r' for direction"); break;
			}
			
		}while(haveDirection == false);
	}
	
	private int setDirection(int magnitude){
		if(!isRight){
			return magnitude *= this.direction;
		} else {
			return magnitude;
		}
		
	}
	
	
	//shifts text passed to direction(stored in boolean isRight) over magnitude passed  
	private String shiftText(String text, int shiftCounter, boolean isEncyprting){
		//TODO work on shifting algorithm
		//shifting direction is stored as boolean isRight in class object instance
		char[] textArr = text.toCharArray();
		//iterate throught char[]
		for(int i = 0; i < textArr.length; ++i){
				if(textArr[i] == 126){
					textArr[i] = 32;
				}else if (textArr[i] == 32){
					textArr[i] = 126;
				} else {
					if(isEncyprting){
						textArr[i] = (char) (textArr[i] + (this.magnitude));
					} else {
						textArr[i] = (char) (textArr[i] - (this.magnitude));
					}
				}
				
			
//			if(textArr[i] >= 32 && textArr[i] <= 126){	//if char is within boundaries
//				if(textArr[i] == 126){	//make last char to be first char within boundaries
//					textArr[i] = 32;
//				}else{						//if it's not last char within bounds, increment it
//					textArr[i] = (char) (textArr[i] + shiftCounter);	
//				}
//			}
		}
		
		return new String(textArr);
	}
}
