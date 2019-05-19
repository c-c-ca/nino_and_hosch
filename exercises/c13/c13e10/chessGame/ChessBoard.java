package chessGame;

import nhUtilities.containers.*;

/**
 * Models a chess board.
 */
public class ChessBoard {

    // Named constants:

    private static final int SIZE = 8;

    // Private components:

    private Square[][] board;

    // Constructors:

    /**
     * Create a new ChessBoard.
     */
    public ChessBoard () {
        board = new Square[SIZE][SIZE];
        for (int r = 0; r < SIZE; r = r+1)
            board[r] = initializeRow(r);
    }

    private Square[] initializeRow (int r) {
        Square[] row = new Square[SIZE];
        for (int c = 0; c < SIZE; c = c+1)
            row[c] = new Square(r+1,c+1);
        return row;
    }

    // Queries:

    /**
     * Returns the Square at the specified row and
     * column for this ChessBoard.
     */
    public Square squareAt (int row, int column) {
        return board[row-1][column-1];
    }
}
