package oracles;
import locks.*;

/**
 * A keyed dispenser of fortunes.  A LockedOracle will augur a
 * fortune only if the correct key is provided.  A LockedOracle
 * must be told to augur a fortune before the fortune can be
 * retrieved.
 */
public class LockedOracle {

    // Named constants:

    private CombinationLock lock;
    private Oracle oracle;
    private String fortune;

    /**
     * String indicating no fortune has been augured.
     */
    public static final String NO_FORTUNE =
                    "Sorry, no fortune for you.";

    // Constructors:

    /**
     * Create new LockedOracle with the specified key.
     * @require 0 <= key && key <= 999
     */
    public LockedOracle (int key) {
        lock = new CombinationLock(key);
        lock.close();
        oracle = new Oracle();
        fortune = NO_FORTUNE;
    }

    // Queries:

    /**
     * The fortune augured by this LockedOracle.  If a fortune
     * has not been successfully augured, the String NO_FORTUNE
     * is returned
     */
    public String fortune () {
        return this.fortune;
    }

    // Commands:

    /**
     * Augur a new fortune.  This LockedOracle will augur a
     * fortune only if the correct key is presented.
     * @require    0 <= keyToTry &&
     *             keyToTry <= 999
     */
    public void augurFortune (int keyToTry) {
        lock.open(keyToTry);
        if (lock.isOpen()) {
            oracle.awaken();
            fortune = oracle.fortune();
            oracle.sleep();
            lock.close();
        } else
            fortune = NO_FORTUNE;
    }

}
