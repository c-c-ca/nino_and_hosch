package ioExercises;

import java.io.*;

/**
 * A simple class that prompts to standard output and
 * reads from standard input.
 */
public class SimpleInput extends BufferedReader {

    /**
     * Create a new SimpleInput instance.
     */
    public SimpleInput () {
        super(new InputStreamReader(System.in));
    }

    /**
     * Read a single line of input and return the
     * value of the integer represented on the line.
     * The characters on the line must be all decimal
     * digits, except that the first character may be
     * a minus sign '-'.
     */
    public int readInt () throws IOException {
        return Integer.parseInt(this.readLine());
    }

    /**
     * Read a single line of input and return the
     * value of the double represented on the line.
     * The characters on the line must have the
     * format of a double.
     */
    public double readDouble () throws IOException {
        return Double.parseDouble(this.readLine());
    }

    /**
     * Read a single line of input and return the
     * value of the first character represented on
     * the line.  The line must be at least one
     * character long.  Subsequent characters are
     * ignored.
     */
    public char readChar () throws IOException {
        return this.readLine().charAt(0);
    }

    /**
     * Read a single line from standard input.
     */
    public String readString () throws IOException {
        return this.readLine();
    }
}
