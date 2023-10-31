import javax.swing.JOptionPane;
import java.util.Random;
public class ATMSystem {
    public static void main(String[] args) {
        // Dito nakalagay o nakasave yung mga bagong user acc
        String[] usernames = new String[10];
        String[] passwords = new String[10];
        double[] pin = new double[10];
        double[] acc = new double[10];
        double[] balances = new double[10];
        int userCount = 0;
        
        //Yung condition ng log-in at enroll,mag enroll ka muna bago mag log in wala pang acc ito
        while (true) {
            String choice = JOptionPane.showInputDialog("ATM System, Welcome!"+
                    "\nPlease Select dwe andy Option:\n1. Log In\n2. Enroll\n3. Return");

            int option = Integer.parseInt(choice);

            switch (option) {
                case 1:
                    // sa log-in idol
                    String username = JOptionPane.showInputDialog("Enter username:");
                    String password = JOptionPane.showInputDialog("Enter password:");
                    int userIndex = -1;
                    

                    // i checheck dito kung may naka enroll nang acc
                    for (int i = 0; i < userCount; i++) {
                        if (usernames[i].equals(username) && passwords[i].equals(password)) {
                            userIndex = i;
                            break;
                        }
                    }

                    if (userIndex != -1) {
                        // dito pag naka log in ka na, lalabas na din dito yung account no. at PIN random generated kada 
                        //account
                        while (true) {
                            
                            Random random = new Random();
                            int accNum = random.nextInt(10000)+ 1000;
                            int pinNum = random.nextInt(9000)+ 1000;
                            String accountOption = JOptionPane.showInputDialog(
                                    "Your PIN is: " +pinNum + "\nYour Account Number is: "+ accNum 
                                    + "\nSelect an account option:  "
                                    +"\n1. Balance Inquiry\n2. Withdraw\n3. Deposit\n4. Log Out");
                            
                            int accountChoice = Integer.parseInt(accountOption);
                            
                        
                        pin[userCount] = pinNum;

                            switch (accountChoice) {
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Balance: $" + balances[userIndex]);
                                    break;
                                case 2:
                                    double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount:"));
                                    if (withdrawAmount <= balances[userIndex]) {
                                        balances[userIndex] -= withdrawAmount;
                                        JOptionPane.showMessageDialog(null, "Withdrawn: $" + withdrawAmount);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Insufficient funds");
                                    }
                                    break;
                                case 3:
                                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
                                    balances[userIndex] += depositAmount;
                                    JOptionPane.showMessageDialog(null, "Deposited: $" + depositAmount);
                                    break;
                                case 4:
                                    JOptionPane.showMessageDialog(null, "Logged out.");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invalid account option.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password.");
                    }
                    break;
                case 2:
                    // Enroll
                    if (userCount < usernames.length) {
                        String newUsername = JOptionPane.showInputDialog("Enter a new username:");
                        String newPassword = JOptionPane.showInputDialog("Enter a new password:");
                        
                        
                        usernames[userCount] = newUsername;
                        passwords[userCount] = newPassword;
                        balances[userCount] = 0.0;
                        userCount++;

                        JOptionPane.showMessageDialog(null, "Enrollment successful.You can now log in.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Maximum user limit reached. Cannot enroll more users.");
                    }
                    break;
                case 3:
                    // Return
                    JOptionPane.showMessageDialog(null, "Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }
}