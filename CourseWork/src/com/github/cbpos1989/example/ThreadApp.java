/**
 * 
 */
package com.github.cbpos1989.example;

/**
 * @author User1
 *
 */
public class ThreadApp {
	
	public void threadMessage(String message){
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: n%n", threadName, message);
	}
	
	public static void main(String[] args) throws InterruptedException {
			String[] importantInfo = {
				"Mares eat oats",
				"Does eat oats",
		        "Little lambs eat ivy",
		        "A kid will eat ivy too"
			};
			
			for(int i = 0; i < importantInfo.length; ++i){
				try{
					Thread.sleep(2000);
				} catch (InterruptedException ie){
					if(Thread.interrupted()){
						throw new InterruptedException();
					}
					return;
				}
				
				System.out.println(importantInfo[i]);
			}
	}
}
