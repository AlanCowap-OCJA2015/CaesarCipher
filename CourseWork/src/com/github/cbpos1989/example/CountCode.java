/**
 * 
 */
package com.github.cbpos1989.example;


public class CountCode {

	
	public static void main(String[] args) {
		CountCode countCode = new CountCode();
		System.out.println(countCode.initialise("aaaacodecccccode"));
	}
	
	int initialise(String str){
		
		return findWordIndex(str, "co");
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


