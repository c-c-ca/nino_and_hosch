package recursionExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static <Element> void reverse (
        List<Element> list) {
        reverse(list,0,list.size()-1);
    }

    private static <Element> void reverse (
        List<Element> list, int i, int j) {
        if (i < j) {
            Element temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            reverse(list,i+1,j-1);
        }
    }
}
