package recursionExercises;

import java.util.Comparator;
import nhUtilities.containers.*;

public class InsertionSort<Element> {

    /**
     * Sort the specified List using insertion sort.
     */
    public static <Element> void sort (
        List<Element> list, Comparator<Element> order) {
        sort(list,order,1);
    }

    public static <Element> void sort (
        List<Element> list, Comparator<Element> order, int last) {
        if (last < list.size()) {
            insert(list,order,last);
            sort(list,order,last+1);
        }
    }

    private static <Element> void insert (
        List<Element> list, Comparator<Element> order, int last) {
            Element e;
            int pos, i;

            e = list.get(last);
            for (i = last-1; i >= 0 &&
                order.compare(e, list.get(i)) < 0; i = i-1) {
                list.set(i+1, list.get(i));
            }
            list.set(i+1,e);
        }
}
