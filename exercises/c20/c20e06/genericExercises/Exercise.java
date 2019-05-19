package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static <Element> List<Element> copyFirstN (
        int n, List<Element> list) {

        List<Element> theList = new DefaultList<Element>();
        for (int i = 0; i < n && i < list.size(); i = i+1)
            theList.add(list.get(i));

        return theList;
    }
}
