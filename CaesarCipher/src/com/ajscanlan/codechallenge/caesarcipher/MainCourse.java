package com.ajscanlan.codechallenge.caesarcipher;

import java.util.Scanner;

public class MainCourse {
	boolean running = true;
	CaeserSalad salad = new CaeserSalad();

	public static void main(String[] args) {
		System.out.println("Welcome To Salad Security");
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

		case "1" : System.out.println("please enter the sentence u want to encypt");
			scan = new Scanner(System.in);
			text = scan.nextLine();
			text = salad.encryptLettuce(text);
			System.out.println(text);
		break;


		case "2" : System.out.println("Option 2"); break;
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
