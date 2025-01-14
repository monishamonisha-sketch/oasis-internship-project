import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}

class ATM {
    private Account currentAccount;
    private boolean loggedIn = false;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the ATM!");
        login();
        if (loggedIn) {
            showMenu();
        }
    }

    private void login() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        currentAccount = AccountDatabase.getAccount(userId, pin);
        if (currentAccount != null) {
            loggedIn = true;
            System.out.println("Login successful!\n");
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    currentAccount.showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: " + currentAccount.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + currentAccount.getBalance());
    }

    private void transfer() {
        System.out.print("Enter the recipient's account ID: ");
        String recipientId = scanner.nextLine();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (currentAccount.transfer(recipientId, amount)) {
            System.out.println("Transfer successful. Current balance: " + currentAccount.getBalance());
        } else {
            System.out.println("Transfer failed. Check balance or recipient account.");
        }
    }
}

class Account {
    private String userId;
    private String pin;
    private double balance;
    private TransactionHistory transactionHistory;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new TransactionHistory();
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransaction("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.addTransaction("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(String recipientId, double amount) {
        if (balance >= amount && AccountDatabase.accountExists(recipientId)) {
            balance -= amount;
            transactionHistory.addTransaction("Transferred: " + amount + " to " + recipientId);
            return true;
        }
        return false;
    }

    public void showTransactionHistory() {
        transactionHistory.showHistory();
    }
}

class TransactionHistory {
    private StringBuilder history = new StringBuilder();

    public void addTransaction(String transaction) {
        history.append(transaction).append("\n");
    }

    public void showHistory() {
        if (history.length() > 0) {
            System.out.println("Transaction History:");
            System.out.println(history.toString());
        } else {
            System.out.println("No transactions yet.");
        }
    }
}

class AccountDatabase {

    private static Account[] accounts = new Account[]{
            new Account("user1", "1234", 1000),
            new Account("user2", "5678", 2000),
            new Account("user3", "0000", 1500)
    };

    public static Account getAccount(String userId, String pin) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId) && account.validatePin(pin)) {
                return account;
            }
        }
        return null;
    }

    public static boolean accountExists(String userId) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}
