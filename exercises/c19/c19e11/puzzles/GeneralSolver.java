package puzzles;

import nhUtilities.containers.*;

public class GeneralSolver implements Solver {

    private Solver associate;
    private int c;
    private boolean solved;
    private int size;

    public GeneralSolver (Solver associate, int size) {
        this.associate = associate;
        this.c = 0;
        this.solved = false;
        this.size = size;
    }

    public boolean solved () {
        return solved;
    }

    public void first () {
        associate.first();
        next();
    }

    public boolean canAttack (int r, int c) {
        if (Math.abs(this.c - c) == r ||
            this.c == c)
            return true;
        else
            return associate.canAttack(r+1,c);
    }

    public void next () {
        solved = false;
        while (!solved && associate.solved()) {
            if (c == size) {
                associate.next();
                c = 0;
            }
            c = c + 1;
            solved = !associate.canAttack(1,c)
                     && associate.solved();
        }
    }

    public List<Queen> queens () {
        List<Queen> queens = associate.queens();
        if (queens != null)
            queens.add(new Queen(queens.size()+1,c));
        return queens;
    }
}
