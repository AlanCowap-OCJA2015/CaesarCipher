/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App to demonstrate how to create a user driven menu.
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class MenuApp{
	private String name;
	int age;
	String nameOption = "1";
	String ageOption = "2";
	String exitOption = "3";

	public static void main(String[] args){
		//System.out.println("Working");
		
		MenuApp myMenuApp = new MenuApp();

		myMenuApp.inputDialog();
	}

	void inputDialog(){
		System.out.println("Name: " + getName() + " Age: " + getAge());
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 to add Name" + "\nEnter 2 to add Age" 
			+ "\nEnter 3 to Quit");
		String dialogInput = scan.nextLine();
		
		if (dialogInput.equals(nameOption)) {
			inputName(scan);
		}
		else if (dialogInput.equals(ageOption)) {
			inputAge(scan);
		}
		else if (dialogInput.equals(exitOption)) {
			exit();
		}
		else {
			System.out.println("!!!Incorrect Entry!!!");
			inputDialog();
		}
		
	}

	void inputName(Scanner scan){
		//System.out.println("inputName");
		System.out.print("Enter Your Name: ");
		String nameInput = scan.nextLine();
		name = nameInput.replaceAll("[^A-Za-z]","");
		inputDialog();
	}

	public String getName(){
		return name;
	}

	void inputAge(Scanner scan){
		//System.out.println("inputAge");
		System.out.print("Enter Your Age: ");
		String ageInput = scan.nextLine();
		ageInput = ageInput.replaceAll("[^0-9]","");
		age = Integer.parseInt(ageInput);
		
		if (age > 17 && age < 199) {
			inputDialog();
		}
		else {
			System.out.println("Incorrect Age");
			age = 0;
			inputDialog();
		}
	}

	public int getAge(){
		return age;
	}

	void exit(){
		System.out.println("!!!Exiting Program!!!");
		System.exit(0);
	}
}
