/**
 * App to demonstrate different types of operators used in if/else statements.
 */
package courseWork;

/**
 * @author cbpos1989
 *
 */
import java.util.Scanner;

public class StateApp{

	String name;
	private int age;
	private Scanner scan;

	public static void main(String[] args){
			
		StateApp sa = new StateApp();

		if(args.length >= 2){
			System.out.println("Name: " + args[0] + " Age: " + args [1]);
		}
		else{
			System.out.println("Not enough arguements");
			
		}
		
		sa.beginApp();
	} 

	public void beginApp(){
		
		scan = new Scanner(System.in);

		System.out.print("Enter Name ");
		String nameInput = scan.nextLine();
		name = nameInput.replaceAll("[^A-Za-z]", "");
		

		System.out.print("Enter Age ");
		String ageInput = scan.nextLine();
		String ageTemp = ageInput.replaceAll("[^0-9]","");
		
		
		
		age = Integer.parseInt(ageTemp);
		
		ageCheck(age);
		

		/*
		System.out.println("Hello " + name + " you are " + age);
		incrementAge();
		System.out.println("Hello " + name + " you are " + age);
		decrementAge();
		System.out.println("Hello " + name + " you are " + age);*/
	}


	void ageCheck(int ageLocal){
		

		if(ageLocal > 17 && age < 201){
			System.out.println("Welcome " + name);
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