package sorts;

import java.util.Comparator;
import nhUtilities.containers2.*;

public class SelectionSort<Element> {

    /**
     * Sort the specified List using selection sort.
     */
    public static <Element> void sort (
        List<Element> list, Comparator<Element> order) {
        Iterator<Element> first, small;

        first = list.iterator();
        first.reset();
        small = (Iterator)first.clone();
        while (!first.done()) {
            small.setEqualTo(first);
            small.advance();
            while (!small.done()) {
                if (order.compare(small.get(),first.get()) < 0)
                    interchange(list, first, small);
                small.advance();
            }
            first.advance();
        }
    }

    private static <Element> void interchange (List<Element> list,
        Iterator<Element> first, Iterator<Element> small) {
        Element temp = first.get();
        list.set(first, small.get());
        list.set(small, temp);
    }
}
