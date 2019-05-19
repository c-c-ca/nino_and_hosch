package ioExercises;

import java.io.*;

/**
 * A simple class that prompts to standard output and
 * reads from standard input.
 */
public class SimpleInput extends PushbackReader {

    /**
     * Create a new SimpleInput instance.
     */
    public SimpleInput () {
        super(new BufferedReader(
                new InputStreamReader(System.in)));
    }

    private int skipSpace () throws java.io.IOException {
        int inchar;
        inchar = read();
        while (Character.isWhitespace((char)inchar)) {
            inchar = read();
        }
        return inchar;
    }

    /**
     * Read an int.  The digit string is interpreted as a
     * decimal integer.
     * @require    leading characters in the input stream
     *             must consist of:
     *                zero or more white space characters,
     *                followed by an optional sign,
     *                followed by one or more decimal
     *                digits
     */
    public int readInt () throws IOException {
        int sign = 1;
        int inchar = skipSpace();

        if ((char)inchar == '-')
            sign = -1;
        if ((char)inchar == '+' || (char)inchar == '-')
            inchar = read();

        if (inchar == -1)
            throw new java.io.EOFException(
                "Encountered EOF; expected digit");
        else if (!Character.isDigit((char)inchar)) {
            unread(inchar);
            throw new InputFormatException(
                "Encountered " + (char)inchar + "; expected digit");
        }

        int value = 0;
        while (Character.isDigit((char)inchar)) {
            value =
                10*value + Character.digit((char)inchar,10);
                inchar = read();
        }
        if (inchar != -1)
            unread(inchar);
        return value * sign;
    }
}
