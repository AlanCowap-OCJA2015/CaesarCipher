/**
 * 
 */
package com.github.cbpos1989.example;

import java.util.Random;
/**
 * App to demonstrate how to initialise and populate an array.
 * 
 * @author Colm O'Sullivan
 *
 */
import java.util.Scanner;

public class ArrayApp{
	private int arraySize = 100;
	private int scoresTotal = 0;
	private int minValue = 0;
	private int maxValue = 0;
	private Scanner scan;
	

	public static void main(String[] args){
		//System.out.println("Working");
		ArrayApp myArrayApp = new ArrayApp();
		myArrayApp.inputData();
		myArrayApp.creatNewArray(myArrayApp.arraySize);
	}

	private int randomGenerator(){
		Random rand = new Random();
		return rand.nextInt(101);
	}
	
	void inputData(){
		scan = new Scanner(System.in);
		System.out.print("Enter size of scores array: ");
		String arraySizeInput = scan.nextLine();
		arraySize = Integer.parseInt(arraySizeInput);
	} 
	
	void creatNewArray(int arrSize){
		//System.out.println("Working");

		int[] scores = new int[arrSize];
		
		for (int i = 0; i < scores.length; ++i) {
			
			scores[i] = (randomGenerator());
			System.out.print(scores[i] + " ");

			scoresTotal = scores[i] + scoresTotal;
			
		}
		
		minValue = scores[0];
		maxValue = scores[0];
		
		for (int i = 0; i < scores.length;  ++i) {
			
			if (scores[i] < minValue) {
				minValue = scores[i];
	
			}
			
			if (scores[i] > maxValue) {
				maxValue = scores[i];
			}
			
		}
		
		int minNumber = minValue;
		int maxNumber = maxValue;
		double meanNumber = (double)scoresTotal/scores.length;
		
		
		System.out.println("\nMean number of array: " + meanNumber);
		System.out.println("Smallest number in array: " + minNumber);
		System.out.println("Largest number in array: " + maxNumber);
		System.out.println("Total number: " + scoresTotal);
	
	}

}
