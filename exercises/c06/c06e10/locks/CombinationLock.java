package locks;

/**
 * A lock with a three digit combination.
 */
public class CombinationLock {

    // Private components:

    private int digit1st;        // 1st digit of the combination
    private int digit2nd;        // 2nd digit of the combination
    private int digit3rd;        // 3rd digit of the combination
    private boolean isOpen;      // lock is open
    private boolean needSecond;  // 1st combination digit has been
                                 // entered
    private boolean needThird;   // 3rd combination digit will open
                                 // the lock (i.e. 2nd has been entered)


    // Constructors:

    /**
     * Create a lock with a given three digit combination;
     * combination values < 100 are assumed to have leading
     * zeros.
     * @require    0 <= combination && combination <= 999
     * @ensure     this.isOpen()
     */
    public CombinationLock (int combination) {
        this.digit1st = combination/100;
        this.digit2nd = combination%100/10;
        this.digit3rd = combination%10;
        this.isOpen = true;
        this.needSecond = false;
        this.needThird = false;
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
        needThird = false;
    }

    /**
     * Enter a digit of the combination; unlocks if the digits
     * of the combination are entered in order.
     * @require    0 <= digit && digit <= 9
     */
    public void enter (int digit) {
        if (needThird)
            if (digit == digit3rd)
                isOpen = true;
            else if (digit1st == digit2nd)
                needSecond = needThird = (digit == digit1st);
            else {
                needSecond = (digit == digit1st);
                needThird = false;
            }
        else if (needSecond && digit == digit2nd)
            needThird = true;
        else
            needSecond = (digit == digit1st);
    }

}
