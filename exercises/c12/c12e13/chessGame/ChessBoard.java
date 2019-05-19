package chessGame;

import nhUtilities.containers.*;

/**
 * Models a chess board.
 */
public class ChessBoard {

    // Named constants:

    private static final int SIZE = 8;

    // Private components:

    private List<List<Square>> board;

    // Constructors:

    /**
     * Create a new ChessBoard.
     */
    public ChessBoard () {
        board = new DefaultList<List<Square>>();
        for (int r = 1; r <= SIZE; r = r+1)
            board.add(initializeRow(r));
    }

    private List<Square> initializeRow (int r) {
        List<Square> row = new DefaultList<Square>();
        for (int c = 1; c <= SIZE; c = c+1)
            row.add(new Square(r,c));
        return row;
    }

    // Queries:

    /**
     * Returns the Square at the specified row and
     * column for this ChessBoard.
     */
    public Square squareAt (int row, int column) {
        return board.get(row-1).get(column-1);
    }
}
