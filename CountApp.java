/**
 * App to demonstrate the use of for loop for mathematical calculations.
 */
package courseWork;

/**
 * @author cbpos1989
 *
 */
public class CountApp{
	double count = 0;
	double mean = 0;
	
	
	public static void main(String[] args){
		//System.out.println("Working");
		CountApp myCountApp = new CountApp();
		myCountApp.counter();
		int countInt = (int)myCountApp.count;
		System.out.println(countInt);
		System.out.println(myCountApp.mean);
		
		
	}

	//Loop that adds 1-100 in an iterative sequence
	//also get the mean of the sum total 
	void counter(){
		for(double i = 1 ;i < 101; i++){
			count = count + i;
			
			if(i == 100){
				mean = count/i;
			
			}
		}
	}
}