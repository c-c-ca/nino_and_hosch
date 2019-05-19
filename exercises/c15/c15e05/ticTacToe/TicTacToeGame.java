package ticTacToe;

public class TicTacToeGame implements Cloneable {

    // Named constants:

    public static final int UNMARKED = 0;
    public static final int O = -1;
    public static final int X = 1;
    private static final int NONE = 0;
    private static final int SIZE = 3;

    // Private components:

    private Cell[][] row = new Cell[SIZE][SIZE];
    private Cell[][] column = new Cell[SIZE][SIZE];
    private Cell[][] diagonal = new Cell[2][SIZE];

    // Private inner class:

    private class Cell implements Cloneable {

        private int mark = NONE;

        public boolean equals (Object other) {
            if (other instanceof Cell)
                return this.mark == ((Cell)other).mark;
            else
                return false;
        }

        public Object clone () {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }
    }

    // Constructors:

    public TicTacToeGame () {
        for (int r = 0; r < SIZE; r = r+1)
            for (int c = 0; c < SIZE; c = c+1)
                row[r][c] = new Cell();
        for (int c = 0; c < SIZE; c = c+1)
            for (int r = 0; r < SIZE; r = r+1)
                column[c][r] = row[r][c];
        for (int rc = 0; rc < SIZE; rc = rc+1) {
            diagonal[0][rc] = row[rc][rc];
            diagonal[1][rc] = row[SIZE-1-rc][rc];
        }
    }

    public boolean gameOver () {
        return winner() != NONE;
    }

    private int winner () {
        int winner = checkPaths(row);
        if (winner == NONE) winner = checkPaths(column);
        if (winner == NONE) winner = checkPaths(diagonal);
        return winner;
    }

    private int checkPaths (Cell[][] paths) {
        int wins = NONE;
        for (int i = 0; wins == NONE && i < paths.length; i = i+1)
            wins = checkPath(paths[i]);
        return wins;
    }

    private int checkPath (Cell[] path) {
        int sum = 0;
        for (int i = 0; i < SIZE; i = i+1)
            sum = sum + path[i].mark;
        return sum/SIZE;
    }

    public void mark (
        int marking, int r, int c) {
            row[r-1][c-1].mark = marking;
    }

    public boolean equals (Object other) {
        if (other instanceof TicTacToeGame) {
            TicTacToeGame game = (TicTacToeGame)other;
            for (int r = 0; r < SIZE; r = r+1)
                for (int c = 0; c < SIZE; c = c+1)
                    if (!this.row[r][c].equals(game.row[r][c]))
                        return false;
                return true;
        } else
            return false;
    }

    public Object clone () {
        try {
            TicTacToeGame theCopy =
                (TicTacToeGame)super.clone();
            theCopy.row = new Cell[SIZE][SIZE];
            theCopy.column = new Cell[SIZE][SIZE];
            theCopy.diagonal = new Cell[2][SIZE];
            for (int r = 0; r < SIZE; r = r+1)
                for (int c = 0; c < SIZE; c = c+1)
                    theCopy.row[r][c] = (Cell)row[r][c].clone();
            for (int c = 0; c < SIZE; c = c+1)
                for (int r = 0; r < SIZE; r = r+1)
                    theCopy.column[c][r] = theCopy.row[r][c];
            for (int rc = 0; rc < SIZE; rc = rc+1) {
                theCopy.diagonal[0][rc] = theCopy.row[rc][rc];
                theCopy.diagonal[1][rc] = theCopy.row[SIZE-1-rc][rc];
            }
            return theCopy;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
