package com.kevinphair.codechallenge.caesar;

import java.util.Scanner;

/**
 * Create a Caesar cipher implementation which takes a string and either
 * encrypts or decrypts it according to a user-specified shift value
 * 
 * @author Kevin, James, Joe
 * @date 20 Jul 2015
 */
public class CaesarCipherApp {
	public static int shiftValue = 1;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			switch (mainMenu()) {
				case 1: encryptString();
						break;
				case 2: decryptString();
						break;
				case 3: shiftValue = setShiftValue();
						break;
				case 4: System.out.println("\nProgram quitting. Thank you");
						return;
			}
		}
	}

	/**
	 * Shows the main menu and gets option from the user
	 * @return option selected as integer
	 */
	public static int mainMenu() {
		int i = 0;

		System.out.println("Caesar Cipher");
		System.out.println();
		System.out.println("Choose from one of the following options");
		System.out.println("1: Encrypt a string");
		System.out.println("2: Decrypt a string");
		System.out.println("3: Set the shift value (currently " + shiftValue + ")");
		System.out.println("4: Quit");
		System.out.println();
		System.out.println("Press the number you want to select and press ENTER");

		while (true) {
			i = scan.nextInt();
			if (i > 0 && i < 5) {
				break;
			} else {
				System.out.println("That was an invalid choice. Please try again.");
			}
		}
		return i;
	}

	/**
	 * Get a string from the user to encrypt and call the crypt method to do the encryption
	 */
	public static void encryptString() {
		
		String inputString = getStringInput(scan, 140, "Please enter some text to encrypt (140 characters max)");

		if (inputString.length() > 0) {
			System.out.println("This encrypts to '" + crypt(inputString, shiftValue) + "'");
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * Get a string from the user to decrypt and call the crypt method with the shift value
	 * inverted to do the decryption
	 */
	public static void decryptString() {
		
		String inputString = getStringInput(scan, 140, "Please enter some text to decrypt (140 characters max)");

		if (inputString.length() > 0) {
			System.out.println("This decrypts to '" + crypt(inputString, -shiftValue) + "'");
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * General purpose encrypt/decrypt method
	 * 
	 * @param string to process
	 * @param number of characters to shift up or down by
	 * 
	 * @return the string after processing
	 */
	private static String crypt(String newString, int shift) {
		StringBuffer s = new StringBuffer(newString);
		char c;
		for (int i = 0; i < newString.length(); ++i) {
			c = s.charAt(i);
			if (c >= 32 && c <= 126) {
				c = (char)(c + shift);
				if (c < 32){
					c += 95;
				}else if(c > 126){
					c -= 95;
				}
				s.setCharAt(i, c);
			}
		}
		return s.toString();
	}

	/**
	 * Get a number from the user to use as the new shift value
	 * 
	 * @return the new value as an int 
	 */
	public static int setShiftValue() {
		int newShift = 0;

		System.out.println("Please enter the new shift value (from -94 to 94)");
		newShift = scan.nextInt();

		System.out.println("You entered " + newShift);
		if (newShift == 0 || newShift > 94 || newShift < -94) {
			System.out.println("That is not a valid shift value");
			return shiftValue;
		} else {
			return newShift;
		}
	}
	
	/**
	 * Get a line of input from the user after prompting. Can limit to a maximum length 
	 * 
	 * @param reference to already open scanner object to use
	 * @param maximum length of string (0 = no limit)
	 * @param prompt to show the user before getting input
	 * 
	 * @return The string that was input
	 */
	public static String getStringInput(Scanner s, int maxLen, String prompt) {
		String inputString = null;
		
		System.out.print(prompt);
		// Clear the next line from the scanner if one is waiting
		if (s.hasNextLine()) inputString = s.nextLine();
		while (true) {
			inputString = s.nextLine();
			if ((inputString.length() > 140) && (maxLen > 0)) {
				System.out.println("Input exceeds maximum length (" + maxLen + "), please try again.");
			} else {
				return inputString;
			}
		}
	}
}
