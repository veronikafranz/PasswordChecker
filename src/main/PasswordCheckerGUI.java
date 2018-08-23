package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import app.PasswordChecker;

import javax.swing.JButton;

import javax.swing.GroupLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author veron
 *
 */
public class PasswordCheckerGUI extends JFrame {
	
	//Buttons
	private JButton checkButton;
	
	//Fields for data entry
	private JPasswordField tempPasswordField;
	
	//Labels to identify the fields
	private JLabel passwordLabel;
    private JLabel resultLabel;
    private JLabel resultText;
    
	
	/**
	 * creates a new form of PasswordCheckerGUI
	 */
	public PasswordCheckerGUI() {
		//initializing and setting up components
		initComponents();
	}
	
	private void initComponents() {
		
		 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	     setTitle("PasswordChecker");
     
		//create fields for data entry
		tempPasswordField = new JPasswordField(15);
		
		//create and setup labels
        passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        passwordLabel.setLabelFor(tempPasswordField);
        
        resultLabel = new JLabel();
        resultLabel.setText("");
        resultLabel.setLabelFor(resultText);
        resultText = new JLabel();
        resultText.setText("Please insert your password.");
        
        //create and setup buttons
        checkButton = new JButton();
        checkButton.setText("Check");
               
        //action listener for check-button
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        
        //create group layout object and associate it with panel
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        //automatic gap insertion
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        //set horizontal layout
        layout.setHorizontalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	    		.addComponent(passwordLabel)
        	    		.addComponent(resultLabel))
        	    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	    		.addComponent(tempPasswordField)
        	    		.addComponent(resultText))
        	    .addComponent(checkButton)
        	);
        
        //set vertical layout
        layout.setVerticalGroup(layout.createSequentialGroup()
        	    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	    		.addComponent(passwordLabel)
        	    		.addComponent(tempPasswordField)
        	    		.addComponent(checkButton))
        	    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	    		.addComponent(resultLabel)
        	    		.addComponent(resultText))
        	);
       
        pack();
    }

	private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//Parse password field
		String text = tempPasswordField.getText();
		//checking password
		PasswordChecker pwc = new PasswordChecker();
		//Displaying result
		resultLabel.setText("Result: ");
		if(pwc.checkPassword(text)) {
			//password valid
			resultText.setForeground(Color.green);
			resultText.setText("Your password is valid.");
		} else {
			//password not valid
		    resultText.setForeground(Color.RED);
		    resultText.setText("Your password is not valid.");
		}
	}
		    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordCheckerGUI().setVisible(true);
            }
        });
    }
}

