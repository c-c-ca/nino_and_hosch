package mazeGame;

/**
 * Models a simple room with four exits in a Maze.
 */
public class Room {

    // Named constants:

    // Private Components:

    private boolean isDiscovered;  // an Explorer is currently in
                                   // or has been to this Room
    private boolean isOccupied;    // an Explorer is in the Room
    private RoomViewer viewer;     // views the Room

    // Constructors:

    /**
     * Create a new Room.
     */
    public Room () {
        this.isDiscovered = false;
        this.isOccupied = false;
    }

    // Queries:

    /**
     * This Room has been discovered.
     */
    public boolean isDiscovered () {
        return isDiscovered;
    }

    /**
     * An Explorer is in this Room.
     */
    public boolean isOccupied () {
        return isOccupied;
    }

    // Commands:

    /**
     * Enter this Room.
     */
    public void enter () {
        if (!isDiscovered)
            isDiscovered = true;
        isOccupied = true;
        viewer.update(this);
    }

    /**
     * Exit this Room.
     */
    public void exit () {
        isOccupied = false;
        viewer.update(this);
    }

    /**
     * Set the RoomViewer this Room is to report to.
     * This Room will notify controller (by invoking its
     * update method) when an Explorer enters or exits
     * the Room.
     */
    public void register (RoomViewer viewer) {
        this.viewer = viewer;
    }

}
