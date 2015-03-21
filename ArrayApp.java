/**
 * App to demonstrate how to initialize and populate an array.
 */
package courseWork;

/**
 * @author cbpos1989
 *
 */
import java.util.Scanner;

public class ArrayApp{
	int arraySize = 100;
	int scoresTotal = 0;
	int minValue = 0;
	int maxValue = 0;
	private Scanner scan;

	public static void main(String[] args){
		//System.out.println("Working");
		ArrayApp myArrayApp = new ArrayApp();
		myArrayApp.inputData();
		myArrayApp.creatNewArray(myArrayApp.arraySize);
		
	
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
			
			scores[i] = (i+1);
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
		
		
		System.out.printf("\nMean number of array: " + meanNumber);
		System.out.println("Smallest number in array: " + minNumber);
		System.out.println("Largest number in array: " + maxNumber);
		System.out.println("Total number: " + scoresTotal);
	
	}

}
