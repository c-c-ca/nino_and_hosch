package chessGame;

/**
 * Models a simple piece in the game of chess.
 */
public interface Piece {

    // Queries:

    /**
     * This piece is white.
     */
    public boolean isWhite ();

    /**
     * The name of this piece, as a String.
     */
    public String name ();

    /**
     * The location of this piece.  Returns null if this
     * piece is no longer in play.
     */
    public Square location ();

    /**
     * The chess Piece can move to the location
     * identified by the specified row and column.
     */
    public boolean canMoveTo (Square location);

    // Commands:

    /**
     * Move the chess Piece to the location
     * identified by the specified row and column.
     * @ensure     this.canMoveTo(row,column)
     */
    public void moveTo (Square location);
}
