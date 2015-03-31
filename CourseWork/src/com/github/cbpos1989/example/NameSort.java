/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App that creates a file (namerandom.txt) with 15 random names, 
 * puts them in an array, sorts them alphabetically, and output them to a second file (namesorted.txt). 
 * 
 * @author Colm O'Sullivan
 *
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class NameSort {
	ArrayList<nameEnum> nameList = new ArrayList<nameEnum>();
	File nameRandom;
	
	public static void main(String[] args){
		//System.out.println("Working");
		
		NameSort ns = new NameSort();
		ns.createFile();
		
		for(nameEnum s: nameEnum.values())
			System.out.print(s + " ");
	}
	
	
	void createFile(){
		try{
			File myDir = new File("/Users/cbpos1989/Desktop/Test_Dir");
			myDir.mkdir();
			
			nameRandom = new File(myDir, "namerandom.txt");
			nameRandom.createNewFile();
			
			if (nameRandom.exists()) {
				System.out.println("File Created");
				writeFile();
			}
			
		} catch (IOException ioe) {
			System.out.println("No File Created");
		}
	}
	
	void writeFile(){
		try{
			FileWriter fw = new FileWriter(nameRandom);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(nameEnum ne: nameEnum.values()){
				String str = ne.toString();
				bw.write(str + ",");
			}
			
			bw.flush();
			bw.close();
			
			
		} catch (IOException ioe) {
			System.out.println("Didn't Write File");
		}
	}
}

enum nameEnum{
	Pavel, Glenn, Garath, Hal, Alex, Danny, Adam, Jem, Jamie, Simon, Anton, Yakubu, Nathaniel, Nick, Chris, Jure, Jason, Oliver, Hope, Aaron, Stephen, Pierce, Jonathan, Nathan 
}
