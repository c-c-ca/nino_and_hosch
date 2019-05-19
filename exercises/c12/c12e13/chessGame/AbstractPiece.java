package chessGame;

/**
 * Models an AbstractPiece in the game of chess.
 */
public abstract class AbstractPiece
    implements Piece {

    // Private components:

    private Square location;
    private boolean isWhite;
    private String name;

    // Constructors:

    /**
     * Create a new AbstractPiece.
     */
    protected AbstractPiece (Square location, boolean isWhite,
                          String name) {
        this.location = location;
        this.isWhite = isWhite;
        this.name = name;
    }

    // Queries:

    /**
     * This piece is white.
     */
    public boolean isWhite () {
        return isWhite;
    }

    /**
     * The name of this piece, as a String.
     */
    public String name () {
        return name;
    }

    /**
     * The location of this piece.  Returns null if this
     * piece is no longer in play.
     */
    public Square location () {
        return location;
    }

    /**
     * This piece can legally move to the specified
     * Square.
     */
    public abstract boolean canMoveTo (Square location);

    // Methods:

    /**
     * Move this piece to the specified Square if it
     * can legally do so.  Otherwise, this piece does
     * not change location.
     */
    public void moveTo (Square location) {
        if (canMoveTo(location))
            this.location = location;
    }

    /**
     * Remove this piece from play.
     */
    public void remove () {
        this.location = null;
    }
}
