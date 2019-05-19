package ioExercises;

import java.io.*;

public class Exercise {

    private static final int ATTEMPTS = 3;

    public static void main (String[] argv) {
        int tryNumber = 0;
        SimpleInput input = new SimpleInput();
        while (tryNumber < ATTEMPTS) {
            tryNumber = tryNumber + 1;
            try {
                int i = input.readInt();
                System.out.println(i);
            } catch (IOException e) {
                System.out.println(
                    "An error occurred: " + e);
            }
        }
    }
}
