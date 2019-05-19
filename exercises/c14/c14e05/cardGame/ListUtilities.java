package cardGame;

import java.util.Comparator;
import nhUtilities.containers.*;

public class ListUtilities<Element> {

    /**
     * Sort the specified List using selection sort.
     * @ensure
     *    for all indexes i, j:
     *       compare(list.get (i),list.get(j)) < 0 implies i < j.
     */
    public static <Element> void selectionSort (
        List<Element> list, Comparator<Element> order) {
        int first;    // index of first element to consider
                      // on this step
        int last;     // index of last element to consider
                      // on this step
        int small;    // index of smallest of
                      // list.get(first)...list.get(last)
        last = list.size() - 1;
        first = 0;
        while (first < last) {
            small = smallestOf(list, first, last, order);
            interchange(list, first, small);
            first = first+1;
        }
    }

    /**
     * Index of the smallest of
     * list.get(first) through list.get(last)
     * @require 0 <= first && first <= last &&
     *    last < list.size()
     * @ensure
     *    for all i: first <= i && i <= last implies
     *       compare(list.get(result),list.get(i)) <= 0
     */
    private static <Element> int smallestOf (
        List<Element> list, int first, int last,
        Comparator<Element> order) {
        int next;        // index of next element to examine.
        int small;       // index of the smallest of
                         // get(first)...get(next-1)
        small = first;
        next = first+1;
        while (next <= last) {
            if (order.compare(
                list.get(next),list.get(small)) < 0)
                small = next;
            next = next+1;
        }
        return small;
    }

    /**
     * Interchange list.get(i) and list.get(j)
     * @require     0 <= i < list.size() && 0 <= j < list.size()
     * @ensure
     *    list.old.get(i).equals(list.get(j))
     *    list.old.get(j).equals(list.get(i))
     */
    private static <Element> void interchange (List<Element> list,
        int i, int j) {
        Element temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
