/**
 * 
 */
package com.cagj.blackjack;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author User1
 *
 */
public class BlackjackApp {
	Cards deck;
	Cards playerOne;
	Cards playerTwo;
	Cards tempDeck;
	static int playerOneWins= 0;
	static int playerTwoWins= 0;
	static int draw=0;
	static int numGames = 1;
	
	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.runGame();
		bja.overAllWinner();
		
	}
	
	void setupGame(){
		System.out.println("\n---NEW GAME---");
		System.out.println("Playing Game");
		deck = new Cards("Deck");
		//TODO to remove TEST
		//tempDeck = new Cards("tempDeck");
		//tempDeck.addAce();
		//tempDeck.addAce();
		
		createDeck(deck);
		System.out.println("Deck created");
		playerOne = new Cards("Player One");
		playerTwo = new Cards("Player Two");
		
//		for(Card c: deck.getCards()){
//			System.out.print(c.toString() + " ");
//		}
	}
	
	void runGame(){
		boolean isPlaying = true;
		boolean isRunning = true;
		
		do{
			
			int playerOneHandValue = 0;
			int playerTwoHandValue = 0;
			
			setupGame();
			dealCard(deck, playerOne);
			dealCard(deck, playerOne);
			dealCard(deck, playerTwo);
			dealCard(deck, playerTwo);
		
			
			//do{
				playerOneHandValue = getCardsTotalValue(playerOne);
				playerTwoHandValue = getCardsTotalValue(playerTwo);
				
				System.out.println("Player One starting hand contains: " + playerOne.toString() + "(Value: " + playerOneHandValue + ")");
				System.out.println("Player Two starting hand contains: " + playerTwo.toString() + "(Value: " + playerTwoHandValue + ")\n");
				
				playerOneHandValue = playGame(playerOneHandValue, playerOne);
				playerTwoHandValue = playGame(playerTwoHandValue, playerTwo);
				
				//System.out.println("Player One hands value is: "+ playerOneHandValue);
				//System.out.println("Player Two hands value is: "+ playerTwoHandValue);
				
				if(playerOneHandValue > playerTwoHandValue){
					System.out.println("Player One wins");
					++playerOneWins;
					
				}else if(playerOneHandValue<playerTwoHandValue){
					System.out.println("Player Two wins");
					++playerTwoWins;
				}else{
					System.out.println("Player have drawn");
					++draw;
				}
				
				System.out.println("Player one has won: "+ playerOneWins + " times in total");
				System.out.println("Player two has won: "+ playerTwoWins + " times in total");
			System.out.println("Games played so far: " + numGames);
				
		} while (playAgain());
			
	}
	
	
	//returns correct total cards value
	public static int getCardsTotalValue(Cards cards){
		int totalValue = getCardsValueNoAces(cards);	//aces count as 1
		totalValue = getCardsValueWithAces(cards, totalValue);	//aces recounted
		
		return totalValue;	//return correct recounted value
	}
	
	
	//aces counted as 1 point
	public static int getCardsValueNoAces(Cards cards){
		int value = 0;
		for(Card c : cards.getCards()){
			value += c.getRankInInt();
		}
		return value;
	}
	
	
	//counts aces as 11 points if hand value is <= 11
	public static int getCardsValueWithAces(Cards cards, int value){
		int numAces = getNumAces(cards);
		while(numAces > 0 && value <= 11){
			numAces--;
			value+=10;
		}
		return value;
		
	}
	
	
	//returns number of aces in hand
	public static int getNumAces(Cards cards){
		int numAces = 0;
		
		for(Card c : cards.getCards()){
			if(c.getRankInInt() == 1){
				numAces++;
			}
		}	
		return numAces;
	}
	
	
	
	int addUpHand(Cards player){
		int totalCardValue = 0;
		
		for(Card c: player.getCards()){
			totalCardValue += c.getRankInInt();
			
		}
		
		
		//System.out.println("Value of players hand: " + totalCardValue);
		
		return totalCardValue;
	}
	
	void dealCard(Cards deck, Cards player){
		player.getCards().add(deck.getCards().remove(0));
	}
	
	static void createDeck(Cards player){
		Suits suit = Suits.DEFAULT;
		String rank = "";
		for(int s = 0; s < 4; ++s){
			//set suits
			switch(s){
				case 0 : suit = Suits.SPADES; break;
				case 1 : suit = Suits.HEARTS; break;
				case 2 : suit = Suits.CLUBS; break;
				case 3 : suit = Suits.DIAMONDS; break;
			}

			for(int r = 2; r < 15; ++r){
				//set rank
				switch(r){
				case 11 : rank = "J"; break;
				case 12 : rank = "Q"; break;
				case 13 : rank = "K"; break;
				case 14 : rank = "A"; break;
				default : rank = "" + r; break;
			}
				
				player.getCards().add(new Card(suit, rank));
				//System.out.print(suit);
			}
		}
		
		Collections.shuffle(player.getCards());
	}
	
	int checkForAce(Card c, int playerHandValue){
		if(c.getRankInInt() == 1 && playerHandValue <= 11){
			return 11;
		} else if (c.getRankInInt() == 1 && playerHandValue > 11){
			return 1;
		} else {
			//return playerHandValue;
			return c.getRankInInt();
		}
	
	}
	
	public int playGame(int playerHandValue, Cards player){
		boolean hold = false;

		do{
			int nextCard = 0;

			if(playerHandValue > 16){

				hold = true;

			}else if(playerHandValue < 17){
				dealCard(deck,player);
				//nextCard = player.getCards().get(player.getCards().size()-1).getRankInInt();
				//nextCard = checkForAce(player.getCards().get(player.getCards().size()-1),playerHandValue);
				//System.out.print("Next Card: " +nextCard);
				playerHandValue = getCardsTotalValue(player);
				//System.out.print("New Value : " + playerHandValue);
				System.out.println(player.getName() + " hand contains: " + player.toString() + "(Value: " + playerHandValue + ")");
			}

		}while(!hold);
		
		if(playerHandValue > 21){
			//player is bust return 0, is always lose)
			System.out.println(player.getName() + " has gone over 21 and busted");
			playerHandValue = 0;
			//System.out.println("New value : " + playerHandValue);
		}
		
		return playerHandValue;

	}
	
	public void overAllWinner(){
		System.out.println("Player one has won: "+ playerOneWins + " times");
		System.out.println("Player two has won: "+ playerTwoWins + " times");
		if(playerOneWins > playerTwoWins){
		System.out.println("Player one is overall winner");	
		
		} else if(playerTwoWins> playerOneWins){
			System.out.println("Player two is overall winner");
			
		}else{
			System.out.println("Game is a draw");
		}
	}
	

	  //prompts user for 'y' or 'n' to play again
		private boolean playAgain() {
			numGames++;	//game has been played
			boolean isRunning = true;
			
			if(numGames == 12){
				return false;
			}
			
			System.out.println("Do you want to play new game?(y/n)");
			Scanner scan = new Scanner(System.in);
			do{
				String input = scan.nextLine();
				if(input.equalsIgnoreCase("n")){
					isRunning = false;
					
					
	//TODO integrate display num wins method here
					
					
					break;
				}else if(input.equalsIgnoreCase("y")){
					isRunning = true;
					break;
				}else{
					System.out.println("Invalid input, enter 'y' or 'n'");
				}
			}while(true);
			return isRunning;
		}
	
	
}
