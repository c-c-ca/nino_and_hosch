package chessGame;

/**
 * Models a rook in the game of chess.
 */
public class Rook implements Piece {

    // Private components:

    private int row;    // the row number
                        // this Rook is in
    private int column; // the column number
                        // this Rook is in

    // Constructors:

    public Rook (int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Queries:

    /**
     * The Rook can move to the location
     * identified by the specified row and column.
     */
    public boolean canMoveTo (int row, int column) {
        return ((this.row - row == 0) ||
                (this.column - column == 0));
    }

    // Commands:

    /**
     * Move the Rook to the location
     * identified by the specified row and column.
     * @ensure     this.canMoveTo(row,column)
     */
    public void moveTo (int row, int column) {
        this.row = row;
        this.column = column;
    }
}
