package vectors;

/**
 * A finite, possibly empty, sequence of integers.
 */
public class IntVector {

    private int head;
    private IntVector tail;

    /**
     * Create a new empty IntVector.
     * @ensure     this.isEmpty()
     */
    public IntVector () {
        head = 0;
        tail = null;
    }

    /**
     * This IntVector is empty.
     */
    public boolean isEmpty () {
        return (tail == null);
    }

    /**
     * A new IntVector, constructed by prefixing the
     * specified int to this IntVector.
     * @ensure     !(this.prefix(i)).isEmpty()
     */
    public IntVector prefix (int i) {
        IntVector newIntVector = new IntVector();
        newIntVector.head = i;
        newIntVector.tail = this;
        return newIntVector;
    }

    /**
     * The first element of this IntVector.
     * @require    !this.isEmpty()
     */
    public int head () {
        return head;
    }

    /**
     * An IntVector equal to this IntVector with
     * the first element removed.
     * @require    !this.isEmpty()
     */
    public IntVector tail () {
        return tail;
    }

    /**
     * The argument is an IntVector, and represents
     * the same sequence of integers as this IntVector.
     */
    public boolean equals (Object obj) {
        if (obj instanceof IntVector) {
            IntVector other = (IntVector)obj;
            if (isEmpty() || other.isEmpty())
                return isEmpty() && other.isEmpty();
            else if (head != other.head())
                return false;
            else
                return tail.equals(other.tail());
        } else
            return false;
    }

    /**
     * A String representation of this IntVector.
     */
    public String toString () {
        String s = "(";

        if (!isEmpty()) {
            s = s + String.valueOf(head);
            IntVector iv = tail;
            while (!iv.isEmpty()) {
                s = s + ", " + String.valueOf(iv.head);
                iv = iv.tail;
            }
        }
        return s + ")";
    }
}
