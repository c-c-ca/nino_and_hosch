package ioExercises;

import java.io.*;

public class Exercise {

    private static final int NON_WHITE_SPACE = 'A';

    public static void compress (Reader in, Writer out)
        throws IOException {
        int c, lastc;

        lastc = NON_WHITE_SPACE;
        while ((c = in.read()) != -1) {
            if (!Character.isWhitespace((char)c) ||
                !Character.isWhitespace((char)lastc))
                out.write(c); out.flush();
            lastc = c;
        }
        in.close();
    }

    public static void main (String[] argv) {
        try {
            compress(
                new InputStreamReader(System.in),
                new OutputStreamWriter(System.out));
        } catch (IOException e) {
            System.out.println(
                "An error occurred: " + e);
        }
    }
}
