package locks;

/**
 * A lock with a two digit combination.
 */
public class CombinationLock {

    // Private components:

    private int digit1st;        // 1st digit of the combination
    private int digit2nd;        // 2nd digit of the combination
    private boolean isOpen;      // lock is open
    private boolean needSecond;  // 2nd combination digit will open
                                 // the lock (i.e., 1st has been entered.)

    // Constructors:

    /**
     * Create a lock with a given two digit combination;
     * combination values < 10 are assumed to have a leading
     * zero.
     * @require    0 <= combination && combination <= 99
     * @ensure     this.isOpen()
     */
    public CombinationLock (int combination) {
        this.digit1st = combination/10;
        this.digit2nd = combination%10;
        this.isOpen = true;
        this.needSecond = false;
    }

    // Queries:

    /**
     * This lock is unlocked.
     */
    public boolean isOpen () {
        return isOpen;
    }

    // Commands:

    /**
     * Lock and reset this lock; partially entered combination
     * is lost.
     */
    public void close () {
        isOpen = false;
        needSecond = false;
    }

    /**
     * Enter a digit of the combination; unlocks if the digits
     * of the combination are entered in order.
     * @require    0 <= digit && digit <= 9
     */
    public void enter (int digit) {
        if (needSecond && digit == digit2nd)
            isOpen = true;
        else
            needSecond = (digit == digit1st);
    }

}
