package puzzles;

/**
 * A move in the tower puzzle. Pegs are numbered 1, 2, 3.
 */
public class Move {

    private int from;
    private int to;

    /**
     * Create a move of a disk from the peg from to the
     * peg to.
     */
    public Move (int from, int to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Peg the disk is moved from
     */
    public int from () {
        return from;
    }

    /**
     * Peg the disk is moved to.
     */
    public int to () {
        return to;
    }
}
