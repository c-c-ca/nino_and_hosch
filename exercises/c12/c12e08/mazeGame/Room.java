package mazeGame;

/**
 * Models a simple room with four exits in a Maze.
 */
public class Room {

    // Named constants:

    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;

    // Private Components:

    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    // Constructors:

    /**
     * Create a new Room.
     */
    public Room (String description) {
        this.description = description;
        this.northExit = null;
        this.southExit = null;
        this.eastExit = null;
        this.westExit = null;
    }

    // Queries:

    /**
     * The Room connected to the north exit.
     */
    public Room northExit () {
        return northExit;
    }

    /**
     * The Room connected to the south exit.
     */
    public Room southExit () {
        return southExit;
    }

    /**
     * The Room connected to the east exit.
     */
    public Room eastExit () {
        return eastExit;
    }

    /**
     * The Room connected to the west exit.
     */
    public Room westExit () {
        return westExit;
    }

    // Commands:

    /**
     * Add the specified Room as a Room to which one
     * of the four exits in this Room is connected.
     * which specifies one of the four exits.
     * @ensure     which == NORTH || which == SOUTH ||
     *             which == EAST || which == WEST
     */
    public void addExit (Room exit, int which) {
        if (which == NORTH)
            northExit = exit;
        else if (which == SOUTH)
            southExit = exit;
        else if (which == EAST)
            eastExit = exit;
        else
            westExit = exit;
    }

    /**
     * String representation of this Room.
     */
    public String toString () {
        return "Room: " + description;
    }
}
