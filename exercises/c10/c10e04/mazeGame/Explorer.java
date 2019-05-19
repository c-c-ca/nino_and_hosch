package mazeGame;

/**
 * Models an Explorer in a Maze.
 */
public class Explorer {

    // Private components:

    private Room location;

    // Constructors:

    /**
     * Create a new Explorer.
     */
    public Explorer () {
        this.location = null;
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
     * Set this Explorer's location to the specified
     * Room.
     */
    public void setLocation (Room r) {
        this.location = r;
    }

    /**
     * Move to the specified Room if it is connected
     * to this Explorer's current location.  Otherwise,
     * this Explorer remains in the current location.
     */
    public void moveTo (Room newLocation) {
        if (location.connectedTo(newLocation))
            location = newLocation;
    }
}
