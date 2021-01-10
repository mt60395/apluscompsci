import javax.swing.*;
public class InputDialog{
	public static void main(String args[]){
		String input = "";
		while (input.equals("")) {
			input = JOptionPane.showInputDialog(null, "Enter the display message.");
			if (input.equals("")) {
				JOptionPane.showConfirmDialog(null, "No message", "Message Box Example", JOptionPane.OK_CANCEL_OPTION);
			}
		}

		if (JOptionPane.showConfirmDialog(null, input, "Message Box Example", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
			int a = JOptionPane.showConfirmDialog(null, "WATCH OUT!!", "Message Box Example", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (a == 0) {
				JOptionPane.showConfirmDialog(null, "You are right!", "Message Box Example", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
			else if (a == 1) { // cancel shows nothing
				JOptionPane.showConfirmDialog(null, "You are wrong!", "Message Box Example", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
