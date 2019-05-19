package banking;

public class Example {

    private static final int ACCOUNT_NUMBER = 123;
    private static final int INITIAL_AMOUNT = 100;
    private static final int WITHDRAWAL_AMOUNT = 10;
    private static CheckingAccount account;

    private static void initializeAccount () {
        account = new CheckingAccount(ACCOUNT_NUMBER);
        account.setLog(new BankLog());
        account.deposit(INITIAL_AMOUNT);
    }

    private static void makeWithdrawal () {
        try {
            account.withdraw(WITHDRAWAL_AMOUNT);
        } catch (UnsuccessfulWithdrawalException e) {
            System.out.println(e);
        }
    }

    private static void displayBalance (String when) {
        System.out.println(
            "Balance " + when + " withdrawal: " +
            account.balance());
    }

    public static void main (String[] argv) {
        initializeAccount();
        displayBalance("before");
        makeWithdrawal();
        displayBalance("after");
    }
}
