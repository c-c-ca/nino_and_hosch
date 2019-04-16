package locks;

import org.junit.*;
import static org.junit.Assert.*;

public class CombinationLockTest {

    // Locks with the specified combinations
    private CombinationLock lock000;   // comb. 000
    private CombinationLock lock001;   // comb. 001
    private CombinationLock lock012;   // comb. 012
    private CombinationLock lock112;   // comb. 112
    private CombinationLock lock121;   // comb. 121
    private CombinationLock lock122;   // comb. 122
    private CombinationLock lock123;   // comb. 123
    private CombinationLock lock999;   // comb. 999

    @Before
    public void setUp () {
        lock000 = new CombinationLock(0);
        lock001 = new CombinationLock(1);
        lock012 = new CombinationLock(12);
        lock112 = new CombinationLock(112);
        lock121 = new CombinationLock(121);
        lock122 = new CombinationLock(122);
        lock123 = new CombinationLock(123);
        lock999 = new CombinationLock(999);
    }

    private void closeLocks () {
        lock000.close();
        lock001.close();
        lock012.close();
        lock112.close();
        lock121.close();
        lock122.close();
        lock123.close();
        lock999.close();
    }

    @Test
    public void testInitialState () {
        assertTrue(lock123.isOpen());
    }

    /**
     * Test that entering an incorrect combination does not
     * close an open lock.
     */
    @Test
    public void testOpenLock () {
        lock123.enter(4); lock123.enter(5); lock123.enter(6);
        assertTrue(lock123.isOpen());
    }

    private void correctCombination (
        CombinationLock lock, int first, int second, int third) {
        assertFalse(lock.isOpen());
        lock.enter(first); lock.enter(second); lock.enter(third);
        assertTrue(lock.isOpen());
    }

    /**
     * Test that entering the correct combination opens a lock.
     */
    @Test
    public void testCorrectCombination () {
        closeLocks();
        correctCombination(lock000,0,0,0);
        correctCombination(lock001,0,0,1);
        correctCombination(lock012,0,1,2);
        correctCombination(lock112,1,1,2);
        correctCombination(lock121,1,2,1);
        correctCombination(lock122,1,2,2);
        correctCombination(lock123,1,2,3);
        correctCombination(lock999,9,9,9);
    }

    private void incorrectCombination (
        CombinationLock lock, int first, int second, int third) {
        lock.enter(first); lock.enter(second); lock.enter(third);
        assertFalse(lock.isOpen());
    }

    /**
     * Test that entering an incorrect combination doesn't
     * open a lock.
     */
    @Test
    public void testIncorrectCombination () {
        closeLocks();
        incorrectCombination(lock000,1,0,0);
        incorrectCombination(lock001,1,1,1);
        incorrectCombination(lock012,2,1,0);
        incorrectCombination(lock112,2,1,1);
        incorrectCombination(lock121,2,1,2);
        incorrectCombination(lock122,1,2,1);
        incorrectCombination(lock123,3,2,1);
        incorrectCombination(lock999,0,9,9);
    }

    private void firstDigitTwice (
        CombinationLock lock, int first, int second, int third) {
        lock.enter(first); lock.enter(first);
        assertFalse(lock.isOpen());
        lock.enter(second); lock.enter(third);
        assertTrue(lock.isOpen());
    }

    /**
     * Test that entering the first combination digit twice
     * leaves the lock almost open (unless the first two
     * combination digits are the same).
     */
    @Test
    public void testFirstDigitTwice () {
        closeLocks();
        firstDigitTwice(lock012,0,1,2);
        firstDigitTwice(lock112,1,1,2);
        firstDigitTwice(lock122,1,2,2);
        firstDigitTwice(lock123,1,2,3);
    }

    private void firstAfterSecond (
        CombinationLock lock, int first, int second, int third) {
        lock.enter(first); lock.enter(second); lock.enter(first);
        assertFalse(lock.isOpen());
        lock.enter(second); lock.enter(third);
        assertTrue(lock.isOpen());
    }

    /**
     * Test that entering the first combination digit after
     * the second digit leaves the lock almost open (unless
     * the first two combination digits are the same or all
     * digits in the combination are the same).
     */
    @Test
    public void testFirstAfterSecond () {
        closeLocks();
        firstAfterSecond(lock012,0,1,2);
        firstAfterSecond(lock122,1,2,2);
        firstAfterSecond(lock123,1,2,3);
    }

