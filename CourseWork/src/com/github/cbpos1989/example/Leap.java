/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App to demonstrate logical operators. 
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class Leap{
	int intYear = 2000;
	private Scanner scan;	

	public static void main(String[] args){
		//System.out.println("Working");
		
		Leap myLeap = new Leap();
		myLeap.userInput();
		
		if (myLeap.isLeapYear(myLeap.getYear()) == true) {
			System.out.println(myLeap.getYear() + " is a leap year");
		} else {
			System.out.println(myLeap.getYear() + " is not a leap year");
		}
	}

	void userInput(){
		scan = new Scanner(System.in);
		boolean validInput = false;
		
		do{
			System.out.print("Enter a Year: ");
			String yearInput = scan.nextLine();

			if (yearInput.length() < 4) {
				System.out.println("---Invalid Input---\n");
				continue;
			} else {
				try{
					intYear = Integer.parseInt(yearInput);
					validInput = true;
				} catch(NumberFormatException nfe) {
					System.out.println("---Invalid Input---\n");
				}
			}
		} while (validInput == false);

	}

	void getLeapYears(){
	
	}

	int getYear(){
		return intYear;
	}

	boolean isLeapYear(int year){
		
		if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)){
			return true;
		} else {
			return false;
		}
	}
}
