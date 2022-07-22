package project.common;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class input_verify extends InputVerifier {
	
	// checks if string contains integers FALSE = INTEGERS PRESENT
	public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
			Integer.parseInt(text);
			JOptionPane.showMessageDialog(null, "Numerical values in names are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}  
    }
	
	// checks if int contains char FALSE = STRING PRESENT
	public boolean verify_int(JComponent input) {
		String text = ((JTextField) input).getText();
        try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Useage of characters not allowed", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}  
	}
}
