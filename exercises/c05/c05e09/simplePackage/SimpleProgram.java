package simplePackage;

/**
 * A simple program for chapter 5, exercise 9.
 */
class SimpleProgram {

    /**
     * Runs a simple program.
     */
    public static void main (String[] args) {
        // As mentioned in chapter 5, there are situations where preconditions
        // and/or postconditions are assumed and not explicitly stated.
        // For numeric types, there is an expected "range of reasonable use".
        // Here, there is an upperbound on type int (2,147,483,647) meaning
        // that any variable of type int can only be legitimately incremented
        // if its value is less than this limit.
        //
        // The result itself can best be explained by remembering that there
        // is an underlying representation for the type int (i.e. int values are
        // encoded as a series of 32 bits, with half of the patterns
        // representing negative numbers), such that adding 1 to the underlying
        // representation of the maximum value yields the minimum value. Once
        // incremented beyond its upperbound, the int "cycles" back to its lower
        // limit.
        //
        int i = 2147483647;
        i = i + 1;
        System.out.println("i = " + i);
    }
}
