package mazeGame;

import nhUtilities.containers.*;

/**
 * Models a maze in a maze-crawling game.
 */
public class Maze {

    // Named constants:

    private static final int ENTRANCE = 0;
    private static final int DUNGEON = 1;
    private static final int MONSTER_LAIR = 2;
    private static final int TREASURE_ROOM = 3;

    // Private components:

    private List<Room> rooms;
    private Explorer explorer;

    // Constructors:

    /**
     * Create a new Maze with the specified Explorer.
     */
    public Maze (Explorer explorer) {
        this.explorer = explorer;
        this.rooms = new DefaultList<Room>();
        this.rooms.add(new Room("Entrance"));
        this.rooms.add(new Room("Dungeon"));
        this.rooms.add(new Room("Monster Lair"));
        this.rooms.add(new Room("Treasure Room"));
        this.explorer.setLocation(this.rooms.get(ENTRANCE));
        initializeAllExits();
    }

    // Queries:

    /**
     * The explorer in this Maze has found the treasure room.
     */
    public boolean finishedExploring () {
        return explorer.location() == rooms.get(TREASURE_ROOM);
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

    private void initializeExits (int n, int north,
                    int south, int east, int west) {
        Room room = rooms.get(n);
        room.addExit(rooms.get(north),Room.NORTH);
        room.addExit(rooms.get(south),Room.SOUTH);
        room.addExit(rooms.get(east),Room.EAST);
        room.addExit(rooms.get(west),Room.WEST);
    }

    private void initializeAllExits () {
        // intitialize entrance exits
        initializeExits(ENTRANCE,MONSTER_LAIR,
                        DUNGEON,ENTRANCE,MONSTER_LAIR);
        // intitialize dungeon exits
        initializeExits(DUNGEON,ENTRANCE,DUNGEON,
                        TREASURE_ROOM,MONSTER_LAIR);
        // intitialize monster exits
        initializeExits(MONSTER_LAIR,MONSTER_LAIR,ENTRANCE,
                        ENTRANCE,DUNGEON);
        // intitialize treasure exits
        initializeExits(TREASURE_ROOM,DUNGEON,ENTRANCE,
                        TREASURE_ROOM,ENTRANCE);
    }
}
