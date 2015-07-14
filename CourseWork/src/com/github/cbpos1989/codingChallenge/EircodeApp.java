/**
 * 
 */
package com.github.cbpos1989.codingChallenge;

import java.util.Scanner;

/**
 * @author User1
 *
 */
public class EircodeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EircodeApp ea = new EircodeApp();
		ea.initialiseApp();

	}
	
	void initialiseApp(){
		//System.out.print("Working")
		boolean invalidChoice = true;
		do{
		Scanner scan = new Scanner(System.in);
		String oldChoice ;
		System.out.println("---Eircode App Menu---\n1) Enter eircode\n2) Quit");
		oldChoice = scan.next();
		int choice = Integer.parseInt(oldChoice);
		if(choice==1){
			
			invalidChoice = false;
		}else{
			System.out.println("Thank You for using the eircode app\u00A9");
			invalidChoice = false;
		}
		
	}while(invalidChoice);
		
	}
}
