package com.teamccs.ceasercipher;

import java.util.Scanner;

/**
 * @author User1
 *
 */
public class CeaserCipherApp {
	private int shiftMagnitude = 1;
	private int shiftDirection = 1;
	boolean isEncypting = true;
	private String userText;

	public static void main(String[] args) {		
		CeaserCipherApp cC = new CeaserCipherApp();
		cC.userMenu();

	}

	private void userMenu(){
		boolean isRunning = true;
		Scanner scan = new Scanner(System.in);
		int inputNum = 0;
		do{
			inputNum = 0;
			System.out.println("\nCeaser Cipher Menu");
			System.out.println("1)Enter Input  (" + userText + ")" );
			//System.out.println("2)Shift Direction (" + getDirection() + ")");
			System.out.println("2)Shift Direction");
			System.out.println("3)Shift Magnitude");
			System.out.println("4)Encryption/Decryption");
			System.out.println("5)Print Output");
			System.out.println("6)Exit");
			System.out.print("Enter Choice: ");
			String input = scan.nextLine();
			try{
				inputNum = Integer.parseInt(input);
			} catch(NumberFormatException nfe){
				System.out.println("Invalid option, please pick a valid number");
				isRunning = true;
			};

			switch(inputNum){
			case 1:userInput(); break;
			case 2:userDirectionInput(); break;
			case 3:userMagnitudeInput();break;
			case 4:setEncryption();break;
			case 5:printOutput();break;
			case 6:isRunning = false;break;
			default:break;
			};
		} while(isRunning);

	}

	private void printOutput() {
		if(userText != null){
			System.out.println("Encrypted Text: " + stringToCharConvert(userText));		
		}else{
			System.out.println("No input given");
		}
	}
	
	private String getDirection(){
		if (shiftDirection > 0){
			return "right";
		} else {
			return "left";
		}
	}

	private void userDirectionInput(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Please choose shift Direction (R = right, L = left)");
			String input = scan.next();
			if(input.equalsIgnoreCase("R")){
				setDirection(true);
				invalidInput = false;
			} else if(input.equalsIgnoreCase("L")){
				setDirection(false);
				invalidInput = false;
			} else {
				invalidInput = true;
			}
		} while(invalidInput);

	}

	private void userMagnitudeInput(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please select the magnitude value of encryption: ");
		int input = scan.nextInt();
		this.shiftMagnitude = input;
		this.shiftMagnitude *= this.shiftDirection;
	}


	private void setDirection(boolean right){
		if(!right){
			this.shiftDirection *= -1;
		}
	}



	private void setEncryption(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Please to choose (E = Encrypt, D = Decrypt");
			String input = scan.next();

			if(input.equalsIgnoreCase("E")){
				this.isEncypting = true;
				invalidInput = false;
			} else if(input.equalsIgnoreCase("D")){
				this.isEncypting = false;
				invalidInput = false;
			} else {
				invalidInput = true;
			}
		} while(invalidInput);

	}

	public void userInput(){
		boolean invalidInput = true;

		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Please input your text:");
			userText = scan.nextLine();

			if(userText.isEmpty()){
				System.out.println("Please enter valid input");
				invalidInput = true;
			} else {
				invalidInput = false;
			}

		}while(invalidInput);
	}

	public String stringToCharConvert(String input){
		char[] convertedString = input.toCharArray();	
		char[] tempCharArray = new char[convertedString.length];
		String output = "";
		for(int i = 0; i < convertedString.length; ++i){
			tempCharArray[i] = shiftChar(this.shiftMagnitude, convertedString[i]);
			output += tempCharArray[i];
		}
		return output;
	}

	private char shiftChar(int shift, char c){
		if(isEncypting){
			if(c == 126){
				c = 32;
			}else if (c == 32){
				c =126;
			} else {
				c = (char) (c+(shift));
			}
		} else {
			if(c == 126){
				c = 32;
			}else if (c == 32){
				c =126;
			} else {
				c = (char) (c-(shift));
			}
		}
		return c;
	}

}
