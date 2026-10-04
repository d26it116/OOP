import java.util.Scanner;
import model.Account;
import model.CurrentAccount;
import model.FixedDeposite;
import model.SavingsAccount;
import util.AnnotationValidator;
import util.Command;
import util.CommandParser;
import util.StatementFormat;
import util.Validator;
import util.WithdrawRule;
public class MiniBank {

    record BankInfo(String name, String branch) {
    }

    // Menu options
    enum MenuOption {
        OPEN_ACCOUNT,
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        EXIT
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "CHARUSAT Branch");

        System.out.println("================================");
        System.out.println("          " + bank.name());
        System.out.println("          " + bank.branch());
        System.out.println("================================");

        // Create different types of accounts
        Account[] accounts = new Account[3];

        accounts[0] = new SavingsAccount("Aaryan", 5000, 1000);
        accounts[1] = new CurrentAccount("Rahul", 2000, 3000);
        accounts[2] = new FixedDeposite("Jay", 10000);

        // Perform deposits and withdrawals
        accounts[0].deposit(500);
        accounts[0].withdraw(200);

        accounts[1].deposit(1000);
        accounts[1].withdraw(3000);

        accounts[2].deposit(1500);

        // Display account details
        System.out.println("\n----- Account Details -----");

        for (Account account : accounts) {
            System.out.println(account);
        }

        // Equals
        System.out.println("\n----- Using equals() -----");

        System.out.println("Account 1 equals Account 2: "
                + accounts[0].equals(accounts[1]));

        // instanceof
        System.out.println("\n----- Using instanceof -----");

        Object obj = accounts[0];

        if (obj instanceof Account) {
            System.out.println("Object is an Account");
        }

        // Task 6 - Runtime Polymorphism
        System.out.println("\n----- Interest Rates -----");

        for (Account account : accounts) {

            System.out.println(
                    account.getOwnerName()
                    + " : "
                    + account.interestRate()
                    + "%"
            );
        }

        // Pattern matching instanceof
        System.out.println("\n----- Savings Account Check -----");

        for (Account account : accounts) {

            if (account instanceof SavingsAccount savings) {

                System.out.println(
                        savings.getOwnerName()
                        + " is a Savings Account"
                );
            }
        }

        // Validator Testing
        System.out.println("\n----- Validator Testing -----");

        // Mobile
        System.out.println("Valid Mobile: "
                + Validator.isValidMobile("9876543210"));

        System.out.println("Invalid Mobile: "
                + Validator.isValidMobile("12345"));

        // Email
        System.out.println("Valid Email: "
                + Validator.isValidEmail("aaryan@gmail.com"));

        System.out.println("Invalid Email: "
                + Validator.isValidEmail("aaryan@gmail"));

        // PAN
        System.out.println("Valid PAN: "
                + Validator.isValidPan("ABCDE1234F"));

        System.out.println("Invalid PAN: "
                + Validator.isValidPan("ABC1234F"));

        // IFSC
        System.out.println("Valid IFSC: "
                + Validator.isValidIfsc("SBIN0001234"));

        System.out.println("Invalid IFSC: "
                + Validator.isValidIfsc("SBI1234"));

        // Command Parser Testing
        System.out.println("\n----- Command Parser -----");

        Command command =
                CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("Type: " + command.type());

        System.out.println("Account Number: "
                + command.accountNumber());

        System.out.println("Amount: " + command.amount());

        // Statement Formatter Testing
        System.out.println("\n----- Account Statement -----");

        System.out.println(
                StatementFormat.buildStatement(accounts[0])
        );

                // Task 3 - WithdrawRule

        System.out.println("\n----- Withdraw Rule -----");

        // Using anonymous class
        WithdrawRule rule1 = new WithdrawRule() {

            @Override
            public boolean allow(Account account, long amount) {
                return account.canWithdraw(amount);
            }
        };

        System.out.println(
                "Anonymous class: "
                + rule1.allow(accounts[0], 1000)
        );

        // Using lambda expression
        WithdrawRule rule2 =
                (account, amount) -> account.canWithdraw(amount);

        System.out.println(
                "Lambda expression: "
                + rule2.allow(accounts[0], 1000)
        );

        System.out.println("\n----- Annotation Validation -----");

        Account testAccount =
                new SavingsAccount("Aaryan", -5000, 1000);

        String[] errors =
                AnnotationValidator.validate(testAccount);

        for (String error : errors) {
            System.out.println(error);
        }
        // MiniBank Menu
        int choice;

        do {

            System.out.println("\n----- MiniBank Menu -----");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            String result = switch (choice) {

                case 1 ->
                        "Open Account - to be implemented in a later lab";

                case 2 ->
                        "Deposit - to be implemented in a later lab";

                case 3 ->
                        "Withdraw - to be implemented in a later lab";

                case 4 ->
                        "Transfer - to be implemented in a later lab";

                case 5 ->
                        "Exiting MiniBank...";

                default ->
                        "Invalid choice. Please try again.";
            };

            System.out.println(result);

        } while (choice != 5);

        System.out.println("Thank you for using MiniBank!");

        sc.close();
    }
}