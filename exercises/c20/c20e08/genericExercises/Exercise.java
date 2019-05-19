package genericExercises;

import nhUtilities.containers.*;

public class Exercise {

    public static <E1,E2> List<Pair2<E1,E2>> pairEach (
        List<E1> l1, List<E2> l2) {

        List<Pair2<E1,E2>> theList =
            new DefaultList<Pair2<E1,E2>>();
        for (int i = 0; i < l1.size() && i < l2.size(); i = i+1)
            theList.add(new Pair2(l1.get(i),l2.get(i)));

        return theList;
    }
}
