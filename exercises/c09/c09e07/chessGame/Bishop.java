package chessGame;

/**
 * Models a bishop in the game of chess.
 */
public class Bishop implements Piece {

    // Private components:

    private int row;    // the row number
                        // this Bishop is in
    private int column; // the column number
                        // this Bishop is in

    // Constructors:

    public Bishop (int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Queries:

    /**
     * The Bishop can move to the location
     * identified by the specified row and column.
     */
    public boolean canMoveTo (int row, int column) {
        return (Math.abs(this.row-row) ==
                Math.abs(this.column-column));
    }

    // Commands:

    /**
     * Move the Bishop to the location
     * identified by the specified row and column.
     * @ensure     this.canMoveTo(row,column)
     */
    public void moveTo (int row, int column) {
        this.row = row;
        this.column = column;
    }
}
