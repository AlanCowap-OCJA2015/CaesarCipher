/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */

public class CatDog {


	public static void main(String[] args) {
		CatDog catDog = new CatDog();
		System.out.println(catDog.initialise("catdogcatcatcatdgocadocatdogdogdogdog"));
	}
	
	boolean initialise(String str){
		
		if(findWordIndex(str,"cat") == findWordIndex(str,"dog")){
			return true;
		} else {
			return false;
		}
		//System.out.println("Number of Times String Appears: " + findWordIndex(str, "cat"));
		//System.out.println("Number of Times String Appears: " + findWordIndex(str, "dog"));
	}
	
	int findWordIndex(String text, String word){
		int index = -1;
		int counter = 0;
		
		do{
			index = text.indexOf(word);
			
			if(index != -1){
				counter++;
				text = text.substring(index + word.length());
				System.out.println(text);
			}
		} while(index != -1);
		
		return counter;
	}
}
