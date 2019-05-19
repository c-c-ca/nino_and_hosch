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

    /**
     * The set union of this IntSet and the specified IntSet.
     */
    public IntSet union (IntSet other) {
        IntSet large, small, union;

        if (this.maxElement() > other.maxElement()) {
            large = this;
            small = other;
        } else {
            large = other;
            small = this;
        }

        union = new IntSet(large.maxElement());

        for (int i = 0; i <= large.maxElement(); i = i+1)
            if (large.isIn(i) || small.isIn(i))
                union.add(i);

        return union;
    }

    /**
     * The set intersection of this IntSet and the specified IntSet.
     */
    public IntSet intersection (IntSet other) {
        IntSet large, small, intersection;

        if (this.maxElement() > other.maxElement()) {
            large = this;
            small = other;
        } else {
            large = other;
            small = this;
        }

        intersection = new IntSet(small.maxElement());

        for (int i = 0; i <= small.maxElement(); i = i+1)
            if (large.isIn(i) && small.isIn(i))
                intersection.add(i);

        return intersection;
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

    public String toString () {
        String s = "{";
        boolean found = false;
        for (int i = 0; i <= this.maxElement(); i = i+1)
            if (this.isIn(i))
                if (!found) {
                    s = s + i;
                    found = true;
                } else
                    s = s + ", " + i;
        return s + "}";
    }
}
