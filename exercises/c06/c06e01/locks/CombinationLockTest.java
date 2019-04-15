package locks;

import org.junit.*;
import static org.junit.Assert.*;

public class CombinationLockTest {

    // Locks with the specified combinations
    private CombinationLock lock00;   // comb. 00
    private CombinationLock lock01;   // comb. 01
    private CombinationLock lock12;   // comb. 12
    private CombinationLock lock99;   // comb. 99

    @Before
    public void setUp () {
        lock00 = new CombinationLock(0);
        lock01 = new CombinationLock(1);
        lock12 = new CombinationLock(12);
        lock99 = new CombinationLock(99);
    }

    private void closeLocks () {
        lock00.close();
        lock01.close();
        lock12.close();
        lock99.close();
    }

    @Test
    public void testInitialState () {
        assertTrue(lock12.isOpen());
    }

    /**
     * Test that entering an incorrect combination does not
     * close an open lock.
     */
    @Test
    public void testOpenLock () {
        lock12.enter(3); lock12.enter(4);
        assertTrue(lock12.isOpen());
    }

    private void correctCombination (
        CombinationLock lock, int first, int second) {
        assertFalse(lock.isOpen());
        lock.enter(first); lock.enter(second);
        assertTrue(lock.isOpen());
    }

    /**
     * Test that entering the correct combination opens a lock.
     */
    @Test
    public void testCorrectCombination () {
        closeLocks();
        correctCombination(lock00,0,0);
        correctCombination(lock01,0,1);
        correctCombination(lock12,1,2);
        correctCombination(lock99,9,9);
    }

    private void incorrectCombination (
        CombinationLock lock, int first, int second) {
        lock.enter(first); lock.enter(second);
        assertFalse(lock.isOpen());
    }

    /**
     * Test that entering an incorrect combination doesn't
     * open a lock.
     */
    @Test
    public void testIncorrectCombination () {
        closeLocks();
        incorrectCombination(lock00,1,0);
        incorrectCombination(lock01,1,1);
        incorrectCombination(lock12,2,1);
        incorrectCombination(lock99,0,9);
    }

    private void firstDigitTwice (
        CombinationLock lock, int first, int second) {
        lock.enter(first); lock.enter(first);
        assertFalse(lock.isOpen());
        lock.enter(second);
        assertTrue(lock.isOpen());
    }

    /**
     * Test that entering the first combination digit twice
     * leaves the lock almost open (unless two combination
     * digits are the same).
     */
    @Test
    public void testFirstDigitTwice () {
        closeLocks();
        firstDigitTwice(lock01,0,1);
        firstDigitTwice(lock12,1,2);
    }

    private void incorrectSecondDigit (
        CombinationLock lock, int first, int badSecond,
        int second) {
        lock.enter(first); lock.enter(badSecond);
        lock.enter(second);
        assertFalse(lock.isOpen());
    }

    /**
     * Test that entering the first combination digit followed
     * by an incorrect digit different from the first leaves
     * the lock reset.
     */
    @Test
    public void testIncorrectSecondDigit () {
        closeLocks();
        incorrectSecondDigit(lock01,0,2,1);
        incorrectSecondDigit(lock12,1,0,2);
    }

    @Test
    public void testClosedOpenedLock () {
        lock12.enter(1);
        lock12.close();
        assertFalse(lock12.isOpen());
        // Verify the lock is reset:
        lock12.enter(2);
        assertFalse(lock12.isOpen());
    }

    @Test
    public void testCloseResetLock () {
        lock12.close();
        lock12.close();
        assertFalse(lock12.isOpen());
    }

    private void closeAlmostOpenLock (
        CombinationLock lock, int first, int second) {
        lock.enter(first);
        lock.close();
        lock.enter(second);
        assertFalse(lock.isOpen());
    }

    @Test
    public void testCloseAlmostOpenLock () {
        closeLocks();
        closeAlmostOpenLock(lock00,0,0);
        closeAlmostOpenLock(lock01,0,1);
        closeAlmostOpenLock(lock12,1,2);
        closeAlmostOpenLock(lock99,9,9);
    }
}
