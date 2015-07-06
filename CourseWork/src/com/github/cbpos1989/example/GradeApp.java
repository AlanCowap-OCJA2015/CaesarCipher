/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App that demonstrates the use of the switch statement. 
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class GradeApp{
	int result = 0;
	String grade = null;
	String resultGrade = null;
	String userOption1 = "1";
	String userOption2 = "2";
	String userInput = null;
	private Scanner scan;


	public static void main(String[]args){
		//System.out.println("Working");

		GradeApp myGradeApp = new GradeApp();
		
		
		if(args.length == 1){
			try{
				myGradeApp.result = Integer.parseInt(args[0]);
				myGradeApp.calculateResult(myGradeApp.result);
			}catch(Exception ex){
				myGradeApp.grade = args[0].toUpperCase();
				myGradeApp.calculateGradeRange(myGradeApp.grade);
				
			}
		}
		else if(args.length == 0){
			//System.out.println("Please enter a result");
			myGradeApp.enterResult();
			
		}


	}

	//Allows User to Input Result if they failed to do so at Runtime Command Line
	void enterResult(){
	
		scan = new Scanner(System.in);
		
		if (userInput == null) {
			System.out.println("Enter 1 to input number grade\nEnter 2 to input alpha grade");
			userInput = scan.nextLine();
			enterResult();
		} else {
		
			if (userInput.equals(userOption1)) {
			
				System.out.print("Enter Your Result: ");
				String inputResult = scan.nextLine();
		
				//Replaces all characters in String except for digits(positive or negative)
				String inputResultTemp = inputResult.replaceAll("[^-0-9]","");
			
				if (inputResultTemp.length() > 1) {
					result = Integer.parseInt(inputResultTemp);
					if(result > 0){
						System.out.println(result);
						calculateResult(result);
					} else {
						System.out.println("You Failed Horribly\n!!!Ending Program Now!!!");
					}
				} else {
					enterResult();
				}
			
			
			} else if (userInput.equals(userOption2)) {
				System.out.print("Enter Your Grade: ");
				String inputGrade = scan.nextLine();
				String inputGradeTemp = inputGrade.replaceAll("[^A-Za-z]","");
				System.out.println(inputGradeTemp);
				if (inputGradeTemp.length() >= 1) {
				
					calculateGradeRange(inputGradeTemp.toUpperCase());
				
				} else {
					System.out.println("Enter valid value");
					enterResult();
				}
		
			} else {
				userInput = null;
				enterResult();
			}
		
		}
		
	}

	//Takes user Input Result value and checks what grade they will recieve
	void calculateResult(int resultInput){

		if (resultInput > 84) {
			System.out.println("You got an A");
		} else if(resultInput > 69) {
			System.out.println("You got a B");
		} else if(resultInput > 54) {
			System.out.println("You got a C");
		} else if(resultInput > 39) {
			System.out.println("You got a D");
		} else if(resultInput > 24) {
			System.out.println("You got an E");
		} else {
			System.out.println("You got nothing");
		}
		
		
	}

	void calculateGradeRange(String gradeInput){
		switch(gradeInput){
			case "A": resultGrade = "85-100"; break;
			case "B": resultGrade = "70-84"; break;
			case "C": resultGrade = "55-69"; break;
			case "D": resultGrade = "40-54"; break;
			default: resultGrade = "Fail";
		}
		
		System.out.println("Your grade range is: " + resultGrade);
		
	}
	
}