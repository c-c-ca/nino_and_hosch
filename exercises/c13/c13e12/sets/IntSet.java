package sets;

/**
 * Models a set of small, non-negative integers.
 */
public class IntSet {

    // Private components:

    private boolean[] isIn;

    // Constructors:

    /**
     * A subset of integers 0, ..., maxElement.
     * @require    maxElement >= 0
     */
    public IntSet (int maxElement) {
        isIn = new boolean[maxElement+1];
    }

    // Queries:

    /**
     * The maximum value in this IntSet.
     */
    public int maxElement () {
        return isIn.length - 1;
    }

    /**
     * The specified element is in the set.
     */
    public boolean isIn (int element) {
        return (element < isIn.length ? isIn[element] : false);
    }

    // Commands:

    /**
     * Add the specified element to this IntSet.
     * @require    0 <= n && n <= maxElement
     */
    public void add (int element) {
        isIn[element] = true;
    }

    /**
     * Remove the specified element from this set.
     */
    public void remove (int element) {
        isIn[element] = false;
    }
}
