package genericExercises;

/**
 * An ordered pair in which the elments need not be
 * of the same type.
 */
public class Pair2<Type1, Type2> {

    private Type1 first;
    private Type2 second;

    /**
     * Create a new Pair consisting of the specified
     * elements.
     */
    public Pair2 (Type1 first, Type2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * The first element of this Pair.
     */
    public Type1 first () {
        return first;
    }

    /**
     * The second element of this Pair.
     */
    public Type2 second () {
        return second;
    }

    /**
     * Set the first element of this Pair to the
     * specified value.
     */
    public void setFirst (Type1 value) {
        this.first = value;
    }

    /**
     * Set the second element of this Pair to the
     * specified value.
     */
    public void setSecond (Type2 value) {
        this.second = value;
    }
}
