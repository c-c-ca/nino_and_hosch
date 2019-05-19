package recursionExercises;

public class Exercise {

    public static boolean palindrome (String s) {
        return palindrome(s,0,s.length()-1);
    }

    private static boolean palindrome (String s,
        int i, int j) {
        if (i < j)
            if (s.charAt(i) != s.charAt(j))
                return false;
            else
                return palindrome(s,i+1,j-1);
        else
            return true;
    }
}
