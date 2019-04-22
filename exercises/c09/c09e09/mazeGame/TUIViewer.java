package mazeGame;

/**
 * A simple text-based interface used to
 * view a Room in a maze game.
 */
public class TUIViewer implements RoomViewer {

    /**
     * An Explorer has entered or exited the Room.
     */
    public void update (Room room) {
        System.out.println(
            "Discovered: " + room.isDiscovered());
        System.out.println(
            "Occupied: " + room.isOccupied());
    }
}
