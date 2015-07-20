/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class MethodMan {
	String name;
	int age;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodMan mm = new MethodMan("Joe Bloggs", 25);
		System.out.print(mm.toString());
	}
	
	public MethodMan(String name, int age){
		setName(name);
		setAge(age);
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public String toString(){
		return "Name: " + getName() + "\nAge: " + getAge();
	}

}
