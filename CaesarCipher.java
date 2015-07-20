/**
 * A simple app to encrypt text with a simple rightshift 1 CaesarCipher
 * Created by Thomas McSherry, Craig McGarry, and Jenn Quinn
 */
package ceasarCipher;

import java.util.Scanner;

public class CeasarCipher {


	public static void main(String[] args) {

		String userText;
		int userDirection;
		String encrypt;
		String decryption;
		int shiftValue;
		boolean direction = true;

		Scanner scan = new Scanner(System.in);


		System.out.println("Please enter text of a length up to 140 characters" 
				+ " to encrypt:");
		userText = scan.nextLine();
		while(userText.length() > 140){
			Scanner scan2 = new Scanner(System.in);
			System.out.println("That text is too long, please try again:");
			userText = scan2.nextLine();
		}

		System.out.println("Please enter the shift value (use a negative number"
				+ " to shift to the left:");
		while(!scan.hasNextInt()){
			scan.next();
			System.out.print("Sorry that is not a valid number, "
					+ "please try again:");
		}
		shiftValue = scan.nextInt();

		//		System.out.println("Please enter if you want to shift right(1)"
		//				+ " or left(2):");
		//		while(!scan.hasNextInt()){
		//			scan.next();
		//			System.out.print("Sorry that is not a valid number, please "
		//					+ "try again:");
		//		}
		//		userDirection = scan.nextInt();
		//
		//		if(userDirection == 1){
		//			direction = true;
		//		}
		//		else if(userDirection == 2){
		//			direction = false;
		//		}
		//		else{
		//			System.out.println("Sorry that is not a vaild value, defaulting "
		//					+ "to shift right");
		//		}

		encrypt = encryption(userText, shiftValue);
		System.out.println("Encrypt...");
		System.out.println(encrypt);

		System.out.println("Press enter to decrypt");
		try{
			System.in.read();

		}catch(Exception e){

		}
		//changing direction for decryption
		//direction = !direction;
		decryption = encryption(encrypt, -shiftValue);
		System.out.println("Decrypt...");
		System.out.println(decryption);
	}

	//Method to encrypt and decrypt a given string
	@SuppressWarnings("unused")
	private static String encryption(String plainText, int shiftValue, 
			boolean direction){
		String encrypt = "";
		for(int i = 0 ; i < plainText.length(); ++i){
			char c = plainText.charAt(i);
			if(c < 32 || c > 126){
				encrypt += c;
				continue;
			}
			if(direction){
				c += shiftValue;
			}
			else{
				c-= shiftValue;
			}
			if((int)c > 126){
				c -= 95;
			}else if((int)c < 32){
				c += 95;
			}
			encrypt += c;
		}
		return encrypt;
	}//end of encrypt

	private static String encryption(String plainText, int shiftValue){
		String encrypt = "";
		for(int i = 0 ; i < plainText.length(); ++i){
			char c = plainText.charAt(i);
			if(c < 32 || c > 126){
				encrypt += c;
				continue;
			}
			c += shiftValue;

			if((int)c > 126){
				c -= 95;
			}else if((int)c < 32){
				c += 95;
			}
			encrypt += c;
		}
		return encrypt;
	}//end of encrypt
}
