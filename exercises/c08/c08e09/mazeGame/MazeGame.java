package mazeGame;

/**
 * A maze-crawling game.  User observes game
 * by means of a simple text based interface.
 */
public class MazeGame {
    public static void main (String[] argv) {
        (new MazeTUI()).start();
    }
}
