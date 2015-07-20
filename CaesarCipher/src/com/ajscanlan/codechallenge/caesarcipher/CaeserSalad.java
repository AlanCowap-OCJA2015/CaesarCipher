package com.ajscanlan.codechallenge.caesarcipher;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Greg, Mick and PrM by Alex LTD.
 *
 */
public class CaeserSalad {

	void encryptLettuce(int choice){
		Scanner scan = new Scanner(System.in);
		boolean isCorrectNum = true;
		int shiftySalad = 0;

		do{
			System.out.println("Please enter shift magnitude (minus or plus whole number): ");
			shiftySalad = 0;
			try {
				scan = new Scanner(System.in);
				shiftySalad = scan.nextInt();
				isCorrectNum = false;
			} catch (InputMismatchException e) {
				System.out.println("Not a valid number.");
			}

		}while(isCorrectNum);

		while(shiftySalad > 94){
			shiftySalad -= 94;
		}

		if(choice == 2){
			shiftySalad = -shiftySalad;
		}
		boolean is140Chars = true;
		String text = null;
		do{
			scan = new Scanner(System.in);
			System.out.println("Please enter the sentence you want to encypt/decrypt (140 characters maximum): ");
			text = scan.nextLine();
			if(text.length() < 141){
				is140Chars = false;
			}else{
				System.out.println("Must be 140 characters or less.");
			}
			
		}while(is140Chars);

		char tempTomato;
		char [] charText = text.toCharArray();




		for(int i = 0 ; i < charText.length;i++ ){
			tempTomato = charText[i];
			tempTomato += shiftySalad;
			if(tempTomato > 126){
				//tempTomato = 32;
				int temp = tempTomato - 126;
				temp = 32 + temp;
				tempTomato = (char)temp;


			}else if( tempTomato < 32){
				int temp = tempTomato + 126;
				temp = temp - 32;
				tempTomato = (char)temp;
			}
			charText[i] = tempTomato;
		}
		String temp = new String(charText);
		//	scan.close();
		System.out.println(temp);
	}



}
