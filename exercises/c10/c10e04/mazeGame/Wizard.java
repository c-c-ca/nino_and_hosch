package mazeGame;

/**
 * Models a Wizard in a Maze.
 */
public class Wizard extends Explorer {

    // Commands:

    /**
     * Move to the specified Room if it is connected
     * to this Explorer's current location or if it
     * is an EnchantedRoom.
     */
    public void moveTo (Room newLocation) {
        Room location = location();
        if (location.connectedTo(newLocation) ||
            newLocation instanceof EnchantedRoom)
            setLocation(newLocation);
    }
}
