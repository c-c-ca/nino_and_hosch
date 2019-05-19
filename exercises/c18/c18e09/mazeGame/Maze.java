package mazeGame;

import nhUtilities.containers.*;

/**
 * Models a maze in a maze-crawling game.
 */
public class Maze {

    // Named constants:

    public static final int NUM_ROOMS = 5;
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    private static final int NONE = -1;

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
        for (int i = 0; i < NUM_ROOMS; i = i+1)
            this.rooms.add(new Room(""));
        this.explorer.setLocation(this.rooms.get(A));
        initializeAllExits();
    }

    // Queries:

    /**
     * The explorer in this Maze has found the treasure room.
     */
    public boolean finishedExploring () {
        return explorer.location() == rooms.get(E);
    }

    public Room getRoom (int room) {
        return rooms.get(room);
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
        connect(room, north, Room.NORTH);
        connect(room, south, Room.SOUTH);
        connect(room, east, Room.EAST);
        connect(room, west, Room.WEST);
    }

    private void connect (Room fromRoom, int toRoom,
                          int direction) {
        Room room;
        if (0 <= toRoom && toRoom < NUM_ROOMS)
            room = rooms.get(toRoom);
        else
            room = fromRoom;
        fromRoom.addExit(room,direction);
    }

    private void initializeAllExits () {
        // intitialize ROOM A
        initializeExits(A,NONE,NONE,B,NONE);
        // intitialize ROOM B
        initializeExits(B,NONE,C,NONE,A);
        // intitialize ROOM C
        initializeExits(C,B,D,E,NONE);
        // intitialize ROOM D
        initializeExits(D,C,NONE,NONE,NONE);
        // intitialize ROOM E
        initializeExits(E,NONE,NONE,NONE,C);
    }
}
