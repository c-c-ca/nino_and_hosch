package nimGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the class Player.
 */
public class PlayerTest {

    // Private components:

    private Player player;  // the object to test
    private Pile typical;   // a Pile of 5 sticks
    private Pile pile4;     // a Pile of 4 sticks
    private Pile pile3;     // a Pile of 3 sticks
    private Pile pile2;     // a Pile of 2 sticks
    private Pile min;       // a Pile of 1 sticks

    @Before
    public void setUp () {
        player = new Player("");
        typical = new Pile(5);
        pile4 = new Pile(4);
        pile3 = new Pile(3);
        pile2 = new Pile(2);
        min = new Pile(1);
    }

    /**
     * Test the initial state of the Player.
     */
    @Test
    public void testInitialState () {
        assertEquals("initial state", "", player.name());
        assertEquals("initial state", 0, player.numberTaken());
    }

    /**
     * Test the takeTurn method.
     */
    @Test
    public void testTakeTurn () {
        // test that a player removes 1 stick from a typical pile
        player.takeTurn(typical);
        assertEquals(
            "take turn with pile of 5 sticks", 1, player.numberTaken());
        // test that a player removes 3 sticks from a pile of 4 sticks
        player.takeTurn(pile4);
        assertEquals(
            "take turn with pile of 4 sticks", 3, player.numberTaken());
        // test that a player removes 2 sticks from a pile of 3 sticks
        player.takeTurn(pile3);
        assertEquals(
            "take turn with pile of 3 sticks", 2, player.numberTaken());
        // test that a player removes 1 stick from a pile of 2 sticks
        player.takeTurn(pile2);
        assertEquals(
            "take turn with pile of 2 sticks", 1, player.numberTaken());
        // test that a player removes 1 stick from the smallest pile size
        player.takeTurn(min);
        assertEquals(
            "take turn with pile of 1 stick", 1, player.numberTaken());
    }

}
