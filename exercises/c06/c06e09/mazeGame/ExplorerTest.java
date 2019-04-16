package mazeGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the class Explorer.
 */
public class ExplorerTest {

    // explorers with the specified annoyabilities and tolerances
    private Explorer typical;         // annoyability: 10; tolerance: 100
    private Explorer noAnnoyability;  // annoyability:  0; tolerance: 100
    private Explorer noTolerance;     // annoyability: 10; tolerance:   0

    private Room start;
    private Room finish;

    private Denizen denizen;

    @Before
    public void setUp () {
        start = new Room();
        finish = new Room();
        typical = new Explorer("",start,10,100);
        noAnnoyability = new Explorer("",start,0,100);
        noTolerance = new Explorer("",start,10,0);
        denizen = new Denizen(100);
    }

    @Test
    public void testInitialState () {
        assertEquals(
            "name", "", typical.name());
        assertEquals(
            "initial location", start, typical.location());
        assertEquals(
            "initial annoyability", 10, typical.annoyability());
        assertEquals(
            "initial tolerance", 100, typical.tolerance());
    }

    /**
     * Test the move method.
     */
    @Test
    public void testMove () {
        typical.move(finish);
        assertEquals("move", finish, typical.location());
    }

    private void takeNothing (Explorer explorer) {
        // call takeThat with 0 hit points
        int initialTolerance = explorer.tolerance();
        explorer.takeThat(0);
        assertEquals(initialTolerance, explorer.tolerance());
    }

    private void takeTypical (Explorer explorer) {
        // call takeThat with a typical number of hit points
        int initialTolerance = explorer.tolerance();
        explorer.takeThat(10);
        assertEquals(
            Math.max(initialTolerance - 10, 0), explorer.tolerance());
    }

    private void takeEverything (Explorer explorer) {
        // call takeThat with all of an explorer's hit points
        explorer.takeThat(explorer.tolerance());
        assertEquals(0, explorer.tolerance());

    }

    private void takeEvenMore (Explorer explorer) {
        // call takeThat with more hit points than the explorer
        assertEquals(0, explorer.tolerance());
        explorer.takeThat(10);
        assertEquals(0, explorer.tolerance());
    }

    /**
     * Test the takethat method.
     */
    @Test
    public void testTakeThat () {
        takeNothing(typical);
        takeNothing(noTolerance);
        takeTypical(typical);
        takeTypical(noTolerance);
        takeEverything(typical);
        takeEverything(noTolerance);
        takeEvenMore(typical);
        takeEvenMore(noTolerance);
    }

    /**
     * Test the poke method.
     */
    @Test
    public void testPoke () {
        // explorer removes no hit points from denizen
        int initialTolerance = denizen.tolerance();
        noAnnoyability.poke(denizen);
        assertEquals(initialTolerance, denizen.tolerance());
        // explorer removes typical number of hit points from denizen
        typical.poke(denizen);
        assertEquals(initialTolerance - 10, denizen.tolerance());
    }
}
