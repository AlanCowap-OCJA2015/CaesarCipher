package com.ajscanlan.codechallenge.caesarcipher;

import java.util.Scanner;

public class CaeserSalad {

	void encryptLettuce(int choice){


		System.out.println("Please enter shift magnitude");

		Scanner scan = new Scanner(System.in);		
		int shiftySalad = scan.nextInt();

		if(choice == 2){
			shiftySalad = -shiftySalad;
		}


		scan = new Scanner(System.in);

		System.out.println("please enter the sentence you want to encypt/decrypt");
		String text = scan.nextLine();
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
