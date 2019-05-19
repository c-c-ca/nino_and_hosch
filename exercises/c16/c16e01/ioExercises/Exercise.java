package ioExercises;

import java.io.*;

public class Exercise {

    private static final int NULL = 0;

    public static int nullCount (InputStream in)
        throws IOException {
        int b, count;

        count = 0;
        while ((b = in.read()) != -1) {
            if (b == NULL)
                count = count + 1;
        }
        in.close();
        return count;
    }

    public static void main (String[] argv) {
        try {
            int count;
            count = nullCount(System.in);
            System.out.println(count);
        } catch (IOException e) {
            System.out.println(
                "An error occurred: " + e);
        }

    }
}
