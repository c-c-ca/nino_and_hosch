package chessGame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the classes extending
 * the abstract class AbstractPiece.
 */
public class AbstractPieceTest {

    // Test fixture;

    public AbstractPiece bishop;     // Bishop to be tested
    public AbstractPiece rook;       // Rook to be tested
    public AbstractPiece black;      // Black piece to be tested

    @Before
    public void setUp () {
        bishop = new Bishop(4,4,true);
        rook = new Rook(4,4,true);
        black = new Bishop(1,1,false);
    }

    @Test
    public void testInitialState () {
        assertTrue(bishop.isWhite());
        assertFalse(black.isWhite());
        assertEquals("Bishop",bishop.name());
        assertEquals("Rook",rook.name());
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

    public void performLegalMove (AbstractPiece piece,
                                  int toRow, int toColumn) {
        // row and column changes
        int r1, r2, c1, c2;
        Square location = piece.location();
        r1 = location.row();
        c1 = location.column();
        piece.moveTo(new Square(toRow,toColumn));
        location = piece.location();
        r2 = location.row();
        c2 = location.column();
        assertEquals(toRow,r2);
        assertEquals(toColumn,c2);
    }

    public void performIllegalMove (AbstractPiece piece,
                                    int toRow, int toColumn) {
        // row and column stays the same
        int r1, r2, c1, c2;
        Square location = piece.location();
        r1 = location.row();
        c1 = location.column();
        piece.moveTo(new Square(toRow,toColumn));
        location = piece.location();
        r2 = location.row();
        c2 = location.column();
        assertEquals(r1,r2);
        assertEquals(c1,c2);
    }

    /**
     * Test the moveTo method.
     */
    @Test
    public void testMoveTo () {
        performLegalMove(bishop,6,6);
        performIllegalMove(bishop,6,5);
        performIllegalMove(rook,6,6);
        performLegalMove(rook,1,4);
    }
}
