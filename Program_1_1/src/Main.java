import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String message = JOptionPane.showInputDialog(null, "Enter your message:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
        if (message != null) {
            JOptionPane.showMessageDialog(null, message.toUpperCase(), "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "No message entered!", "Message Dialog", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }
}