package chessGame;

/**
 * Models a single square on a chess board.
 */
public class Square {

    // Private components:

    private final int row;
    private final int column;

    // Constructors:

    /**
     * Create a new Square.
     */
    public Square (int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Queries:

    /**
     * This Square's row.
     */
    public int row () {
        return row;
    }

    /**
     * This Square's column.
     */
    public int column () {
        return column;
    }
}
