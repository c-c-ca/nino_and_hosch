package vectors;

/**
 * A finite, possibly empty, sequence of integers.
 */
public class IntVector {

    // Static methods:

    /**
     * The sum of the integers in the specified
     * IntVector.
     */
    public static int sum (IntVector iv) {
        if (iv.isEmpty())
            return 0;
        else
            return iv.head() + sum(iv.tail());
    }

    // Private components:

    protected int head;
    protected IntVector tail;

    // Constructors:

    /**
     * Create a new empty IntVector.
     * @ensure     this.isEmpty()
     */
    public IntVector () {
        head = 0;
        tail = null;
    }

    // Queries:

    /**
     * This IntVector is empty.
     */
    public boolean isEmpty () {
        return true;
    }

    /**
     * A new IntVector, constructed by prefixing the
     * specified int to this IntVector.
     * @ensure     !(this.prefix(i)).isEmpty()
     */
    public IntVector prefix (int i) {
        return new ConstructedVector(i,this);
    }

    /**
     * The first element of this IntVector.
     * @require    !this.isEmpty()
     */
    public int head () {
        return head;
    }

    /**
     * An IntVector equal to this IntVector with the
     * first element removed.
     * @require    !this.isEmpty()
     */
    public IntVector tail () {
        return tail;
    }

    /**
     * The argument is an IntVector, and represents the
     * same sequence of integers as this IntVector.
     */
    public final boolean equals (Object obj) {
        if (obj instanceof IntVector) {
            IntVector v = (IntVector)obj;
            if (isEmpty())
                return v.isEmpty();
            else
                return !v.isEmpty() &&
                       head == v.head() &&
                       tail.equals(tail);
        } else
            return false;
    }

    /**
     * A String representation of this IntVector.
     */
    public String toString () {
        return "()";
    }

    protected String continueString () {
        return ")";
    }
}
