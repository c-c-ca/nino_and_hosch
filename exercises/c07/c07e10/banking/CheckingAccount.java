package banking;
import counters.DollarsAndCentsCounter;

/**
 * Models a no-interest checking account.
 */
public class CheckingAccount {

    // Private components:

    private int accountNumber;
    private DollarsAndCentsCounter counter;

    // Constructors:

    /**
     * Create a new CheckingAccount.
     * @require    0 <= accountNumber &&
     *             accountNumber <= 999
     */
    public CheckingAccount (int accountNumber) {
        this.accountNumber = accountNumber;
        this.counter = new DollarsAndCentsCounter();
    }

    // Queries:

    /**
     * The balance for this CheckingAccount.
     */
    public Money balance () {
        int dollars, cents;
        dollars = counter.dollars();
        cents = counter.cents();
        Money balance;
        balance = new Money(dollars,cents);
        return balance;
    }

    // Commands:

    /**
     * Make a withdrawal from this CheckingAccount.
     * @require    amount <= this.balance()
     */
    public void withdraw (Money amount) {
        int dollars, cents;
        dollars = amount.dollars();
        cents = amount.cents();
        counter.subtract(dollars,cents);
    }

    /**
     * Make a deposit to this CheckingAccount.
     * @require    amount >= 0
     */
    public void deposit (Money amount) {
        int dollars, cents;
        dollars = amount.dollars();
        cents = amount.cents();
        counter.add(dollars,cents);
    }
}
