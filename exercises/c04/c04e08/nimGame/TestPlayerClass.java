package nimGame;

/**
 * A simple class to test the class Player.
 */
class PlayerTest {

    // Private components:

    private Player player;  // the object to test
    private Pile pile;

    // Constructors:

    /**
     * Create a new PlayerTest.
     */
    public PlayerTest () {
        player = new Player("John Doe");
        pile = null;
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testTakeTurn(5, 4, 1);  // test a pile with 5 sticks
        testTakeTurn(4, 1, 3);  // test a pile with 4 sticks
        testTakeTurn(3, 1, 2);  // test a pile with 3 sticks
        testTakeTurn(2, 1, 1);  // test a pile with 2 sticks
        testTakeTurn(1, 0, 1);  // test a pile with 1 stick
    }

    /**
     * Test the takeTurn method.  sticksBefore is the number of sticks
     * in the Pile before the player takes a turn, sticksAfter is the
     * number of sticks remaining in the Pile after the Player takes
     * a turn, and sticksTaken is the number of sticks that the Player
     * took on the most recent turn.
     */
    private void testTakeTurn (int sticksBefore, int sticksAfter, int sticksTaken) {
        pile = new Pile(sticksBefore);
        player.takeTurn(pile);
        verify(player.numberTaken() == sticksTaken, "number taken, " + sticksBefore + " sticks before turn");
        verify(pile.sticks() == sticksAfter, "sticks left, " + sticksBefore + " sticks before turn");
    }

    /**
     * Verify the specified test condition.  Print message if the test fails.
     */
    private void verify (Boolean test, String message) {
        if (!test)
            System.out.println(
                "Verification failed: " + message);
    }
} // end of class PlayerTest

/**
 * A simple test system for the class PlayerTest.
 */
public class TestPlayerClass {

    /**
     * Run a PlayerTest.
     */
    public static void main (String[] args) {
        (new PlayerTest()).runTest();
    }
}
