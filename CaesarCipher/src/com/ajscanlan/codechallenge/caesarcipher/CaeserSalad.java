package com.ajscanlan.codechallenge.caesarcipher;

import java.util.Scanner;

public class CaeserSalad {

	String encryptLettuce(int shiftySalad){
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the sentence you want to encypt");
		String text = scan.nextLine();
		char tempTomato;
		char [] charText = text.toCharArray();
		
		for(int i = 0 ; i < charText.length;i++ ){
			tempTomato = charText[i];
			tempTomato += shiftySalad;
			charText[i] = tempTomato;
		}
		String temp = new String(charText);
	//	scan.close();
		return temp;
	}
	
	String dencryptLettuce(int shiftySalad){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the sentence you want to decrypt");
		String text = scan.nextLine();
		char tempTomato;
		char [] charText = text.toCharArray();
		
		for(int i = 0 ; i < charText.length;i++ ){
			tempTomato = charText[i];
			tempTomato -= shiftySalad;
			charText[i] = tempTomato;
		}
		String temp = new String(charText);
	//	scan.close();
		return temp;
	}
	
	
}
