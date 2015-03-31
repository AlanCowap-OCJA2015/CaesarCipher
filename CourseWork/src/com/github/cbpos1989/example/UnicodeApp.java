/**
 * App to demonstrate the use of char variables and command line arguments.
 */
package com.github.cbpos1989.example;

/**
 * @author cbpos1989
 *
 */
public class UnicodeApp{
	public static void main(String[] args){
		//System.out.println("Working");
		UnicodeApp myUniApp = new UnicodeApp();
		
		if (args.length > 0) {
			if (args[0].equals("A")) {
				myUniApp.createArray();
			}
		} else {
			myUniApp.runLoop();
		}
	
	}

	void createArray(){
		System.out.println("!!!You picked an Array!!!");

		char[] uniArray = new char[140];
		char j = 21;
		
		int countLine = 1;
		String newLine;
		
		for(int i = 0; i < 139; ++i){
			
			uniArray[i] = j;
			++j; 
			newLine = (countLine % 10 == 0) ? "\n" : " ";
			System.out.print(uniArray[i] + newLine);
			++countLine;
		}

		
	}

	void runLoop(){
		System.out.println("!!!You picked a For Loop!!!");
		int count = 0;
		for(char i = 21; i < 162; ++i){
			System.out.print(i + " ");
			++count;
			
			if(count == 10){
				System.out.println("");
				count = 0;
			}	
		}
	}

}