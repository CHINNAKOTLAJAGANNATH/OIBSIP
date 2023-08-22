import java.util.Scanner;
public class BankAccount 
{
    private String userId;
    private String userPin;
    private double balance;
    private StringBuilder transactionHistory;

    public BankAccount(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactionHistory = new StringBuilder();
    }

    public boolean authenticate(String userId, String userPin) 
    {
        return this.userId.equals(userId) && this.userPin.equals(userPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.append("Deposit: +").append(amount).append("\n");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.append("Withdraw: -").append(amount).append("\n");
            return true;
        }
        return false;
    }

    public void transfer(BankAccount recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            transactionHistory.append("Transfer: -").append(amount).append(" to ").append(recipient.userId).append("\n");
        }
    }

    public String getTransactionHistory() {
        return transactionHistory.toString();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("user123", "1234");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Interface");
        System.out.print("Enter your User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your User PIN: ");
        String userPin = scanner.nextLine();

        if (account.authenticate(userId, userPin)) {
            System.out.println("Authentication successful.");
            displayMainMenu(account, scanner);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static void displayMainMenu(BankAccount account, Scanner scanner) {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nMain Menu");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\nTransaction History:");
                    System.out.println(account.getTransactionHistory());
                    break;
                case 2:
                    System.out.print("\nEnter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    System.out.print("\nEnter the recipient's User ID: ");
                    String recipientId = scanner.nextLine();
                    BankAccount recipientAccount = new BankAccount(recipientId, ""); // No need for PIN here
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    account.transfer(recipientAccount, transferAmount);
                    System.out.println("Transfer successful.");
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM Interface. Goodbye!");
    }
}
