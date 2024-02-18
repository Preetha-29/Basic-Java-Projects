
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingsAccount savingsAccount = new SavingsAccount(1000.0, 0.05);
        CurrentAccount currentAccount = new CurrentAccount(500.0);

        List<String> transactionSummary = new ArrayList<>();

        System.out.println("Select an account: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int accountChoice = scanner.nextInt();
        Account selectedAccount = (accountChoice == 1) ? savingsAccount : currentAccount;

        int choice;
        do {
            System.out.println("\nSelect an operation for the account: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    performOperation(selectedAccount, Operation.DEPOSIT, depositAmount);
                    transactionSummary.add("Deposited $" + depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    performOperation(selectedAccount, Operation.WITHDRAW, withdrawalAmount);
                    transactionSummary.add("Withdrawn $" + withdrawalAmount);
                    break;
                case 3:
                    performOperation(selectedAccount, Operation.BALANCE_ENQUIRY);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        System.out.println("\nTransaction Summary:");
        for (String transaction : transactionSummary) {
            System.out.println(transaction);
        }

        System.out.println("\nFinal Balances:");
        System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
        System.out.println("Current Account Balance: $" + currentAccount.getBalance());
    }

    static enum Operation {
        DEPOSIT, WITHDRAW, BALANCE_ENQUIRY
    }

   
    public static void performOperation(Account account, Operation operation, double amount) {
        switch (operation) {
            case DEPOSIT:
                account.deposit(amount);
                System.out.println("Deposit of $" + amount + " completed.");
                break;
            case WITHDRAW:
                account.withdraw(amount);
                System.out.println("Withdrawal of $" + amount + " completed.");
                break;
            case BALANCE_ENQUIRY:
                account.balanceEnquiry();
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

  
    public static void performOperation(Account account, Operation operation) {
        performOperation(account, operation, 0.0);
    }
}

abstract class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public abstract void handleTransaction(double amount);

    public double getBalance() {
        return balance;
    }
    public abstract void deposit(double amount);
    
    public abstract void withdraw(double amount);

    public abstract void balanceEnquiry();
}

final class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

        @Override
    public void handleTransaction(double amount) {
        // applying interest
        balance += balance * interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        handleTransaction(amount);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        handleTransaction(-amount);
    }

    @Override
    public void balanceEnquiry() {
        System.out.println("Savings Account Balance: $" + getBalance());
    }
}

final class CurrentAccount extends Account {
    public CurrentAccount(double initialBalance) {
        super(initialBalance);
    }
@Override
    public void handleTransaction(double amount) {
        // Implement specific transaction handling for Current Account if needed
    }

       @Override
    public void deposit(double amount) {
        balance += amount;
        handleTransaction(amount);
    }
    @Override
    public void withdraw(double amount) {
        balance -= amount;
        handleTransaction(-amount);
    }
    @Override
    public void balanceEnquiry() {
        System.out.println("Current Account Balance: $" + getBalance());
    }
}
