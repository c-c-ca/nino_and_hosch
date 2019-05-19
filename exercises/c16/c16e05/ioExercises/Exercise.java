package ioExercises;

import java.io.*;

public class Exercise {

    private static final int INT = 0;
    private static final int DOUBLE = 1;
    private static final int CHAR = 2;
    private static final int STR = 3;

    private static final int MODE = STR;

    public static void main (String[] argv) {
        try {
            SimpleInput input = new SimpleInput();
            switch (MODE) {
            case INT:
                int i = input.readInt();
                System.out.println(i);
                break;
            case DOUBLE:
                double d = input.readDouble();
                System.out.println(d);
                break;
            case CHAR:
                char c = input.readChar();
                System.out.println(c);
                break;
            case STR:
                String s = input.readString();
                System.out.println(s);
                break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
