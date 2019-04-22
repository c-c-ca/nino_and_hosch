package mazeGame;

/**
 * Demonstration basic usage of a TUIViewer.
 */
public class TUIViewerExample {
    public static void main (String[] argv) {
        Room room = new Room();
        RoomViewer viewer = new TUIViewer();
        room.register(viewer);
        room.enter();
        room.exit();
    }
}
