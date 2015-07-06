package com.github.cbpos1989.example;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessApp {

	public static void main(String[] args) {

		Random rand = new Random();

		Scanner scan = new Scanner(System.in);

		boolean playAgain = false;
		
	
		

		do{
			boolean[] guesses = new boolean[20];
			int guess = 0;

			int randomNumber = rand.nextInt(20) + 1;

			int countGuess = 0;

			boolean invalid = true;
			boolean validGuess = false;

			do{

				System.out.println(randomNumber);

				do{	
					System.out.println("Guess a number between 1 and 20: ");
					
					
					try {
						String input = scan.next();
						guess = Integer.parseInt(input);
						validGuess = true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Put in a proper digit(1-20)");
						validGuess = false;
					}
					
					if(guess > 0 && guess < 21){
						if(guesses[guess - 1]){
							validGuess = false;
							System.out.println("You have already picked this number,\n Pick another number please!");
						} else {
							guesses[guess-1] = true;
							validGuess = true;
						}
						
						
					} else {
						validGuess = false;
						System.out.println("Enter between 1-20");
					}
					
					int[] pickedNums = new int[20];
					int[] unpickedNums = new int[20];
					String pickedOutput = "";
					String unpickedOutput = "";
					
					for (int i = 0; i < guesses.length; ++i) {
						if(guesses[i]){
							pickedNums[i] = i + 1; 
							pickedOutput += " " + pickedNums[i];
						} else {
							unpickedNums[i] = i + 1;
							unpickedOutput += " " + unpickedNums[i];
						}
					}
				
					
					System.out.println("Number you have picked: " + pickedOutput);
					System.out.println("Number left to pick from: " + unpickedOutput);
				}while(!validGuess);

				if(guess == randomNumber){

					System.out.println("You got it right, the number was " + randomNumber 
							+ " and you used " + (countGuess + 1) + " guesses.");
					invalid = false;
				}else{

					System.out.println("Wrong guess, Guess again");
					
			
					countGuess++;
					

				}

			}while(invalid);

			validGuess = false;

			do{
				System.out.println("Would you like to play agian? Y/N: ");

				String exit = scan.next();

				exit = exit.toUpperCase();
				
				if(exit.equals("Y")){
					System.out.println("Y");
					validGuess = true;
					playAgain = true;

				} else if (exit.equals("N")) {
					System.out.println("Thank you for playing, good bye");
					validGuess = true;
					playAgain = false;
				} else {
					System.out.println("Please Y or N");
					validGuess = false;
				}
			}while(!validGuess);

		}while(playAgain);

		scan.close();
	}

}
