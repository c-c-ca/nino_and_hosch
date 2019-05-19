package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static void reverse (List<?> list) {
        reverseImp(list,0,list.size()-1);
    }

    private static <Type> void reverseImp (
        List<Type> list, int i, int j) {
        if (i < j) {
            Type temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            reverseImp(list,i+1,j-1);
        }
    }
}
