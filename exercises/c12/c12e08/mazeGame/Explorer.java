package mazeGame;

/**
 * Models an Explorer in a Maze.
 */
public class Explorer {

    // Named constants:

    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;

    // Private components:

    private Room location;
    private int direction;

    // Constructors:

    /**
     * Create a new Explorer.
     */
    public Explorer () {
        this.location = null;
        this.direction = 0;
    }

    // Queries:

    /**
     * This Explorer's current location.
     */
    public Room location () {
        return location;
    }

    // Commands:

    /**
     * Move to another room.
     */
    public void move () {
        Room exit;
        if (direction == NORTH)
            exit = location.northExit();
        else if (direction == SOUTH)
            exit = location.southExit();
        else if (direction == EAST)
            exit = location.eastExit();
        else
            exit = location.westExit();
        location = exit;
    }

    /**
     * Set the location for this Explorer to the
     * specified Room
     * @ensure    this.location() == location
     */
    public void setLocation (Room location) {
        this.location = location;
    }

    /**
     * Set the direction for this Explorer.
     * @require    direction == NORTH || direction == SOUTH ||
     *             direction == EAST || direction == WEST
     */
    public void setDirection (int direction) {
        this.direction = direction;
    }
}
