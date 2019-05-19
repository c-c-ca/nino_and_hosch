package cardGame;

import java.util.Comparator;
import nhUtilities.containers.*;

public class ListUtilities<Element> {

    /**
     * Sort the specified List using insertion sort.
     */
    public static <Element> void insertionSort (
        List<Element> list, Comparator<Element> order) {
        Element e;
        int pos, i;

        for (pos = 1; pos < list.size(); ++pos) {
            e = list.get(pos);
            for (i = pos-1; i >= 0 && order.compare(
                 e, list.get(i)) < 0; --i) {
                    list.set(i+1, list.get(i));
            }
            list.set(i+1,e);
        }
    }

    /**
     * Merge the specified Lists.
     * @require    list1 and list2 are ordered.
     * @ensure     merge(list1, list2) is ordered.
     */
    public static <Element> List<Element> merge (
        List<Element> list1, List<Element> list2,
        Comparator<Element> order) {
        List<Element> merge;
        int i, j;

        merge = new DefaultList<Element>();
        i = j = 0;
        while (i < list1.size() && j < list2.size())
            if (order.compare(list1.get(i),list2.get(j)) < 0)
                merge.add(list1.get(i++));
            else
                merge.add(list2.get(j++));

        return merge;
    }
}
