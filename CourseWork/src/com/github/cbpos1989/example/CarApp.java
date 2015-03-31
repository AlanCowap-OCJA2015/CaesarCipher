/**
 * 
 */
package com.github.cbpos1989.example;

/**
 *  App made as part of one day code challenge on the course.
 * @author Colm O'Sullivan, Mick Murphy, James MacMahon & Conor
 *
 */
import java.util.Scanner;

public class CarApp{
	private int regInput = 4748;
	private int vinNumber = 8868;
	Vehicle [] vehArray = new Vehicle[90];
	private Scanner scan;

	public static void main(String[] args){
		//System.out.println("Working");
		CarApp myCarApp = new CarApp();
		myCarApp.createArray();
		myCarApp.userMenu();
		
	}
	
	void userMenu(){
		scan = new Scanner(System.in);
		boolean validInput = false;
		
		do {
			System.out.print("---CarApp Menu---\n1)Show List of Cars\n2)Search Index\n3)Search by Vin\n4)Search by Reg\n5)Quit\nEnter Your Choice: ");
			String userInput = scan.nextLine();
		
		
			switch (userInput){
				case "1": 	showArray(); 					break;
				case "2":	searchIndex();					break;
				case "3": 	searchByVin(); 					break;
				case "4":	searchByReg();					break;
				case "5": 	System.out.println("Goodbye, Sir");
						validInput = true; 				break;
				default:   	System.out.println("!!!InvalidInput!!!");	break;
			}
		} while (validInput == false);
		
		
	}

	void createArray(){
		//Vehicle [] vehArray = new Vehicle[90];

		for(int i = 0; i < (vehArray.length); ++i){
			
			if(i < 70){
				vehArray[i] = new Car();
				userInput();
				vehArray[i].setReg(regInput);
				vehArray[i].setVin(vinNumber);
				//System.out.println("Name" + vehArray[i].getCarName());

			} else if (i > 69 && i < 80) {
				vehArray[i] = new Bike();
				userInput();
				vehArray[i].setReg(regInput);
				vehArray[i].setVin(vinNumber);
			} else {
				vehArray[i] = new Van();
				userInput();
				vehArray[i].setReg(regInput);
				vehArray[i].setVin(vinNumber);
			}
			
		}
		
	}

	void showArray(){
		for(int i = 0; i < (vehArray.length); ++i){
			System.out.println((i+1) + ")\n" + vehArray[i]);
		}
		System.out.println("");
	}

	void searchIndex(){
		scan = new Scanner(System.in);
		boolean validInput = false;
		
		do{
			System.out.print("Enter Index Number: ");
		
			String userInput = scan.nextLine();
			try{
				int indexNumber = Integer.parseInt(userInput);
				indexNumber -= 1;	
				System.out.println("\nThis is the Vehicle at " + (indexNumber+1) + "\n" + vehArray[indexNumber] + "\n");
				validInput = true;
			} catch (NumberFormatException nfe) {
				System.out.println("---");
			}
		} while (validInput == false);
		
		
	}

	void searchByNumber(){
		scan = new Scanner(System.in);
		System.out.print("1) Search by Vin Number\n2) Search by Reg Number\nEnter Your Choice: ");
		String userInput = scan.nextLine();
		
		switch (userInput) {
			case "1": searchByVin(); break;
			case "2": searchByReg(); break;
			default:   System.out.println("!!!InvalidInput!!!");	break;
		}
			
	}

	void searchByVin(){
		scan = new Scanner(System.in);
		boolean validInput = false;
		do{
			System.out.print("Search for Vin Number: ");
			String userInput = scan.nextLine();

	
			try{
				int userNumber = Integer.parseInt(userInput);

				for(int i = 0; i < (vehArray.length); ++i){
					if(vehArray[i].getVin() == userNumber){
						System.out.println("\nThis is the Vehicle at " + userNumber + ": \n" + vehArray[i] + "\n");
					}
				}
				validInput = true;
			} catch (NumberFormatException nfe) {
		
			}
		} while (validInput == false);
	}

	void searchByReg(){
		scan = new Scanner(System.in);
		boolean validInput = false;
		do{
			System.out.print("Search for Reg Number: ");
			String userInput = scan.nextLine();
	
			try{
				int userNumber = Integer.parseInt(userInput);

				for(int i = 0; i < (vehArray.length); ++i){
					if(vehArray[i].getReg() == userNumber){
						System.out.println("\nThis is the Vehicle at " + userNumber + ": \n" + vehArray[i] + "\n");
					}
				validInput = true;
				}
			} catch (NumberFormatException nfe) {
			
			}
		} while (validInput == false);
	}
	
	void userInput(){
		scan = new Scanner(System.in);
		
		++regInput;
		++vinNumber;

		/*
		System.out.print("Enter Reg Number: ");
		regInput = scan.nextLine();
		//setReg(regInput);

		System.out.print("Enter Vin Number: ");
		String vinInput = scan.nextLine();

		try {
			vinNumber = Integer.parseInt(vinInput);
		} catch (NumberFormatException) {
			
		}
		*/
	}

	void userOutput(){
	
	}

	

}

class Vehicle{
		
		int vinNum = 1;
		int regNum  = 2;
	public void setVin(int vinNum){
		this.vinNum = vinNum;
	}
	
	public void setReg(int regNum){
		this.regNum = regNum;	
	}
	
	public int getVin(){
		return this.vinNum;
	}	
	public int getReg(){
		return this.regNum;
	}
	public String toString(){
		return "Reg Number: " + this.regNum + "\nVin Number: " + this.vinNum;
	}


} //end method

class Car extends Vehicle{
	
	String carName = "Ford Focus";	
	
	public void setCarName(String carName){
		this.carName = carName;
	}
	public String getCarName(){
		return this.carName;
	}
	public String toString(){
		return super.toString() + "\nCar Make: " + this.carName;
	}
}

class Bike extends Vehicle{
	
	String bikeName = "Triumph Herald";	
	boolean sideCart = false;
	public void setBikeName(String bikeName){
		this.bikeName = bikeName;
	}
	public void setSideCart(boolean sideCart){
		this.sideCart = false;	
	}
	public String getBikeName(){
		return this.bikeName;
	}
	public boolean getSideCart(){
		return this.sideCart;
	}
	public String toString(){
		return super.toString() + "\nBike Make: " + this.bikeName + "\nHas Sidecar: " + this.sideCart;
	}
	
}

class Van extends Vehicle{
	
	String vanName = "Toyota Hi-Ace";	
	boolean trailerHitch = false;
	public void setVanName(String vanName){
		this.vanName = vanName;
	}
	public void setTrailerHitch(boolean trailerHitch){
		this.trailerHitch = false;	
	}
	public String getvanName(){
		return this.vanName;
	}
	public boolean getTrailerHitch(){
		return this.trailerHitch;
	}
	public String toString(){
		return super.toString() + "\nVan Name: " + this.vanName  + "\nHas Hitch: " + this.trailerHitch + "\nCapicity: 10m ^ 3";
	}
	
}