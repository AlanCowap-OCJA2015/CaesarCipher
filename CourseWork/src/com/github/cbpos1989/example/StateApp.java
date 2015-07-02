/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App to demonstrate different types of operators used in if/else statements.
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class StateApp{

	private String name = "John";
	private int age = 21;
	private Scanner scan;
	private boolean invalidInput = true;

	public static void main(String[] args){
			
		StateApp sa = new StateApp();

//		if(args.length >= 2){
//			System.out.println("Name: " + args[0] + " Age: " + args [1]);
//		}
//		else{
//			System.out.println("Not enough arguements");
//			
//		}
		
		sa.beginApp();
	} 

	public void beginApp(){
		
		scan = new Scanner(System.in);
		
		do{
			System.out.println("1) Enter Your Name \n2) Enter Your Age \n3) Print Details \n4) Exit ");
			
			int i = scan.nextInt();

			switch(i){
			case 1: invalidInput = false;
					enterName(); break;
			case 2: invalidInput = false;
					enterAge(); break;
			case 3: ageCheck(age);
					invalidInput = false; break;
			case 4: System.out.println("4");
			default: System.out.println("Wrong Entry");break;
			}
		} while (invalidInput);
		
//		System.out.println("Hello " + name + " you are " + age);
//		incrementAge();
//		System.out.println("Hello " + name + " you are " + age);
//		decrementAge();
//		System.out.println("Hello " + name + " you are " + age);
	}
	
	void enterAge(){
		invalidInput = true;
		do{
			System.out.print("Enter Age ");
			String ageInput = scan.next();
			ageInput = ageInput.replaceAll("[^0-9]", "");
			age = Integer.parseInt(ageInput);
			invalidInput = !(scan.hasNextLine());
		} while(invalidInput);
		
		invalidInput = true;
	}

	void enterName(){
		
		do{
			System.out.print("Enter Name ");
			String nameInput = scan.next();
			name = nameInput.replaceAll("[^A-Za-z]", "");
			invalidInput = !(scan.hasNextLine());
		} while(invalidInput);
		
		invalidInput = true;
	}

	void ageCheck(int ageLocal){
		

		if(ageLocal > 17 && age < 201){
			System.out.println("Welcome " + name + "Who is " + age + " years old");
		}
		else if(ageLocal < 18){
			System.out.println("You are too young " + name);
		}
		else{
			System.out.println("You are too old " + name);
		}
	}
	
	public void incrementAge(){
		age++;
	}

	public void decrementAge(){
		age--;
	}


}