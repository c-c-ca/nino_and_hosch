package mazeGame;

/**
 * Views a Room in a maze game.
 */
public interface RoomViewer {

    /**
     * An Explorer has entered or exited the Room.
     */
    public void update (Room room);
}
