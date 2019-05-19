package recursionExercises;

public class Exercise {

    public static String reverse (String s) {
        return reverse(s,0,s.length()-1);
    }

    private static String reverse (String s, int i, int j) {
        if (i < j)
            return s.charAt(j) + reverse(s,i+1,j-1) + s.charAt(i);
        else if (i == j)
            return String.valueOf(s.charAt(i));
        else
            return "";
    }
}
