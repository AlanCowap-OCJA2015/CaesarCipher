package com.teamccs.ceasercipher;

import java.util.Scanner;

/**
 * @author User1
 *
 */
public class CeaserCipherApp {
	
	public static void main(String[] args) {		
		
		
		CeaserCipherApp cC = new CeaserCipherApp();
		cC.userInput();
			
	}
	
	public void userInput(){
		System.out.println("Please input your text:");
		Scanner scan = new Scanner(System.in);
		do{
		String input = scan.nextLine();
//		System.out.println(stringToCharConvert(scan.nextLine()));
		}while(;);
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
		
		c = (char) (c+(shift));
		
		return c;
	}

}
