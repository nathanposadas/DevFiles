import javax.swing.JOptionPane;
import java.util.HashMap;

public class ATMSystem {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();

        while (true) {
            String[] options = {"Log In", "Enroll", "Return"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Please Choose an Option:",
                "ATM System",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == 0) {
                String username = JOptionPane.showInputDialog("Enter Account No.:");
                String password = JOptionPane.showInputDialog("Enter PIN:");

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed.");
                }
            } else if (choice == 1) {
                String newUsername = JOptionPane.showInputDialog("Enter a new Account:");
                if (users.containsKey(newUsername)) {
                    JOptionPane.showMessageDialog(null, "Account already exists.");
                } else {
                    String newPassword = JOptionPane.showInputDialog("Enter a new PIN:");
                    users.put(newUsername, newPassword);
                    JOptionPane.showMessageDialog(null, "Enrollment successful. You can now log in.");
                }
            } else if (choice == 2) {
                break;
            }
        }
    }
}