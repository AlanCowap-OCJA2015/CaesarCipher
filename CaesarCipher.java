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

		Scanner scan = new Scanner (System.in);
		System.out.println("please enter text to encrypt:");
		userText = scan.nextLine();

		System.out.println("please enter the shift value:");
		shiftValue = scan.nextInt();

		System.out.println("please enter if you want to shift right(1) or left(2):");
		userDirection = scan.nextInt();

		if(userDirection == 1){
			direction = true;
		}
		else if(userDirection == 2){
			direction = false;
		}
		else{

		}

		encrypt = encrypt(userText, shiftValue, direction);
		System.out.println("Encrypt...");
		System.out.println(encrypt);

		System.out.println("Press enter to decrypt");
		try{
			System.in.read();

		}catch(Exception e){

		}

		decryption = decrypt(encrypt);
		System.out.println("Decrypt...");
		System.out.println(decryption);
	}

	//Method to encrypt a given string
	private static String encrypt(String plainText, int shiftValue, 
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

	//Method to decrypt a given String
	private static String decrypt(String encryption, int shiftValue, 
			boolean direction){
		String decryption = "";
		for(int i = 0; i < encryption.length(); ++i){
			char c = encryption.charAt(i);
			if(c < 32 || c > 126){
				decryption += c;
				continue;
			}
			if(direction){
				c -= shiftValue;
			}
			else{
				c += shiftValue;
			}
			if((int)c > 126){
				c -= 95;
			}else if((int)c < 32){
				c += 95;
			}
			decryption += c;
		}
		return decryption;
	}//end of decrypt

}
