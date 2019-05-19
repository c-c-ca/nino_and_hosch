package ioExercises;

import java.io.*;

public class Exercise {

    private static final int ATTEMPTS = 3;

    public static void main (String[] argv) {
        int tryNumber = 0;
        SimpleScanner scanner = new SimpleScanner();
        while (tryNumber < ATTEMPTS) {
            tryNumber = tryNumber + 1;
            try {
                scanner.readInt();
                int i = scanner.lastInt();
                System.out.println(i);
            } catch (IOException e) {
                System.out.println(
                    "An error occurred: " + e);
            }
        }
    }
}
