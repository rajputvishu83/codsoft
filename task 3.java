import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " has been deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " has been withdrawn successfully.");
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);  // Initializing scanner
    }

    // Method to show the ATM menu and handle user interaction
    public void showMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();  // Get user choice

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.println("Current balance: ₹" + account.checkBalance());
                    break;
                case 2:
                    // Deposit money
                    System.out.print("Enter the amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    // Withdraw money
                    System.out.print("Enter the amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Closing the scanner at the end of the ATM session
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

// Main class to run the ATM application
public class ATMSystem {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance
        BankAccount account = new BankAccount(5000.0);  // Example balance ₹5000

        // Creating the ATM and passing the bank account
        ATM atm = new ATM(account);

        // Show the ATM menu
        try {
            atm.showMenu();
        } finally {
            // Ensure the scanner is closed when finished
            atm.closeScanner();
        }
    }
}