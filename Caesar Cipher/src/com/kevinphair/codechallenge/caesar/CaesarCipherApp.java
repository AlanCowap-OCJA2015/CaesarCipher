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
				case 1: System.out.println("Encrypt selected"); 
				encryptString();
				break;
				case 2: System.out.println("Decrypt selected");
				decryptString();
				break;
				case 3: System.out.println("Shift value selected");
				setShiftValue();
				break;
				case 4: System.out.println("Program quitting. Thank you"); return;
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
		String inputString;

		System.out.println("Please enter some text to encrypt (140 characters max)");
		inputString = scan.nextLine();
		inputString = scan.nextLine();

		if (inputString.length() > 0 && inputString.length() <= 140) {
			System.out.println("This encrypts to '" + crypt(inputString, shiftValue) + "'");
		}else if(inputString.length() > 140){
			System.out.println("The string is greater than the allowable length.");
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * Get a string from the user to decrypt and call the crypt method with the shift value
	 * inverted to do the decryption
	 */
	public static void decryptString() {
		String inputString;

		System.out.println("Please enter some text to decrypt (140 characters max)");
		inputString = scan.nextLine();
		inputString = scan.nextLine();

		if (inputString.length() > 0 && inputString.length() <= 140) {
			System.out.println("This decrypts to '" + crypt(inputString, -shiftValue) + "'");
		}else if(inputString.length() > 140){
			System.out.println("The string is greater than the allowable length.");
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * General purpose encrypt/decrypt method
	 * 
	 * @param string to encrypt/decrypt
	 * @param number of characters to shift up or down by
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
	 * Get a number from the user to use as the new shiftValue
	 */
	public static void setShiftValue() {
		int newShift = 0;

		System.out.println("Please enter the new shift value (from -94 to 94)");
		newShift = scan.nextInt();

		System.out.println("You entered " + newShift);
		if (newShift == 0 || newShift > 94 || newShift < -94) {
			System.out.println("That is not a valid shift value");

		} else {
			shiftValue = newShift;
		}
	}
}
