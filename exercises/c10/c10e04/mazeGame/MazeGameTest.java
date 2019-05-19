package mazeGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A test class for the classes in the maze game.
 */
public class MazeGameTest {

    // Test fixture:

    private Explorer explorer;  // explorers
    private Explorer wizard;

    private Room dungeon;       // rooms in the maze
    private Room monster;
    private Room entrance;
    private Room treasure;

    private void configureMaze () {
        entrance.connect(this.dungeon,this.monster);
        dungeon.connect(this.entrance,this.dungeon);
        monster.connect(this.treasure,this.dungeon);
        treasure.connect(this.entrance,this.monster);
    }

    @Before
    public void setUp () {
        explorer = new Explorer();
        wizard = new Wizard();
        entrance = new EnchantedRoom("Entrance");
        dungeon = new Room("Dungeon");
        monster = new Room("Monster Lair");
        treasure = new EnchantedRoom("Treasure Room");
        explorer.setLocation(entrance);
        wizard.setLocation(entrance);
        configureMaze();
    }

    @Test
    public void testInitialState () {
        assertEquals(entrance, explorer.location());
        assertEquals(entrance, wizard.location());
    }

    private void typicalWalkthrough (Explorer e) {
        // move to a Room that is conneced
        e.moveTo(dungeon);
        assertEquals(dungeon, e.location());
        // move to a Room that is not connected or enchanted
        e.moveTo(monster);
        assertEquals(dungeon, e.location());
        // move through a series of connected rooms
        e.moveTo(entrance);
        assertEquals(entrance, e.location());
        e.moveTo(monster);
        assertEquals(monster, e.location());
        e.moveTo(treasure);
        assertEquals(treasure, e.location());
        // move to a Room that is not connected or enchanted
        e.moveTo(dungeon);
        assertEquals(treasure, e.location());
        // move back to initial location
        e.moveTo(entrance);
        assertEquals(entrance, e.location());
    }

    @Test
    public void testExplorer () {
        typicalWalkthrough(explorer);
        // move to a room that is not connected but is enchanted
        explorer.moveTo(treasure);
        assertEquals(entrance, explorer.location());
    }

    @Test
    public void testWizard () {
        typicalWalkthrough(wizard);
        // move to a room that is not connected but is enchanted
        wizard.moveTo(treasure);
        assertEquals(treasure, wizard.location());
    }
}
