import java.util.ArrayList;
import java.util.List;

//класс amount
class Amount {
    private double amount;
    private String transactionType;

    public Amount(double amount, String transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return transactionType + ": $" + amount;
    }
}

//класс PersonalAccount
public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Amount(amount, "Deposit"));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                transactions.add(new Amount(amount, "Withdrawal"));
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + " (Holder: " + accountHolder + "):");
        for (Amount transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        // Sample usage
        PersonalAccount account = new PersonalAccount(123456, "John Doe");
        account.deposit(1000.0);
        account.withdraw(500.0);
        account.deposit(200.0);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: $" + account.getBalance());

        account.printTransactionHistory();
    }
}