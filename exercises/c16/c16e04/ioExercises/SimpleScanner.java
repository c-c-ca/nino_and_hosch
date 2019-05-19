package ioExercises;

import java.io.*;

public class SimpleScanner {

    // Private components:

    private int lastInt;
    private BufferedReader input;
    private StringBuffer buffer;

    // Constructors:

    /**
     * Create a SimpleScanner attached to standard input.
     */
    public SimpleScanner () {
        input = new BufferedReader(
                    new InputStreamReader(System.in));
        buffer = new StringBuffer();
    }

    /**
     * Create a SimpleScanner attached to the named file
     */
    public SimpleScanner (String fileName) throws
        java.io.FileNotFoundException {
            input = new BufferedReader(
                        new FileReader(fileName));
        }

    // Queries:

    public int lastInt () {
        return this.lastInt;
    }

    // Commands:

    private int skipSpace () throws java.io.IOException {
        int inchar;
        if (buffer.length() > 0) {
            inchar = buffer.charAt(0);
            buffer.deleteCharAt(0);
        } else
            inchar = input.read();
        while (Character.isWhitespace((char)inchar)) {
            inchar = input.read();
        }
        return inchar;
    }

    public void readInt () throws java.io.IOException {
        int sign = 1;
        int inchar = skipSpace();

        if ((char)inchar == '-')
            sign = -1;
        if ((char)inchar == '+' || (char)inchar == '-')
            inchar = input.read();

        if (inchar == -1)
            throw new java.io.EOFException(
                "Encountered EOF; expected digit");
        else if (!Character.isDigit((char)inchar)) {
            buffer.append((char)inchar);
            throw new InputFormatException(
                "Encountered " + (char)inchar + "; expected digit");
        }

        lastInt = 0;
        while (Character.isDigit((char)inchar)) {
            lastInt =
                10*lastInt + Character.digit((char)inchar,10);
                inchar = input.read();
        }
        lastInt = lastInt * sign;
        if (inchar != -1)
            buffer.append((char)inchar);
    }

}
