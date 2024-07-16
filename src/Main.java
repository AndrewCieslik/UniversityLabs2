import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String message = JOptionPane.showInputDialog(null, "Enter your message:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
        if (message != null) {
            JOptionPane.showMessageDialog(null, message.toUpperCase(), "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No message entered!", "Message Dialog", JOptionPane.WARNING_MESSAGE);
        }
    }
}