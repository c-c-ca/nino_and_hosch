package puzzles;

import java.util.*;

public class PuzzleSolver extends Observable {

    /**
     * Move a tower of the specified number of disks from
     * the specified starting peg to the specified destination
     * peg.
     * @require    n >= 1 &&
     *             1 <= from && from <= 3 &&
     *             1 <= to && to <= 3 &&
     *             from != to
     */
    public void moveTower (int n, int from, int to) {
        if (n == 1) {
            moveDisk(from, to);
        } else {
            int other = 6-from-to;  // not from or to
            moveTower(n-1, from, other);
            moveDisk(from, to);
            moveTower(n-1, other, to);
        }
    }

    /**
     * Move a single disk from the specified pegs to the
     * specified destination.
     * @require    1 <= from && from <= 3 &&
     *             1 <= to && to <= 3 &&
     *             from != to
     */
    public void moveDisk (int from, int to) {
        setChanged();
        notifyObservers(new Move(from, to));
    }
}
