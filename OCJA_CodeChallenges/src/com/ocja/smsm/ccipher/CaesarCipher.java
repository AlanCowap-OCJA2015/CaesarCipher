package com.ocja.smsm.ccipher;
import java.util.Scanner;


/**
 * 
 */

/**
 * @author Sam, Seamus, Mubasher, Marie
 *
 */
public class CaesarCipher {

	private char encryptOneCharacter(char source, int offset){
		int temp = source + offset;
		if (temp < 127 && temp > 31){
			return (char)temp;
		}else if (temp >126){
			return (char)(temp -94);
		}else {
			return (char)(temp + 94);
		}
	}

	private char[] encrypt(char[] source, int offset){
		char[] destination = new char[source.length];
		for (int i=0; i<source.length; ++i){
			destination[i] = this.encryptOneCharacter(source[i], offset);
		}
		return destination;
	}

	private char[] decrypt(char[] source, int offset){
		char[] destination = new char[source.length];
		for (int i=0; i<source.length; ++i){
			destination[i] = this.encryptOneCharacter(source[i], -offset);
		}
		return destination;
	}

	public static void main(String[] args) {
		String userText ;
		String encryptText;
		String decryptText;
		CaesarCipher cc = new CaesarCipher();
		int offset = 1;
		int direction = 1;
		char[] userTextArray = null;
		boolean isRunning = true;
		do{
			System.out.println("1) Enter a String ");
			System.out.println("2) Change the encryption magnitude and direction");
			System.out.println("3) Encrypt the stored string ");
			System.out.println("4) Decrypt the stored string");
			System.out.println("5) Quit ");

			Scanner scan = new Scanner(System.in);
			int userChoice = scan.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("please enter your string " );
				Scanner sc = new Scanner(System.in);
				userText = sc.nextLine();
				System.out.println(userText);
				userTextArray = userText.toCharArray();
				break;
			case 2 :
				System.out.println("Please enter L for left or R for right");
				String tempString = scan.next();
				if (tempString.toUpperCase().startsWith("L")){
					direction = -1;
				}
				System.out.println("Please choose the magnitude to shift the string (between 0 and 26)");
				offset = scan.nextInt();
				break;
			case 3 : 
				userTextArray = cc.encrypt(userTextArray, offset*direction);
				System.out.println(String.valueOf(userTextArray));
				break;

			case 4 : 
				userTextArray = cc.decrypt(userTextArray, offset*direction);
				System.out.println(String.valueOf(userTextArray));
				break;
			case 5:
				System.out.println("Thank you, goodbye!");
				isRunning = false;
				break;
			default:
				break;
			}

		}while(isRunning);
	}
}
