import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {
    private static int nextAccountNumber = 1;

    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double initialDeposit) {
        this.accountNumber = nextAccountNumber++;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Withdrawal amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        BankAccount newAccount = new BankAccount(accountName, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found with number: " + accountNumber);
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = bank.createAccount("Alice", 1000);
        BankAccount account2 = bank.createAccount("Bob", 500);

        System.out.println(account1.getAccountSummary());
        System.out.println(account2.getAccountSummary());

        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 200);

        System.out.println("After transfer:");
        System.out.println(account1.getAccountSummary());
        System.out.println(account2.getAccountSummary());
    }
}
