package com.github.cbpos1989.codingChallenge;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;


public class CeasarCipherApp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean left = false;
	int magnitude = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CeasarCipherApp frame = new CeasarCipherApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CeasarCipherApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(35, 24, 143, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 24, 143, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_2.getText() != null){
					String strMagnitude = textField_2.getText();
					try{
						magnitude = Integer.parseInt(strMagnitude);
					}catch(NumberFormatException nfe){
						new DialogBox().JOptionPane();
					}
				}
				if(textField.getText() != null){
					String str = textField.getText();
					int lengthCheck = str.length();
					
					str = str.replaceAll("[^\u0020-\u007E]","");
					
					if(str.length() < lengthCheck ){
						new DialogBox().JOptionPane();
					} else{
						textField.setText(str);
						String temp = new CeasarCipher().encryptText(str, left, magnitude, 1);
						
						textField_1.setText(temp);
					}
				}
				
				/*if(textField.getText() != null){
					checkTextField(textField, textField_1);
				} else if (textField_1.getText() != null){
					checkTextField(textField_1, textField);
				}*/
			
				
				
			}
		});
		btnEncrypt.setBounds(150, 64, 89, 23);
		contentPane.add(btnEncrypt);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnClear.setBounds(288, 158, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText() != null){
					String strMagnitude = textField_2.getText();
					try{
						magnitude = Integer.parseInt(strMagnitude);
					}catch(NumberFormatException nfe){
						new DialogBox().JOptionInvalidNumber();
					}
				}
				if(textField.getText() != null){
					String str = textField.getText();
					int lengthCheck = str.length();
					
					str = str.replaceAll("[^\u0020-\u007E]","");
					
					if(str.length() < lengthCheck ){
						new DialogBox().JOptionPane();
					} else{
						textField.setText(str);
						String temp = new CeasarCipher().encryptText(str, left, magnitude, -1);
						
						textField_1.setText(temp);
					}
				}
			}
		});
		btnDecrypt.setBounds(150, 98, 89, 23);
		contentPane.add(btnDecrypt);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				String str2 = textField_1.getText();
				textField.setText(str2);
				textField_1.setText(str);
			}
		});
		btnTransfer.setBounds(150, 132, 89, 23);
		contentPane.add(btnTransfer);
		
		textField_2 = new JTextField();
		textField_2.setBounds(35, 128, 50, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxShiftLeft = new JCheckBox("Shift left");
		chckbxShiftLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				left = true;
			}
		});
		chckbxShiftLeft.setBounds(35, 158, 97, 23);
		contentPane.add(chckbxShiftLeft);
		
		JLabel lblEnterValue = new JLabel("Enter value");
		lblEnterValue.setBounds(35, 102, 65, 14);
		contentPane.add(lblEnterValue);
	}
	
	void checkTextField(JTextField txt1, JTextField txt2){
		
			new DialogBox().JOptionNotWorking();
			String str = txt1.getText();
			System.out.println(str);
			int lengthCheck = str.length();
			
			str = str.replaceAll("[^\u0020-\u007E]","");
			
			if(str.length() < lengthCheck ){
				new DialogBox().JOptionPane();
			} else{
				txt2.setText(str);
				System.out.println(str);
				String temp = new CeasarCipher().encryptText(str, left, magnitude, 1);
				
				txt1.setText(temp);
			}
		}
	

}

	class CeasarCipher {
		String userOutput;
	
		String encryptText(String userInput, boolean left, int magnitude, int decrypt){
			
			char[] letters = userInput.toCharArray();
			
			for(int i = 0; i < letters.length; ++i){
				
				if(!left){
					if(letters[i] == '\u007E'){
						letters[i] = (char)((letters[i] - 94 * decrypt) + magnitude );
					} else {
						letters[i] = (char)(letters[i] + magnitude * decrypt);
					}
				} else{
					if(letters[i] == '\u0020'){
						letters[i] = (char)((letters[i] + 94 * decrypt) - magnitude);
					} else {
						letters[i] = (char)(letters[i] - magnitude * decrypt);
					}
				}
				
			}
			
			userOutput = new String(letters);
			
			return  userOutput;
		}
		
	}

class DialogBox{
	

	void JOptionPane(){
		
			JFrame frame = new JFrame("JOptionPane example");
			JOptionPane.showMessageDialog(frame, "Invlaid Input only enter alpha characters", "Invalid Input", 
			JOptionPane.INFORMATION_MESSAGE);
			//System.exit(0);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	void JOptionNotWorking(){
		
		JFrame frame = new JFrame("JOptionPane example");
		JOptionPane.showMessageDialog(frame, "Feature not yet complete", "Work in Progress", 
		JOptionPane.INFORMATION_MESSAGE);
		//System.exit(0);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	void JOptionInvalidNumber(){
		
		JFrame frame = new JFrame("JOptionPane example");
		JOptionPane.showMessageDialog(frame, "Magnitude Number Needed", "Error", 
		JOptionPane.INFORMATION_MESSAGE);
		//System.exit(0);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}

