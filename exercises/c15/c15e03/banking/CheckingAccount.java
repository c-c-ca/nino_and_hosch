package banking;

/**
 * Models a no-interest checking account.
 */
public class CheckingAccount {

    // Private components:

    private int accountNumber;
    private int balance;
    private BankLog log;

    // Constructors:

    /**
     * Create a new CheckingAccount.
     * @require    0 <= accountNumber &&
     *             accountNumber <= 999
     */
    public CheckingAccount (int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.log = null;
    }

    // Queries:

    /**
     * The balance for this CheckingAccount.
     */
    public int balance () {
        return balance;
    }

    // Commands:

    /**
     * Make a withdrawal from this CheckingAccount.
     * @require    amount <= this.balance()
     */
    public void withdraw (int amount)
        throws UnsuccessfulWithdrawalException {
        boolean success = false;
        int tryNumber = 0;
        while (!success) {
            try {
                tryNumber = tryNumber + 1;
                this.balance = this.balance - amount;
                notifyObservers();
                log.logWithdrawal(this.accountNumber, amount);
                success = true;
            } catch (LogFailureException e) {
                System.out.println("tryNumber: " + tryNumber);
                this.balance = this.balance + amount;
                notifyObservers();
                if (tryNumber == 1)
                    log.backupAndPurge();
                else
                    throw new UnsuccessfulWithdrawalException();
            }
        }
    }

    /**
     * Make a deposit to this CheckingAccount.
     * @require    amount >= 0
     */
    public void deposit (int amount) {
        this.balance = this.balance + amount;
    }

    public void setLog (BankLog log) {
        this.log = log;
    }

    public void notifyObservers () {}
}
