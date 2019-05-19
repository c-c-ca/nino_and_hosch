package puzzles;

import nhUtilities.containers.*;

public class QueensProblem {

    private Solver bottomRow;

    public QueensProblem (int size) {
        Solver s = new BaseSolver();
        for (int i = 1; i <= size; i = i+1)
            s = new GeneralSolver(s,size);
        bottomRow = s;
    }

    public void first () {
        bottomRow.first();
    }

    public void next () {
        bottomRow.next();
    }

    public boolean solved () {
        return bottomRow.solved();
    }

    public List<Queen> queens () {
        return bottomRow.queens();
    }
}