    private void firstDigitThrice (
        CombinationLock lock, int first, int third) {
        lock.enter(first); lock.enter(first); lock.enter(first);
        assertFalse(lock.isOpen());
        lock.enter(third);
        assertTrue(lock.isOpen());
    }

    /**
     * Test that when the first two digits in a combination
     * are the same, entering the first combination three
     * times leaves the lock almost open (unless the third
     * combination digit is also the same).
     */
    @Test
    public void testFirstDigitThrice () {
        closeLocks();
        firstDigitThrice(lock001,0,1);
        firstDigitThrice(lock112,1,2);
    }

    private void incorrectSecondDigit (
        CombinationLock lock, int first, int badSecond,
        int second, int third) {
        lock.enter(first); lock.enter(badSecond);
        lock.enter(second); lock.enter(third);
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
        incorrectSecondDigit(lock001,0,1,0,1);
        incorrectSecondDigit(lock012,0,2,1,2);
        incorrectSecondDigit(lock112,1,2,1,2);
        incorrectSecondDigit(lock122,1,3,2,2);
        incorrectSecondDigit(lock123,1,0,2,3);
    }

    /**
     * Test that entering an incorrect third digit for a lock
     * resets the first lock (i.e. the user must enter the
     * correct first digit, not the second).
     */
    private void incorrectThirdDigitResetFirst (
        CombinationLock lock, int first, int second,
        int badThird, int third) {
            lock.enter(first); lock.enter(second);
            lock.enter(badThird);
            assertFalse(lock.isOpen());
            lock.enter(second); lock.enter(third);
            assertFalse(lock.isOpen());
    }

    private void incorrectThirdDigitResetSecond (
        CombinationLock lock, int first, int second,
        int badThird, int third) {
        lock.enter(first); lock.enter(second);
        lock.enter(badThird); lock.enter(third);
        assertFalse(lock.isOpen());
    }

    /**
     * Test that entering the first two combination digits followed
     * by an incorrect third digit leaves the lock reset.
     */
    @Test
    public void testIncorrectThirdDigit () {
        // entering an incorrect third digit resets first comb
        closeLocks();
        incorrectThirdDigitResetFirst(lock001,0,0,2,1);
        incorrectThirdDigitResetFirst(lock012,0,1,1,2);
        incorrectThirdDigitResetFirst(lock112,1,1,3,2);
        incorrectThirdDigitResetFirst(lock122,1,2,3,2);
        incorrectThirdDigitResetFirst(lock123,1,2,2,3);
        // entering an incorrect third digit resets second comb
        closeLocks();
        incorrectThirdDigitResetSecond(lock001,0,0,2,1);
        incorrectThirdDigitResetSecond(lock112,1,1,3,2);
        incorrectThirdDigitResetSecond(lock122,1,2,3,2);
        // incorrect 3rd, but correct 2nd
        incorrectThirdDigitResetSecond(lock012,0,1,1,2);
        incorrectThirdDigitResetSecond(lock123,1,2,2,3);
    }

    @Test
    public void testClosedOpenedLock () {
        lock123.enter(1);
        lock123.close();
        assertFalse(lock123.isOpen());
        // Verify the lock is reset:
        lock123.enter(2);
        lock123.enter(3);
        assertFalse(lock123.isOpen());
    }

    @Test
    public void testCloseResetLock () {
        lock123.close();
        lock123.close();
        assertFalse(lock123.isOpen());
    }

    private void closeAlmostOpenLock (
        CombinationLock lock, int first, int second, int third) {
        lock.enter(first);
        lock.enter(second);
        lock.close();
        lock.enter(third);
        assertFalse(lock.isOpen());
    }

    @Test
    public void testCloseAlmostOpenLock () {
        closeLocks();
        closeAlmostOpenLock(lock000,0,0,0);
        closeAlmostOpenLock(lock001,0,0,1);
        closeAlmostOpenLock(lock012,0,1,2);
        closeAlmostOpenLock(lock112,1,1,2);
        closeAlmostOpenLock(lock122,1,2,2);
        closeAlmostOpenLock(lock123,1,2,3);
        closeAlmostOpenLock(lock999,9,9,9);
    }
}
