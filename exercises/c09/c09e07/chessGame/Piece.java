package chessGame;

/**
 * Models a simple piece in the game of chess.
 */
public interface Piece {

    // Queries:

    /**
     * The chess Piece can move to the location
     * identified by the specified row and column.
     */
    public boolean canMoveTo (int row, int column);

    // Commands:

    /**
     * Move the chess Piece to the location
     * identified by the specified row and column.
     * @ensure     this.canMoveTo(row,column)
     */
    public void moveTo (int row, int column);
}
