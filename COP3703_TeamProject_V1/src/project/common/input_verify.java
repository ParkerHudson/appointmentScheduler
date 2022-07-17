package project.common;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class input_verify extends InputVerifier {
	
	public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
			Integer.parseInt(text);
			JOptionPane.showMessageDialog(null, "Numerical values in names are not allowed");
			return false;
		} catch (NumberFormatException e) {
			return true;
		}  
    }
}
