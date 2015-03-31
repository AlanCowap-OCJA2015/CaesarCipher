/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App to demonstrate while loops and the ternary operator.
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class GamingApp{
	private int numGames = 3;
	private boolean validInput = false;
	private Scanner scan;
	
	
	public static void main(String[] args){
		//System.out.println("Working");
		
		GamingApp myGameApp = new GamingApp();
		myGameApp.setNumGames();
		if(myGameApp.validInput == true){
			myGameApp.runGame();
		}
		
	}
		
	void setNumGames(){
		scan = new Scanner(System.in);
		
		while(validInput == false){
			System.out.print("Enter how many games you want to play: ");
			String userInput = scan.nextLine();
			try{
				numGames =  Integer.parseInt(userInput);
				validInput = true;
			} catch(Exception ex) {
				System.out.println("Invalid Entry, Try Again");
			}
		}
	}

	void runGame(){
		while (numGames > 0) {
			playGame();
			String mult = numGames == 1 ? "life" : "lives";
			System.out.println("Your have " + numGames + " " + mult + " left.");
			--numGames;
			
		} 

		System.out.println("!!!GAME OVER!!!");


	}

	void playGame(){
		System.out.println("You Are Playing The Game, Woohoo!!!");
	
	}

	
}
