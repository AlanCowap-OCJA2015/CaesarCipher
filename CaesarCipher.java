/**
 * A simple app to encrypt text with a simple rightshift 1 CaesarCipher
 * Created by Thomas McSherry, Craig McGarry, and Jenn Quinn
 */
package ceasarCipher;

import java.util.Scanner;

public class CeasarCipher {


	public static void main(String[] args) {

		String userText;
		String encrypt;
		String decryption;

		Scanner scan = new Scanner (System.in);
		System.out.println("please enter text to encrypt:");
		userText = scan.nextLine();

		encrypt = encrypt(userText);
		System.out.println("Encrypt...");
		System.out.println(encrypt);

		decryption = decrypt(encrypt);
		System.out.println("Decrypt...");
		System.out.println(decryption);
	}

	private static String encrypt(String plainText){
		String encrypt = "";
		for(int i = 0 ; i < plainText.length(); ++i){
			char c = plainText.charAt(i);
			if(c < 32 || c > 126){
				encrypt += c;
				continue;
			}
			++c;
			if((int)c > 126){
				c = 32;
			}
			encrypt += c;
		}
		return encrypt;
	}//end of encrypt

	private static String decrypt(String encryption){
		String decryption = "";
		for(int i = 0; i < encryption.length(); ++i){
			char c = encryption.charAt(i);
			if(c < 32 || c > 126){
				decryption += c;
				continue;
			}
			--c;
			if((int)c < 32){
				c = 126;
			}
			decryption += c;
		}
		return decryption;
	}//end of decrypt

}
