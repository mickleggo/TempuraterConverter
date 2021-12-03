package TempConverter;
import java.awt.*;
import javax.swing.*;

public class ErrorMessage {

	JFrame eFrame;
	JLabel message;
	
	public void ErrorMessage() {
		
		eFrame = new JFrame("Error");
		eFrame.setBounds(775, 225, 225, 100);
		eFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		eFrame.setResizable(false);
		eFrame.getContentPane().setLayout(null);
		eFrame.setAlwaysOnTop(true);
		
		message = new JLabel();
		message.setBounds(25, 15, 175, 50);
		message.setVerticalAlignment(JLabel.TOP);
		eFrame.getContentPane().add(message);
		
		eFrame.setVisible(true);
		
	}
	
}





	
	
