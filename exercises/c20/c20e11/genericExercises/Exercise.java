package genericExercises;

import nhUtilities.containers.List;
import java.util.*;

public class Exercise {

    public static <E> E min (
        List<? extends E> list, Comparator<? super E> order) {
        E small, next;

        small = list.get(0);
        for (int i = 1; i < list.size(); i =i+1) {
            next = list.get(i);
            if (order.compare(next,small) < 0)
                small = next;
        }
        return small;
    }
}
