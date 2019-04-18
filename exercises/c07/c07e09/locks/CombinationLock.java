package locks;

/**
 * A lock with an integer combination.
 */
public class CombinationLock {

    // Private components:

    private int combination;
    private boolean isOpen;

    // Constructors:

    /**
     * Create a lock with the specified combination.
     * @require    0 <= combination && combination <= 999
     * @ensure     this.isOpen()
     */
    public CombinationLock (int combination) {
        this.combination = combination;
        this.isOpen = true;
    }

    // Queries:

    /**
     * This CombinationLock is unlocked.
     */
    public boolean isOpen () {
        return isOpen;
    }

    // Commands:

    /**
     * Unlock this CombinationLock if the correct combination
     * is provided.  If this CombinationLock is already open,
     * it remains open regardless of whether or not the
     * correct combination is provided.
     * @require    0 <= combinationToTry &&
     *             combinationToTry <= 999
     */
    public void open (int combinationToTry) {
        if (this.combination == combinationToTry)
            isOpen = true;
    }

    /**
     * Lock this CombinationLock.
     * @ensure    !this.isOpen()
     */
    public void close () {
        isOpen = false;
    }

}
