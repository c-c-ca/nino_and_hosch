package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static <Element> List<Element> removeFirstN (
        int n, List<Element> list) {

        List<Element> theList = new DefaultList<Element>();
        while (n < list.size()) {
            theList.add(list.get(n));
            n = n+1;
        }

        return theList;
    }
}
