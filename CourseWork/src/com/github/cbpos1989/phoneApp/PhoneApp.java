package com.github.cbpos1989.phoneApp;

public class PhoneApp {
	private Phone[] phones = new Phone[3];
	
	public static void main(String[] args) {
		PhoneApp phoneApp = new PhoneApp();
		phoneApp.initialiseApp();
	}
	
	void initialiseApp(){
		createPhones();
		printPhoneDetails();
	}
		
	void createPhones(){
		phones[0] = new Phone("Samsung", "S5", 5.0F, 4);
		phones[1] = new Phone("Samsung", "S6", 6.0F, 8);
		phones[2] = new Phone("HTC", "x55",5.5F,5);
	}
	
	void printPhoneDetails(){
		float screenSizeTotal = 0;
		int memoryCapacityTotal = 0;
		
		for(Phone p : phones){
			System.out.println(p.toString());
			screenSizeTotal += p.getScreenSize();
			memoryCapacityTotal += p.getMemoryCapacity();
		}
		
		System.out.println("Total Screensize: " + screenSizeTotal);
		System.out.println("Total Memory Capacity: " + memoryCapacityTotal);
	}
}
