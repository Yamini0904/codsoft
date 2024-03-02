import javax.swing.*;
import java.awt.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

class ATMGUI extends JFrame {
    private BankAccount userAccount;

    private JTextField amountField;
    private JTextArea resultArea;

    public ATMGUI(BankAccount userAccount) {
        this.userAccount = userAccount;

        setTitle("ATM");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
    }

    private void createUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField();

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(exitButton);
        panel.add(new JLabel(""));
        panel.add(resultArea);

        add(panel);

        withdrawButton.addActionListener(e -> handleWithdrawal());

        depositButton.addActionListener(e -> handleDeposit());

        checkBalanceButton.addActionListener(e -> checkBalance());

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void handleWithdrawal() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            userAccount.withdraw(amount);
            resultArea.setText("Withdrawal successful. New balance: $" + userAccount.getBalance());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a valid amount.");
        }
    }

    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            userAccount.deposit(amount);
            resultArea.setText("Deposit successful. New balance: $" + userAccount.getBalance());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a valid amount.");
        }
    }

    private void checkBalance() {
        resultArea.setText("Current balance: $" + userAccount.getBalance());
    }
}

public class ATMApp {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATMGUI atmGUI = new ATMGUI(userAccount);
        atmGUI.setVisible(true);
    }
}
