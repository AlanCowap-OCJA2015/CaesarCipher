/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App made as part of coding test on the course. Create a menu that allows user to enter name and age as well as print those details.
 * Also creating a array of number 1..20 then calculating the total.
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class ExamApp{
	String nameInput = "J Doe";
	int age = 18;
	int totalArray = 0;
	private Scanner scan;
	
	public static void main(String[] args){
		//System.out.println("Working");
	
		ExamApp myExamApp = new ExamApp();
		myExamApp.showMenu();
	}
	
	void showMenu(){
		boolean closeMenu = false;
		scan = new Scanner(System.in);
		
		do{
			System.out.println("\n1)Enter a name and age\n2)Print a name and age\n3)Calculate Total\n4)Quit");
			System.out.print("Enter Your Choice: ");
			String userInput = scan.nextLine();
			
			switch(userInput){
				case "1":	
						setName();	
						setAge(); break;
				case "2":
						System.out.println("");
						System.out.println("Name: " + getName() + "\nAge: " + getAge()); break;
				case "3":
						createArray();
						System.out.println("The Total of Your Array is " + getArrayTotal()); break;

				case "4": 	closeMenu = true; break;
				default:	System.out.println("\n!!!Invalid Entry!!!"); 
			}
		} while(closeMenu == false);
	}

	void setName(){
		scan = new Scanner(System.in);
		System.out.print("\nEnter Your Name: ");
		nameInput = scan.nextLine();
	}

	String getName(){
		return nameInput;
	}

	void setAge(){
		boolean validInput = false;
		int invalidCount = 0;
		scan = new Scanner(System.in);
		
		do{
			System.out.print("Enter Your Age: ");
			String ageInput = scan.nextLine();
		
			try{
				age = Integer.parseInt(ageInput);
				validInput = true;
			} catch(NumberFormatException nfe) {
				System.out.println("!!!Invalid Entry!!!");
				invalidCount++;
			}
		} while(validInput == false && invalidCount < 10);
	}

	int getAge(){
		return age;
	}

	void createArray(){
		System.out.println("\n---Creating Array of Numbers---");
		int[] numArray = new int[20];

		for(int i = 0; i < 20; ++i){
			numArray[i] = i;
			System.out.print(numArray[i] + " ");
			totalArray += numArray[i];
		}
	}

	int getArrayTotal(){
		return totalArray;
	}

}
