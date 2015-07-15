/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App to demonstrate boxing and unboxing of the Wrapper classes
 * 
 * @author Colm O'Sullivan
 *
 */
public class BoxingApp {

	
	public static void main(String[] args) {
		BoxingApp ba = new BoxingApp();
		ba.boxingDay(26);
	}
	
	boolean boxingDay(Integer day){	//boxing in parameter 
		Boolean isBox = true;		//boxing in java literal keywords
		Short num = 360;			//boxing in primitive number values
		if(isBox){
			System.out.println(++num);
		}
		
		return !isBox;
	}

}
