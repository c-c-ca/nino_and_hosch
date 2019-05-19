package chessGame;

/**
 * Models a rook in the game of chess.
 */
public class Rook extends AbstractPiece {

    // Named constants:

    private static final String NAME = "Rook";

    // Constructors:

    /**
     * Create a new Rook.
     */
    public Rook (int row, int column,
                 boolean isWhite) {
        this(new Square(row,column),isWhite);
    }

    /**
     * Create a new Rook.
     */
    public Rook (Square location, boolean isWhite) {
        super(location,isWhite,NAME);
    }

    // Queries:

    /**
     * The Rook can move to the location
     * identified by the specified row and column.
     */
    public boolean canMoveTo (Square location) {
        int r1, r2, c1, c2;
        r1 = location().row();
        r2 = location.row();
        c1 = location().column();
        c2 = location.column();
        return ((r2 - r1 == 0) || (c2 - c1 == 0));
    }
}
