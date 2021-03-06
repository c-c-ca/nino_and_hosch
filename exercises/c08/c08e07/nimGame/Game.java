package nimGame;

class Game {

    // Private components:

    private static final int MAX_ON_A_TURN = 3;
    private Player player1;
    private Player player2;
    private Player nextPlayer;
    private Player previousPlayer;
    private Pile pile;
    private NimTUI ui;

    // Constructors:

    /**
     * Create a nim Game, with the specified Players and the
     * specified number of sticks.  The first Player specified
     * (player1) plays first in the game.
     * @require    sticks > 0
     */
    public Game (Player player1, Player player2, int sticks) {
        assert sticks > 0 :
            "precondition: initial sticks > 0";
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1;
        this.previousPlayer = null;
        this.pile = new Pile(sticks);
    }

    // Queries:

    /**
     * The number of sticks remaining in the pile.
     * @ensure    this.sticksLeft() >= 0
     */
    public int sticksLeft () {
        return pile.sticks();
    }

    /**
     * The Player whose turn is next.
     */
    public Player nextPlayer () {
        return nextPlayer;
    }

    /**
     * The Player who last played; returns null if no play
     * has been made yet.
     */
    public Player previousPlayer () {
        return previousPlayer;
    }

    /**
     * The game is over.
     */
    public boolean gameOver () {
        return pile.sticks() == 0;
    }

    /**
     * The winning Player: the one who did not make the last
     * play in the game.  Returns null if the game is not over.
     * @ensure     if this.gameOver()
     *                 this.winner() != this.previousPlayer()
     */
    public Player winner () {
        if (gameOver())
            return otherPlayer(previousPlayer);
        else
            return null;
    }

    // Commands:

    /**
     * Conduct a single move in the game, allowing the appropriate
     * Player to take a turn.  Has no effect if the game is over.
     */
    public void play () {
        while (!gameOver()) {
            nextPlayer.takeTurn(pile,MAX_ON_A_TURN);
            previousPlayer = nextPlayer;
            nextPlayer = otherPlayer(nextPlayer);
            ui.notifyOfPlay();
        }
    }

    /**
     * Register a NimTUI with this Game.
     */
    public void register (NimTUI ui) {
        this.ui = ui;
    }

    /**
     * String representation of this Game.
     */
    public String toString () {
        return "Game with players: " + player1 + ", and "
                 + player2;
    }

    private Player otherPlayer (Player player) {
        if (player == player1)
            return player2;
        else
            return player1;
    }
}
