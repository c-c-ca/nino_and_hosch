package ioExercises;

import java.io.*;

public class Exercise {

    public static void replace (String match, String subst)
        throws IOException {
        Reader in = new InputStreamReader(System.in);
        int c, i;
        String s;

        s = "";
        i = 0;
        while ((c = in.read()) != -1) {
            if (i < match.length() && (char)c == match.charAt(i)) {
                s = s + (char)c;
                i = i+1;
            } else {
                if (i >= match.length())
                    s = subst;
                System.out.print(s + (char)c);
                i = 0;
                s = "";
            }
        }
        in.close();
    }

    public static void main (String[] argv) {
        try {
            replace("world","earth");
        } catch (IOException e) {
            System.out.println(
                "An error occurred: " + e);
        }
    }
}
