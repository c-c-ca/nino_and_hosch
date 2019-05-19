package ticTacToe;

import static ticTacToe.TicTacToeGame.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeGameTest {

    // Test fixture:

    private TicTacToeGame game;
    private TicTacToeGame copy;

    @Before
    public void setUp () {
        game = new TicTacToeGame();
    }

    @Test
    public void testGameOverByRow () {
        game.mark(X,1,1);
        assertFalse(game.gameOver());
        game.mark(X,1,2);
        assertFalse(game.gameOver());
        game.mark(X,1,3);
        assertTrue(game.gameOver());
    }

    @Test
    public void testGameOverByColumn () {
        game.mark(X,1,1);
        assertFalse(game.gameOver());
        game.mark(X,2,1);
        assertFalse(game.gameOver());
        game.mark(X,3,1);
        assertTrue(game.gameOver());
    }

    @Test
    public void testGameOverByDiagonal () {
        game.mark(X,1,1);
        assertFalse(game.gameOver());
        game.mark(X,2,2);
        assertFalse(game.gameOver());
        game.mark(X,3,3);
        assertTrue(game.gameOver());
    }

    @Test
    public void testClone () {
        game.mark(X,1,1);
        assertFalse(game.gameOver());
        game.mark(X,2,1);
        assertFalse(game.gameOver());
        copy = (TicTacToeGame)game.clone();
        assertTrue(game.equals(copy));
        copy.mark(X,3,1);
        assertTrue(copy.gameOver());
        assertFalse(game.gameOver());
        game.mark(X,3,1);
        assertTrue(game.gameOver());
    }
}
