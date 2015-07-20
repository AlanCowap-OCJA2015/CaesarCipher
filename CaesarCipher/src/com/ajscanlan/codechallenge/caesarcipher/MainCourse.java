package com.ajscanlan.codechallenge.caesarcipher;

import java.util.Scanner;

public class MainCourse {

	
	
	public static void main(String[] args) {
		String userInput;
		MainCourse main = new MainCourse();
		main.displayDish();
		
		/*System.out.println("Welcome to Our Salad Security");
		System.out.println("Please Enter a word to Encrypt");
		Scanner scan = new Scanner(System.in);
		userInput = scan.nextLine();
		
		CaeserSalad salad = new CaeserSalad();
		System.out.print(salad.encryptLettuce(userInput));
		*/
		//salad.dencryptLettuce("Mfuuvdf");
		//System.out.println(salad.dencryptLettuce("Mfuuvdf"));
	}
	
	private void displayDish(){
		System.out.println("Welcome To Salad Security");
		System.out.println("");
		System.out.println("1.) Encryption");
		System.out.println("2.) Decryption");
		System.out.println("3.) Quit Progam");
		System.out.println("");
		System.out.println("Please Enter Options 1 , 2 or 3");
		
		Scanner scan = new Scanner(System.in);
		
	}

}
