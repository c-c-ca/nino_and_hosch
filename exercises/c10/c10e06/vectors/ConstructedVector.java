package vectors;

public class ConstructedVector extends IntVector {

    // Constructors:

    /**
     * Create a new nonempty IntVector with the specified
     * first element and specified tail.
     * @ensure     !this.isEmpty()
     *             this.head() == head &&
     *             this.tail().equals(tail)
     */
    public ConstructedVector (int head, IntVector tail) {
        this.head = head;
        this.tail = tail;
    }

    // Queries:

    /**
     * This ConstructedVector is empty.
     */
    public boolean isEmpty () {
        return false;
    }

    /**
     * A String representation of this ConstructedVector.
     */
    public String toString () {
        return "(" + this.head() +
            this.tail().continueString();
    }

    protected String continueString () {
        return ", " + this.head() +
            this.tail().continueString();
    }
}
