package chessGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple test class to test the class ChessBoard.
 */
public class ChessBoardTest {

    // Test fixture:

    private ChessBoard board;
    private Square first;
    private Square last;
    private Square typical;

    @Before
    public void setUp () {
        board = new ChessBoard();
    }

    @Test
    public void testInitialState () {
        first = board.squareAt(1,1);
        assertEquals(1,first.row());
        assertEquals(1,first.column());
        last = board.squareAt(8,8);
        assertEquals(8,last.row());
        assertEquals(8,last.column());
        typical = board.squareAt(5,3);
        assertEquals(5,typical.row());
        assertEquals(3,typical.column());
    }

}
