/**
 * Learing to work with JFrame class and create a custom DialogBox
 */
package courseWork;

/**
 * @author cbpos1989
 *
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DialogBox{
	java.net.URL imgURL = DialogBox.class.getResource("images/rss.png");

	public static void main(String[] args){
	
		//System.out.println("Working");
		DialogBox myDialogBox = new DialogBox();
		
		//myDialogBox.JOptionPane();
		myDialogBox.JOptionInput();

	}

	
	void JOptionPane(){
		
		if (imgURL == null) {
			System.out.println("No Image Found");
		} else {
			ImageIcon icon = new ImageIcon(imgURL);

			JFrame frame = new JFrame("JOptionPane example");
			JOptionPane.showMessageDialog(frame, "Click OK to Subscribe", "RSS Feed", 
			JOptionPane.INFORMATION_MESSAGE, icon);
			//System.exit(0);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
	}

	void JOptionInput(){
		ImageIcon icon = new ImageIcon(imgURL);
		JFrame frame = new JFrame("UserInput");
		String userInput = (String)JOptionPane.showInputDialog(frame,"Enter Your Name", "Customized Dialog",JOptionPane.PLAIN_MESSAGE, icon, null, "J Doe");
		
	}
}
