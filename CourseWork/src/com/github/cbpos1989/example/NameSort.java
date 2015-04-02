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
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class NameSort {
	private ArrayList<String> nameList = new ArrayList<String>();
	private ArrayList<String> pickedList = new ArrayList<String>();
	private Random rnd = new Random();
	private String userDir = null;
	private final String RND_FILE_NAME = "namerandom.txt";
	private final String SRT_FILE_NAME = "namesorted.txt";
	private Scanner scn;
	
	public static void main(String[] args){
		//System.out.println("Working");
		
		NameSort ns = new NameSort();
		
		ns.intializeApp();
		
		
		
	}
	
	void intializeApp(){
		populateArrayList();
		
		scn = new Scanner(System.in);
		System.out.print("Enter Directory Path: ");
		userDir = scn.nextLine();
		
		if(!pickedList.isEmpty()){
			createFile(RND_FILE_NAME, userDir);
			sortArrayList(pickedList);
			createFile(SRT_FILE_NAME, userDir);
		}
	}
	
	int randomNumber(){
		return rnd.nextInt(nameList.size()-1);
	}
	
	//Populates two ArrayLists one with all enum values the other with 15 random
	void populateArrayList(){
		
		for(nameEnum ne: nameEnum.values()){
			String str = ne.toString();
			nameList.add(str);
		}
		
		for(int i = 0; i < 15;){
			int idx = randomNumber();
			
			if (nameList.get(idx) != null) {
				pickedList.add(i, nameList.get(idx));
				nameList.remove(idx);
				++i;
			} else {
				continue;
			}
			
		}
		
		
		/*System.out.println("PickedArray");
		
		for(String s: pickedList){
			System.out.println(s);
		}*/
		
	}
	
	void sortArrayList(ArrayList<String> list){
		Collections.sort(list);
	}
	
	
	void createFile(String filename, String userDir){
		try{
			//File myDir = new File("/Users/cbpos1989/Desktop/Test_Dir");
			File myDir = new File(userDir);
			myDir.mkdir();
			
			File tempFile = new File(myDir, filename);
			tempFile.createNewFile();
			
			if (tempFile.exists()) {
				System.out.println("---File " + filename + " Created---");
				writeFile(tempFile, pickedList);
				readFile(tempFile);
			}	
		} catch (IOException ioe) {
			System.out.println("No File Created");
		}
	}
	
	void writeFile(File fileName, ArrayList<String> list){
		try{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(String s: list){
				bw.write(s + "\n");
			}
			
			bw.flush();
			bw.close();
			
			
		} catch (IOException ioe) {
			System.out.println("Didn't Write File");
		}
	}
	
	void readFile(File fileName){
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String reader;
			//System.out.println("Reader");
			
			while ((reader = br.readLine())!= null) {
				System.out.println(reader);
			}
			br.close();
			
		} catch (IOException ioe) {
			System.out.println("Didn't read file");
		}
	}
}

enum nameEnum{
	Pavel, Glenn, Garath, Hal, Alex, Danny, Adam, Jem, Jamie, Simon, Anton, Yakubu, Nathaniel, Nick, Chris, Jure, Jason, Oliver, Hope, Aaron, Stephen, Pierce, Jonathan, Nathan 
}
