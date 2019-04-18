package banking;

import java.util.*;

/**
 * A simple text-based interface for a CheckingAccount.
 */
public class CheckingAccountTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int BALANCE = 1;
    private static final int WITHDRAW = 2;
    private static final int DEPOSIT = 3;
    private static final int NEW = 4;
    private static final int EXIT = 0;

    // Private components:

    private CheckingAccount account;    // the model
    private Scanner in;                 // standard input

    /**
     * Create a CheckingAccountTUI instance.
     */
    public CheckingAccountTUI () {
        this.account = null;
        this.in = new Scanner(System.in);
    }

    /**
     * Run the interface.
     */
    public void start () {
        createAccount();
        int choice = NO_CHOICE;
        while (choice != EXIT) {
            displayMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }
    }

    /**
     * Create a new CheckingAccount with user-provided
     * account number.
     */
    private void createAccount () {
        int accountNumber = readAccountNumber(
            "Enter account number (0-999): ");
        this.account = new CheckingAccount(accountNumber);
    }

    private void displayMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "View balance................." + BALANCE);
        System.out.println(
            "Make a withdrawal............" + WITHDRAW);
        System.out.println(
            "Make a deposit..............." + DEPOSIT);
        System.out.println(
            "Create new account..........." + NEW);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void executeChoice (int choice) {
        System.out.println();
        if (choice == BALANCE || choice == WITHDRAW ||
            choice == DEPOSIT) {
            if (choice != BALANCE)
                executeTransaction(choice);
            System.out.println(
                "Balance: " + account.balance());
        } else if (choice == NEW)
            createAccount();
        else if (choice == EXIT)
            System.out.println("Goodbye.");
        else
            System.out.println(choice + " is not valid.");
    }

    private void executeTransaction (int choice) {
        Money amount;
        amount = readAmount();
        System.out.println();
        if (choice == WITHDRAW)
            if (validateWithdrawal(amount))
                account.withdraw(amount);
            else
                System.out.println("Sorry, you may not withdraw " +
                    amount + " from this account.");
        else
            account.deposit(amount);
    }

    private boolean validateWithdrawal (Money amount) {
        Money balance;
        boolean validWithdrawal;
        balance = account.balance();
        validWithdrawal = (amount.dollars() < balance.dollars() ||
                          (amount.dollars() <= balance.dollars() &&
                           amount.cents() <= balance.cents()));
        return validWithdrawal;
    }

    /**
     * Read and return a legal account number.
     * @ensure     0 <= this.readAccountNumber() &&
     *             this.readAccountNumber() <= 999
     */
    private int readAccountNumber (String prompt) {
        int accountNumber = -1;
        boolean haveGoodAccountNumber = false;
        while (!haveGoodAccountNumber) {
            System.out.print(prompt); System.out.flush();
            if (in.hasNextInt()) {
                accountNumber = in.nextInt();
                haveGoodAccountNumber = (0 <= accountNumber && accountNumber <= 999);
            }
            in.nextLine();
        }
        return accountNumber;
    }

    private Money readAmount () {
        int dollars, cents;
        dollars = cents = -1;
        System.out.println("Enter amount:");
        while (dollars < 0)
            dollars = readIntWithPrompt("Dollars (a non-negative integer): ");
        while (cents < 0 || cents >= 100)
            cents = readIntWithPrompt("Cents (a non-negative integer less than 100): ");
        Money amount;
        amount = new Money(dollars,cents);
        return amount;
    }

    private int readIntWithPrompt (String prompt) {
        System.out.print(prompt); System.out.flush();
        while (!in.hasNextInt()) {
            in.nextLine();
            System.out.print(prompt); System.out.flush();
        }
        int input = in.nextInt();
        in.nextLine();
        return input;
    }
}
