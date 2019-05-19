package chessGame;

/**
 * Models a bishop in the game of chess.
 */
public class Bishop extends AbstractPiece {

    // Named constants:

    private static final String NAME = "Bishop";

    // Constructors:

    /**
     * Create a new Bishop.
     */
    public Bishop (int row, int column,
                   boolean isWhite) {
        this(new Square(row,column),isWhite);
    }

    /**
     * Create a new Bishop.
     */
    public Bishop (Square location, boolean isWhite) {
        super(location,isWhite,NAME);
    }

    // Queries:

    /**
     * The Bishop can move to the location
     * identified by the specified row and column.
     */
    public boolean canMoveTo (Square location) {
        int r1, r2, c1, c2;
        r1 = location().row();
        r2 = location.row();
        c1 = location().column();
        c2 = location.column();
        return (Math.abs(r2-r1) == Math.abs(c2-c1));
    }
}
