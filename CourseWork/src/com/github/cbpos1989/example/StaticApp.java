/**
 * This app demonstrates the difference between static and non-static
 */
package com.github.cbpos1989.example;

/**
 * 
 * @author cbpos1989
 *
 */
public class StaticApp{
	private static final int MAX_NUM_PEOPLE = 20;
	private Person[] people = new Person[MAX_NUM_PEOPLE];

	
	
	public static void main (String[] args){
		//System.out.println("Working");

		new StaticApp().runProgram();
		
		
	}

	private void intializeArray(){
		for (int i = 0; i < MAX_NUM_PEOPLE; ++i) {
			people[i] = new Person("John Doe", 18);
		}
	}

	private void runProgram(){
		System.out.println("Total number of people: " + Person.getPeopleTotal());

		this.intializeArray();

		for (Person p: people) {
			System.out.println(p);
			
		}

		System.out.println("Total number of people: " + Person.getPeopleTotal());
		
	}


}

class Person{
	private String name = null;
	private int age = -1; 
	private static int peopleTotal = 0;
	
	public Person(){
	
	}

	public Person(String name, int age){
		this.name = name;
		this.age = age;
		peopleTotal++;
	}

	public String toString(){
		return "Name: " + this.name + " Age: " + this.age;
	}

	public static int getPeopleTotal(){
		return peopleTotal;
	}

}