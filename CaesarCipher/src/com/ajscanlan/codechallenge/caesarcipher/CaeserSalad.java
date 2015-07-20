package com.ajscanlan.codechallenge.caesarcipher;

public class CaeserSalad {

	String encryptLettuce(String text){
		char tempTomatoe;
		char [] charText = text.toCharArray();
		
		for(int i = 0 ; i < charText.length;i++ ){
			tempTomatoe = charText[i];
			tempTomatoe++;
			charText[i] = tempTomatoe;
		}
		String temp = new String(charText);
		return temp;
	}
	
	String dencryptLettuce(String text){
		char tempTomatoe;
		char [] charText = text.toCharArray();
		
		for(int i = 0 ; i < charText.length;i++ ){
			tempTomatoe = charText[i];
			tempTomatoe--;
			charText[i] = tempTomatoe;
		}
		String temp = new String(charText);
		return temp;
	}
	
	
}
