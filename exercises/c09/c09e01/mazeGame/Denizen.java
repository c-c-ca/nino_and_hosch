package mazeGame;

/**
 * Models a denizen in a Maze game.
 */
interface Denizen {

    // Commands:

    /**
     * Receive a poke of the specified number of
     * hit points.
     * @require    annoyance >= 0
     */
    public void takeThat (int annoyance);

}
