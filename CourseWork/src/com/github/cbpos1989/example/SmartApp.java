/**
 *  App used to demonstrate inheritance and object oriented programming. 
 */
package com.github.cbpos1989.example;

/**
 * @author cbpos1989
 *
 */
import java.util.Scanner;
import java.util.Random;

public class SmartApp {
	private static final int MAX_NUMBER_DEVICES = 100;
	//private static final int MAX_NUMBER_PHONES = 40;
	//private static final int MAX_NUMBER_TABLETS = 40;
	//private static final int MAX_NUMBER_WATCHES = 20;
	

	private Scanner scan;
	private Random rnd;
	private Device[] devices = new Device[100];
	

	public static void main(String[] args){
		//System.out.println("Working");
		
		SmartApp sa = new SmartApp();
		sa.createArray();
		sa.displayMenu();
		
	}
	
	void createArray(){
		rnd = new Random();
		
		
		for (int i = 0; i < MAX_NUMBER_DEVICES; ++i ) {
			int randomNum = rnd.nextInt(3);
	
			if(randomNum == 0){
				devices[i] = new Phone("Samsung", "S6", 6, "087567451" + i);
			} else if (randomNum == 1){
				devices[i] = new Tablet("Samsung", "Tab4", 10); 
			} else {
				devices[i] = new Watch("Samsung", "Gear", 2); 
			}
			
		}

		
	}

	void displayMenu(){
		scan = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("____SmartApp Menu____");
		
			do{		
			System.out.println("1)Search for device a specified index\n2)Print out list of devices\n3)Calculate total of screensizes\n4)Quit Program");
			System.out.print("\nEnter Your Choice: ");
			userInput = scan.nextLine();
			
			switch(userInput){
				case "1" : searchArray(); break;
				case "2" : displayArray(); break;
				case "3" : calculateArray(); break;
				case "4" : System.out.println("Exiting Program"); break;
				default : System.out.println("---Invalid Input---"); break;
			}
		} while(!userInput.equals("4"));
	}
	
	void searchArray(){
		//System.out.println("Searching Array");
		
		System.out.print("\nEnter number 1...100: ");
		String index = scan.nextLine();
		int idx = Integer.parseInt(index);


		System.out.println("\n" + idx + ") " + devices[idx] + "\n");

		System.out.println("Add New Details for entry @ " + idx);
		System.out.println("Enter Manufacturer: ");
		String ma = scan.nextLine();

		System.out.println("Enter Model: ");
		String md = scan.nextLine();

		System.out.println("Enter Screensize: ");
		int sc = Integer.parseInt(scan.nextLine());

		devices[idx] = new Tablet(ma, md, sc);

	}
	
	void displayArray(){
		//System.out.println("Print Array");
		int count = 1;		

		for (Device d: devices) {
			System.out.println(count + ") " + d);
			count++;
		}
		
		System.out.println("");
	}
	
	void calculateArray(){
		//System.out.println("500");
		int total = 0;

		for (Device d: devices) {
			total += d.getScreensize();
		}

		System.out.println("Screensize Total = " + total);
	}
	
}

class Device {
	private String manufacturer = null;
	private String model = null;
	private int screensize = -1;
	
	public Device(){
		
	}
	
	public Device(String manufacturer, String model, int screensize){
		this.manufacturer = manufacturer;
		this.model = model;
		this.screensize = screensize;
	}

	public int getScreensize(){
		return this.screensize;
	}
	
	public String toString(){
		return "Manufacturer: " + this.manufacturer + " Model: " + this.model + " Screensize: " + this.screensize;
	}
}

class Phone extends Device {
	String phoneNumber = "0000000000";

	public Phone(String manufacturer, String model, int screensize, String phoneNumber){
		super(manufacturer, model, screensize);
		this.phoneNumber = phoneNumber;
	}

	public String toString(){
		return super.toString() + " Phone Num: " + this.phoneNumber;
	}
}

class Tablet extends Device{
	
	public Tablet(String manufacturer, String model, int screensize){
		super(manufacturer, model, screensize);
	}

	public String toString(){
		return super.toString();
	}
}

class Watch extends Device{
	
	public Watch(String manufacturer, String model, int screensize){
		super(manufacturer, model, screensize);
	}

	public String toString(){
		return super.toString();
	}
}