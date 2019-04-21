package mazeGame;

/**
 * Models a maze in a maze-crawling game.
 */
public class Maze {

    // Private components:

    private Room dungeon;
    private Room monster;
    private Room entrance;
    private Room treasure;
    private Explorer explorer;

    // Constructors:

    /**
     * Create a new Maze with the specified Explorer.
     */
    public Maze (Explorer explorer) {
        this.explorer = explorer;
        this.entrance = new Room("Entrance");
        this.dungeon = new Room("Dungeon");
        this.monster = new Room("Monster Lair");
        this.treasure = new Room("Treasure Room");
        this.explorer.setLocation(this.entrance);
        initializeExits();
    }

    // Queries:

    /**
     * The explorer in this Maze has found the treasure room.
     */
    public boolean finishedExploring () {
        return explorer.location() == treasure;
    }

    // Commands:

    /**
     * Conduct a single step in the exploration, allowing
     * the Explorer to move to another room.  If the Explorer
     * has finished exploring (i.e. found the treasure room),
     * calling this method has no effect.
     */
    public void explore () {
        if (!finishedExploring())
            explorer.move();
    }

    private void initializeExits () {
        // entrance exits
        entrance.addExit(monster,Room.NORTH);
        entrance.addExit(dungeon,Room.SOUTH);
        entrance.addExit(entrance,Room.EAST);
        entrance.addExit(monster,Room.WEST);
        // dungeon exits
        dungeon.addExit(entrance,Room.NORTH);
        dungeon.addExit(monster,Room.SOUTH);
        dungeon.addExit(treasure,Room.EAST);
        dungeon.addExit(monster,Room.WEST);
        // monster exits
        monster.addExit(monster,Room.NORTH);
        monster.addExit(entrance,Room.SOUTH);
        monster.addExit(entrance,Room.EAST);
        monster.addExit(dungeon,Room.WEST);
        // treasure exits
        treasure.addExit(dungeon,Room.NORTH);
        treasure.addExit(entrance,Room.SOUTH);
        treasure.addExit(treasure,Room.EAST);
        treasure.addExit(entrance,Room.WEST);
    }
}
