package nimGame;

/**
 * A simple class to test the class Pile.
 */
class PileTest {

    // Private components:

    private Pile pile;

    // Constructors:

    /**
     * Create a new PileTest.
     */
    public PileTest () {
        pile = null;
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testRemove(1,0);  // remove 1 stick from an empty pile
    }

    /**
     * Test the remove method.
     */
    private void testRemove (int sticksToTake, int sticksInPile) {
        pile = new Pile(sticksInPile);
        pile.remove(sticksToTake);
        verify(pile.sticks() == sticksInPile - sticksToTake,
            "take " + sticksToTake + " stick from pile with " +
            sticksInPile + " sticks");
    }

    /**
     * Verify the specified test condition.  Print message if the test fails.
     */
    private void verify (Boolean test, String message) {
        if (!test)
            System.out.println(
                "Verification failed: " + message);
    }
} // end of class PileTest

/**
 * A simple test system for the class PileTest.
 */
public class TestPileClass {

    /**
     * Run a PileTest.
     */
    public static void main (String[] args) {
        (new PileTest()).runTest();
    }
}
