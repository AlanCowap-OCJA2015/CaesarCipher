/**
 * Cards holds the cards
 */
package com.cagj.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {
	ArrayList<Card> cards = new ArrayList<Card>();



	
	
	public ArrayList<Card> getCards(){
		return this.cards;
	}
	
	public String toString(){
		String cards = " ";
		for(Card c: this.cards){
			cards+= c.toString() + " ";
		}
		
		return cards;
	}
	
}