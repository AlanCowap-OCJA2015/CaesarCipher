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
		char[] userTextArray = null;
		boolean isRunning = true;
		do{
			System.out.println("1) Enter a String ");
			System.out.println("2) Encrypt a string ");
			System.out.println("3) Decrypt a string");
			System.out.println("4) Quit ");

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
				userTextArray = cc.encrypt(userTextArray, offset);
				System.out.println(String.valueOf(userTextArray));
				break;

			case 3 : 
				userTextArray = cc.decrypt(userTextArray, offset);
				System.out.println(String.valueOf(userTextArray));
				break;
			case 4:
				System.out.println("Thank you, goodbye!");
				isRunning = false;
				break;
			default:
				break;
			}

		}while(isRunning);
	}
}
