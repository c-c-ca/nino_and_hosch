package cardGame;

import java.util.Comparator;

public class ArrayUtilities {

    /**
     * Sort the specified List using selection sort.
     * @ensure
     *    for all indexes i, j:
     *       compare(arr[i],arr[j]) < 0 implies i < j.
     */
    public static <Element> void selectionSort (
        Object[] arr, Comparator<Element> order) {
        int first;    // index of first element to consider
                      // on this step
        int last;     // index of last element to consider
                      // on this step
        int small;    // index of smallest of
                      // arr[first]...arr[last]
        last = arr.length - 1;
        first = 0;
        while (first < last) {
            small = smallestOf(arr, first, last, order);
            interchange(arr, first, small);
            first = first+1;
        }
    }

    /**
     * Index of the smallest of
     * arr[first] through arr[last]
     * @require 0 <= first && first <= last &&
     *    last < arr.length
     * @ensure
     *    for all i: first <= i && i <= last implies
     *       compare(arr[result],arr[i]) <= 0
     */
    private static <Element> int smallestOf (
        Object[] arr, int first, int last,
        Comparator<Element> order) {
        int next;        // index of next element to examine.
        int small;       // index of the smallest of
                         // arr[first]...arr[last]
        small = first;
        next = first+1;
        while (next <= last) {
            if (order.compare(
                (Element)arr[next],(Element)arr[small]) < 0)
                small = next;
            next = next+1;
        }
        return small;
    }

    /**
     * Interchange arr[i] and arr[j]
     * @require     0 <= i < arr.length && 0 <= j < arr.length
     * @ensure
     *    list.old[i].equals(arr[j])
     *    list.old[j].equals(arr[i])
     */
    private static <Element> void interchange (Object[] arr,
        int i, int j) {
        Element temp = (Element)arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
