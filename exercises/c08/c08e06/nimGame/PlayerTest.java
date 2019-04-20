package nimGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the class Player.
 */
public class PlayerTest {

    // Test fixture:

    private Player player;
    private Pile pile5;         // Pile with 5 sticks
    private Pile pile3;         // Pile with 3 sticks
    private Pile pile2;         // Pile with 2 sticks
    private Pile pile1;         // Pile with 1 stick

    @Before
    public void setUp () {
        player = new Player("Player");
        pile5 = new Pile(5);
        pile3 = new Pile(3);
        pile2 = new Pile(2);
        pile1 = new Pile(1);
    }

    @Test
    public void testInitialState () {
        assertEquals("Player", player.name());
        assertEquals(0, player.numberTaken());
    }

    /**
     * Test the takeTurn method with maxOnATurn 1.
     */
    @Test
    public void testTakeTurnMax1 () {
        player.takeTurn(pile5,1);
        assertEquals(4, pile5.sticks());
        assertEquals(1, player.numberTaken());
        player.takeTurn(pile1,1);
        assertEquals(0, pile1.sticks());
        assertEquals(1, player.numberTaken());
    }

    /**
     * Test the takeTurn method with maxOnATurn 3.
     */
    @Test
    public void testTakeTurnMax3 () {
        player.takeTurn(pile5,3);
        assertTrue(1 <= player.numberTaken() &&
            player.numberTaken() <= 3);
        assertEquals(pile5.sticks(),
            5 - player.numberTaken());

        player.takeTurn(pile3,3);
        assertTrue(1 <= player.numberTaken() &&
            player.numberTaken() <= 3);
        assertEquals(pile3.sticks(),
            3 - player.numberTaken());

        player.takeTurn(pile2,3);
        assertTrue(1 <= player.numberTaken() &&
            player.numberTaken() <= 2);
        assertEquals(pile2.sticks(),
            2 - player.numberTaken());

        player.takeTurn(pile1,3);
        assertEquals(1, player.numberTaken());
        assertEquals(0, pile1.sticks());
    }

    /**
     * Test the numberToTake method.
     */
    @Test
    public void testNumberToTake () {
        player.setNumberToTake(1);
        player.takeTurn(pile5,3);
        assertEquals(1,player.numberTaken());
        assertEquals(4,pile5.sticks());

        player.setNumberToTake(2);
        player.takeTurn(pile3,3);
        assertEquals(2,player.numberTaken());
        assertEquals(1,pile3.sticks());

        player.setNumberToTake(1);
        player.takeTurn(pile1,3);
        assertEquals(1,player.numberTaken());
        assertEquals(0,pile1.sticks());
    }

}
