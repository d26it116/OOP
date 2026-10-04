package model;
import model.annotation.Id;
import model.annotation.Positive;
import model.annotation.MaxLength;
public abstract class Account implements Transactable, InterestBearing {

    @Id
    private final String accountNumber;

    @MaxLength(50)
    private String ownerName;

    @Positive
    private long balance;

    private boolean active;

    private static long AccountCounter = 0;

      private static String generateAccountNumber() {
        AccountCounter++;
        return String.format("AC%04d", AccountCounter);
    }

    public Account(String ownerName, long initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.active = true;
    }

    public Account(String ownerName) {
     
        this(ownerName, 0);
    }
    
    public void deposit(long amount) {
            balance += amount;
    }

    public boolean withdraw(long amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

      public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
public String toString() {
    return "Account Number: " + accountNumber + ", Owner Name: " + ownerName + ", Balance: " + balance + ", Active: " + active;
}

   @Override
public boolean equals(Object o) {

    if (!(o instanceof Account)) {
        return false;
    }

    Account other = (Account) o;

    return this.accountNumber.equals(other.accountNumber);
}

@Override
public int hashCode() {
    return accountNumber.hashCode();
}

public abstract double interestRate();

public abstract boolean canWithdraw(long amount);

}
