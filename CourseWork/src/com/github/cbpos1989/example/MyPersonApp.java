/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class MyPersonApp{


	public static void main(String[] args){
		MyPersonApp myApp = new MyPersonApp();
		myApp.createPerson();
	}
	
	void createPerson(){
		OtherPerson p = new OtherPerson();
		OtherPerson p1 = new OtherPerson();
		p.setName("Colm");
		p1.setName("Mloc");
		p.setAge(26);
		p1.setAge(62);
		p.setGender('m');
		p1.setGender('f');
		System.out.println("Name: " + p.getName() + "\nAge: " + p.getAge() + "\nGender: " + p.getGender());
		System.out.println("Name: " + p1.getName() + "\nAge: " + p1.getAge() + "\nGender: " + p1.getGender());
	}
}

class OtherPerson{
	private int age;
	private String name;
	private char gender;
	
	int getAge(){
		return age;
	}
	
	void setAge(int age){
		this.age = age;
	}
	
	String getName(){
		return name;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	char getGender(){
		return gender;
	}
	
	void setGender(char gender){
		this.gender = gender;
	}
}



