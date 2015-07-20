package com.kevinphair.codechallenge.caesar;

import java.util.Scanner;

/**
 * @author Kevin, James, Joe
 *
 */
public class CaesarCipherApp {

	public static int shiftValue = 1;

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		mainloop:

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
					case 4: System.out.println("Program quitting. Thank you"); break mainloop;
				};
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

	public static void encryptString() {

		String inputString;

		System.out.println("Please enter some text to encrypt (140 characters max)");
		inputString = scan.nextLine();
		inputString = scan.nextLine();

		System.out.println("You entered " + inputString);
		if (inputString.length() > 0 && inputString.length() <= 140) {
			StringBuffer newString = new StringBuffer(inputString);
			System.out.println("Encrypting " + newString);
			crypt(newString, shiftValue);
			System.out.println("The encrypted string is '" + newString + "'");
		}else if(inputString.length() > 140){
			System.out.println("The string is greater than the allowable length.");
		}
		System.out.println();
		System.out.println();
	}

	public static void decryptString() {
		String inputString;

		System.out.println("Please enter some text to decrypt (140 characters max)");
		inputString = scan.nextLine();
		inputString = scan.nextLine();

		System.out.println("You entered " + inputString);
		if (inputString.length() > 0 && inputString.length() <= 140) {
			StringBuffer newString = new StringBuffer(inputString);
			System.out.println("Decrypting " + newString);
			crypt(newString, -shiftValue);
			System.out.println("The decrypted string is '" + newString + "'");
		}else if(inputString.length() > 140){
			System.out.println("The string is greater than the allowable length.");
		}
		System.out.println();
		System.out.println();

	}

	private static void crypt(StringBuffer newString, int shift) {
		char c;
		for (int i = 0; i < newString.length(); ++i) {
			c = newString.charAt(i);
			if (c >= 32 && c <= 126) {
				c = (char)(c + shift);
				if (c < 32){
					c += 95;
				}else if(c > 126){
					c -= 95;
				}
				newString.setCharAt(i, c);

			}
		}
	}

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
