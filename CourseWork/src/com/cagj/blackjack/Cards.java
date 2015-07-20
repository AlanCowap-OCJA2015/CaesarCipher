/**
 * 
 */
package com.cagj.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Cards holds the cards
 * 
 * @author Colm O'Sullivan, Artjoms Porss, Gregory Harman & Joe Murphy
 */
public class Cards {
	ArrayList<Card> cards = new ArrayList<Card>();

	private String name;
	
	public Cards(String name){
		this.name = name;
	}

	public void addAce(){
		cards.add(new Card(Suits.SPADES, "A"));
	}
	
	
	public String getName() {
		return name;
	}




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