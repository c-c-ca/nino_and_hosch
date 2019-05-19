package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static <Type> void arrayToList (
        Type[] s, List<? super Type> d) {
        for (int i = 0; i < s.length; i = i+1)
            d.add(i,s[i]);
    }

    public static void listToArray (List<?> s, Object[] d) {
        for (int i = 0; i < s.size(); i = i+1)
            d[i] = s.get(i);
    }
}
