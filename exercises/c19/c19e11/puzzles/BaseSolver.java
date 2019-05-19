package puzzles;

import nhUtilities.containers.*;

public class BaseSolver implements Solver {

    private boolean solved;

    public BaseSolver () {
        solved = false;
    }

    public boolean solved () {
        return solved;
    }

    public void first () {
        solved = true;
    }

    public void next () {
        solved = false;
    }

    public boolean canAttack (int r, int c) {
        return false;
    }

    public List<Queen> queens () {
        if (solved)
            return new DefaultList<Queen>();
        else
            return null;
    }
}
