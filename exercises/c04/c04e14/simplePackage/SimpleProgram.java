package simplePackage;

/**
 * A simple program for chapter 4, exercise 14.
 */
class SimpleProgram {

    /**
     * Runs a simple program.
     */
    public static void main (String[] args) {
        boolean a = false;
        boolean b = false;
        if (a = b)  // this is an assignment expression, not a boolean expression,
                    // which evaluates as false and executes the statement in the
                    // else branch
            System.out.println("Equal!");
        else
            System.out.println("Not equal!");
    }
}
