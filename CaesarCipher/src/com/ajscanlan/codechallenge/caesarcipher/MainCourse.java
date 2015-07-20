package com.ajscanlan.codechallenge.caesarcipher;

import java.util.Scanner;

/**
 * Created by Greg, Mick and PrM by Alex LTD.
 *
 */
public class MainCourse {
	boolean running = true;
	CaeserSalad salad = new CaeserSalad();

	public static void main(String[] args) {
		System.out.println("Welcome To Salad Security");
		MainCourse main = new MainCourse();
		main.displayDish();

	}

	private void displayDish(){
	do{
		String userInput = "";
		String text = "";
		
		System.out.println("");
		System.out.println("1.) Encryption");
		System.out.println("2.) Decryption");
		System.out.println("3.) Quit Progam");
		System.out.println("");
		System.out.println("Please Enter Options 1 , 2 or 3");

		Scanner scan = new Scanner(System.in);
		userInput = scan.nextLine();

		switch(userInput){

		case "1" : 
			
			salad.encryptLettuce(1);
			
			break;

		case "2" :
		
			salad.encryptLettuce(2);
			
			break;
		
		case "3" : 
			System.out.println("Good Bye");
			running = false;
			break;
			
		default : System.out.println("Please enter a number between 1 and 3");

		}
	}
	while(running);
	}

}
