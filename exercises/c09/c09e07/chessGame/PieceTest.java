package chessGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the classes implementing
 * the Piece interface.
 */
public class PieceTest {

    // Test fixture;

    public Piece bishop;  // Bishop to be tested
    public Piece rook;    // Rook to be tested

    @Before
    public void setUp () {
        bishop = new Bishop(4,4);
        rook = new Rook(4,4);
    }

    /**
     * Test if the Pieces can move up.
     */
    @Test
    public void testMoveUp () {
        assertFalse(bishop.canMoveTo(5,4));
        assertTrue(rook.canMoveTo(5,4));
    }

    /**
     * Test if the Pieces can move down.
     */
    @Test
    public void testMoveDown () {
        assertFalse(bishop.canMoveTo(3,4));
        assertTrue(rook.canMoveTo(3,4));
    }

    /**
     * Test if the Pieces can move left.
     */
    @Test
    public void testMoveLeft () {
        assertFalse(bishop.canMoveTo(4,3));
        assertTrue(rook.canMoveTo(4,3));
    }

    /**
     * Test if the Pieces can move right.
     */
    @Test
    public void testMoveRight () {
        assertFalse(bishop.canMoveTo(4,5));
        assertTrue(rook.canMoveTo(4,5));
    }

    /**
     * Test if the Pieces can move up and left.
     */
    @Test
    public void testMoveUpAndLeft () {
        assertTrue(bishop.canMoveTo(5,3));
        assertFalse(rook.canMoveTo(5,3));
    }

    /**
     * Test if the Pieces can move up and right.
     */
    @Test
    public void testMoveUpAndRight () {
        assertTrue(bishop.canMoveTo(5,5));
        assertFalse(rook.canMoveTo(5,5));
    }

    /**
     * Test if the Pieces can move down and left.
     */
    @Test
    public void testMoveDownAndLeft () {
        assertTrue(bishop.canMoveTo(3,3));
        assertFalse(rook.canMoveTo(3,3));
    }

    /**
     * Test if the Pieces can move down and right.
     */
    @Test
    public void testMoveDownAndRight () {
        assertTrue(bishop.canMoveTo(3,5));
        assertFalse(rook.canMoveTo(3,5));
    }
}
