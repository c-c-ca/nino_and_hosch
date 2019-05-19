package mazeGame;

/**
 * Models a simple room connected to two other rooms.
 * Connections are one-way and a room may be connected
 * to itself.
 */
public class Room {

    // Private Components:

    private String description;
    private Room r1;
    private Room r2;

    // Constructors:

    /**
     * Create a new Room.
     */
    public Room (String description) {
        this.description = description;
        this.r1 = null;
        this.r2 = null;
    }

    // Queries:

    /**
     * This Room is connected to the specified Room.
     */
    public boolean connectedTo (Room r) {
        return (r.equals(r1) || r.equals(r2));
    }

    // Commands:

    /**
     * Connect this Room to the specified rooms.
     */
    public void connect (Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    /**
     * String representation of this Room.
     */
    public String toString () {
        return "Room: " + description;
    }
}
