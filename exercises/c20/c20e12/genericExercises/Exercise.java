package genericExercises;

import nhUtilities.containers.*;
import java.util.Comparator;

public class Exercise {

    public static <E> List<E> lessThan (List<? extends E> list,
        E e, Comparator<? super E> order) {
        DefaultList<E> result = new DefaultList<E>();

        for (int i = 0; i < list.size(); i = i+1)
            if (order.compare(list.get(i),e) < 0)
                result.add(list.get(i));

        return result;
    }
}
