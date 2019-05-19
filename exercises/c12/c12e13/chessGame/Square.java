package chessGame;

/**
 * Models a single square on a chess board.
 */
public class Square {

    // Private components:

    private final int row;
    private final int column;
    private boolean isOccupied;
    private Piece piece;

    // Constructors:

    /**
     * Create a new Square.
     */
    public Square (int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.piece = null;
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

    /**
     * This Square is occupied.
     */
    public boolean isOccupied () {
        return isOccupied;
    }

    /**
     * The Piece located at this Square.
     * @require    this.isOccupied()
     */
    public Piece piece () {
        return piece;
    }
}
