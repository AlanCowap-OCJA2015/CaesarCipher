/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * App to demonstrate FileWriter & FileReader
 * 
 * @author Colm O'Sullivan
 *
 */
import java.io.*;

public class FileApp {
	private File myFile;
	char[] in = new char[50];
	
	public static void main(String[] args){
		FileApp fa = new FileApp();
		fa.createFile();
		
	}
	
	void createFile(){
		try{
			File myDir = new File("/Users/Student/Desktop/Test_Dir");
			myDir.mkdir();
			
			myFile = new File(myDir, "myFile.txt");
			myFile.createNewFile();
			
			if (myFile.exists()) {
				System.out.println("File Created");
			}
			
			//System.out.println(myFile.createNewFile());
			//System.out.println(myFile.exists());
		} catch (IOException ioe) {
			System.out.println("No File Created");
		}
		
		saveFile();
		loadFile();
	}
	
	void saveFile(){
		try{
			FileWriter fw = new FileWriter(myFile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Hello World");
			bw.flush();
			bw.close();
		} catch (IOException ioe){
			System.out.println("Didn't write to file");
		}
	}
	
	void loadFile(){
		try{
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String reader;
			
			while ((reader = br.readLine())!= null) {
				System.out.println(reader);
			}
			br.close();
		} catch (IOException ioe) {
			System.out.println("Didn't read file");
		}
	}
}
