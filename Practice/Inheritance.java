class CurrentAccount{
    int AccountNumber;
    String AccountHolderName;
    double Balance;

    CurrentAccount(int AccountNumber, String AccountHolderName, double Balance){
        this.AccountNumber = AccountNumber;
        this.AccountHolderName = AccountHolderName;
        this.Balance = Balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + AccountNumber);
        System.out.println("Account Holder Name: " + AccountHolderName);
        System.out.println("Balance: " + Balance);
    }
}

class SavingAccount extends CurrentAccount {
    SavingAccount(int AccountNumber, String AccountHolderName, double Balance) {
        super(AccountNumber, AccountHolderName, Balance);
    }
    void calculateInterest() {
        double interestRate = 0.04; 
        double interest = Balance * interestRate;
        System.out.println("Interest added: " + interest);
    }

}

class Inheritance {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(123456, "John Doe", 1000.0);
        savingAccount.displayAccountDetails();
        savingAccount.calculateInterest();
    }
}

