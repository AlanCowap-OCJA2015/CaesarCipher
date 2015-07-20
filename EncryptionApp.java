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
	public static void main(String[] args) {

		int shiftCounter = 1;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter text to be encrypted: " );
		String userInput = scan.nextLine();
		char[] inputChars = userInput.toCharArray();

		for(int i = 0; i < inputChars.length; ++i){
			if(inputChars[i] >= 32 && inputChars[i] <= 126){
				if(inputChars[i] == 126){
					inputChars[i] = 32;
				}else{
					inputChars[i] = (char) (inputChars[i] + shiftCounter);
				}
			}
		}

		System.out.println("Encrypted output is: " + new String(inputChars));
	}

}
