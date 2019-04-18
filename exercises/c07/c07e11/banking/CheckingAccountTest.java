package banking;

import org.junit.*;
import static org.junit.Assert.*;

public class CheckingAccountTest {

    private CheckingAccount account;

    @Before
    public void setUp () {
        account = new CheckingAccount(123);
    }

    @Test
    public void testInitialState () {
        Money initialBalance;
        initialBalance = account.balance();
        assertEquals(0, initialBalance.dollars());
        assertEquals(0, initialBalance.cents());
    }

    /**
     * Test the deposit method.
     */
    @Test
    public void testDeposit () {
        // deposit 0 dollars and 0 cents
        Money amount, balance;
        amount = new Money(0,0);
        account.deposit(amount);
        balance = account.balance();
        assertEquals("deposit nothing", 0, balance.dollars());
        assertEquals("deposit nothing", 0, balance.cents());
        // deposit 1 dollar
        amount = new Money(1,0);
        account.deposit(amount);
        balance = account.balance();
        assertEquals("deposit dollars only", 1, balance.dollars());
        assertEquals("deposit dollars only", 0, balance.cents());
        // deposit 50 cents
        amount = new Money(0,50);
        account.deposit(amount);
        balance = account.balance();
        assertEquals("deposit cents only", 1, balance.dollars());
        assertEquals("deposit cents only", 50, balance.cents());
        // deposit 4 dollars and 60 cents
        amount = new Money(4,60);
        account.deposit(amount);
        balance = account.balance();
        assertEquals("typical deposit", 6, balance.dollars());
        assertEquals("typical deposit", 10, balance.cents());
    }

    /**
     * Test the withdraw method.
     */
    @Test
    public void testWithdraw () {
        // deposit money into account for testing
        Money amount, balance;
        amount = new Money(100,0);
        account.deposit(amount);
        balance = account.balance();
        assertEquals(100, balance.dollars());
        assertEquals(0, balance.cents());
        // withdraw 0 dollars and 0 cents
        amount = new Money(0,0);
        account.withdraw(amount);
        balance = account.balance();
        assertEquals("withdraw nothing", 100, balance.dollars());
        assertEquals("withdraw nothing", 0, balance.cents());
        // withdraw 1 dollar
        amount = new Money(1,0);
        account.withdraw(amount);
        balance = account.balance();
        assertEquals("withdraw dollars only", 99, balance.dollars());
        assertEquals("withdraw dollars only", 0, balance.cents());
        // withdraw 1 cent
        amount = new Money(0,1);
        account.withdraw(amount);
        balance = account.balance();
        assertEquals("withdraw cents only", 98, balance.dollars());
        assertEquals("withdraw cents only", 99, balance.cents());
        // typical withdrawal
        amount = new Money(21,63);
        account.withdraw(amount);
        balance = account.balance();
        assertEquals("typical withdraw", 77, balance.dollars());
        assertEquals("typical withdraw", 36, balance.cents());
        // withdraw balance
        amount = account.balance();
        account.withdraw(amount);
        balance = account.balance();
        assertEquals("typical withdraw", 0, balance.dollars());
        assertEquals("typical withdraw", 0, balance.cents());
    }
}
