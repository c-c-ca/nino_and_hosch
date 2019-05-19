package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static <Element> List<Element> nCopies (
        int n, Element obj) {

        List<Element> theList = new DefaultList<Element>();
        for (int i = 0; i < n; i = i+1)
            theList.add(obj);

        return theList;
    }
}
