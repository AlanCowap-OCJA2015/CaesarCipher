package com.ajscanlan.codechallenge.caesarcipher;

import java.util.Scanner;

public class MainCourse {

	
	
	public static void main(String[] args) {
		String userInput;
		System.out.println("Welcome to Our Salad Security");
		System.out.println("Please Enter a word to Encrypt");
		Scanner scan = new Scanner(System.in);
		userInput = scan.nextLine();
		
		CaeserSalad salad = new CaeserSalad();
		System.out.print(salad.encryptLettuce(userInput));
		
		//salad.dencryptLettuce("Mfuuvdf");
		//System.out.println(salad.dencryptLettuce("Mfuuvdf"));
	}

}
