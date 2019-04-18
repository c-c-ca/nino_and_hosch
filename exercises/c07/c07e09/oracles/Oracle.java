package oracles;

/**
 * A dispenser of fortunes.  An Oracle will give a fortune
 * only if it is awake.  The normal sequences of actions is:
 * wake the Oracle; get a fortune; put the Oracle back to
 * sleep.
 */
public class Oracle {

    // Named constants:

    private static String firstFortune =
        "To iterate is human, to recurse, divine.";
    private static String secondFortune =
        "First, solve the problem.  Then, write the code.";

    // Private components:

    private boolean isAwake;    // the oracle is awake
    private boolean giveFirst;  // give the first fortune
                                // when fortune is called

    // Constructors:

    /**
     * Create new Oracle.  This Oracle is initially asleep.
     * @ensure     !this.isAwake()
     */
    public Oracle () {
        isAwake = false;
        giveFirst = false;
    }

    // Queries:

    /**
     * This Oracle is awake.
     */
    public boolean isAwake () {
        return isAwake;
    }

    /**
     * The fortune currently discerned by this Oracle.
     * @require    this.isAwake()
     */
    public String fortune () {
        String fortune;
        if (giveFirst)
            fortune = firstFortune;
        else
            fortune = secondFortune;
        return fortune;
    }

    // Commands:

    /**
     * Wake this Oracle.  The Oracle will foretell a new
     * fortune when it wakes.
     */
    public void awaken () {
        if (!isAwake)
            giveFirst = !giveFirst;
        isAwake = true;
    }

    /**
     * Put this Oracle to sleep.
     */
    public void sleep () {
        isAwake = false;
    }

}
