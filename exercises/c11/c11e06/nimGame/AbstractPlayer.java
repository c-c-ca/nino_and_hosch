package nimGame;

public abstract class AbstractPlayer implements Player {

    // Private components:

    private String name;
    private int numberTaken;

    // Constructors:

    /**
     * Create a new AbstractPlayer.
     */
    protected AbstractPlayer (String name) {
        this.name = name;
        this.numberTaken = 0;
    }

    // Queries:

    /**
     * This AbstractPlayer's name.
     */
    public String name () {
        return name;
    }

    /**
     * Number of sticks removed on this AbstractPlayer's most recent
     * turn.  Returns 0 if this Player has not yet taken a
     * turn.
     * @ensure     this.numberTaken() >= 0
     */
    public int numberTaken () {
        return numberTaken;
    }

    // Commands:

    protected void setNumberTaken (int number) {
        numberTaken = number;
    }
}
