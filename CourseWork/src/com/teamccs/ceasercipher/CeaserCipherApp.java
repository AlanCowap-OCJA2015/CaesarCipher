package com.teamccs.ceasercipher;

import java.util.Scanner;

/**
 * @author User1
 *
 */
public class CeaserCipherApp {
	private int shiftMagnitude = 1;
	boolean isEncypting = true;
	
	public static void main(String[] args) {		
		CeaserCipherApp cC = new CeaserCipherApp();
		cC.userMenu();
			
	}
	
	private void userMenu(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		int inputNum = 0;
			System.out.println("Ceaser Cipher Menu\n1)Enter Input\n2)Shift Direction\n3)Shift Magnitude\n4)Encryption/Decryption\n5)Exit");
		do{
			System.out.print("Enter Choice: ");
			String input = scan.next();
			try{
				inputNum = Integer.parseInt(input);
				invalidInput = false;
			} catch(NumberFormatException nfe){
				invalidInput = true;
			};
		} while(invalidInput);
		
		switch(inputNum){
			case 1: userInput();break;
			case 2:userDirectionInput();break;
			case 3:userMagnitudeInput();break;
			case 4:setEncryption();break;
			case 5:break;
				default:break;
		};
	
	}
	
	private void userDirectionInput(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Please choose shift Direction (R = right, L = left");
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
		System.out.println("Please select the magnitude value of encryption:");
		int input = scan.nextInt();
		this.shiftMagnitude = input;
	}

	
		
	
	
	private void setDirection(boolean right){
		if(!right){
			this.shiftMagnitude *= -1;
		}
	}
	
	private void setMagnitude(){
		
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
			String input = scan.nextLine();
			
			if(input.isEmpty()){
				System.out.println("Please enter valid input");
				invalidInput = true;
			} else {
				System.out.println("Encryted Text: " + stringToCharConvert(input));
				invalidInput = false;
			}

		}while(invalidInput);
	}
	
	public String stringToCharConvert(String input){
		char[] convertedString = input.toCharArray();	
		char[] tempCharArray = new char[convertedString.length];
		String output = "";
		for(int i = 0; i < convertedString.length; ++i){
			tempCharArray[i] = shiftChar(1, convertedString[i]);
			output += tempCharArray[i];
		}
		return output;
	}
	
	private char shiftChar(int shift, char c){
		
		if(c == 126){
			c = 32;
		}else if (c == 32){
			c =126;
		} else {
			c = (char) (c+(shift));
		}
		
		return c;
	}

}
	