package sorts;

import java.util.Comparator;
import nhUtilities.containers2.*;

public class BubbleSort<Element> {

    /**
     * Sort the specified List using bubble sort.
     */
    public static <Element> void sort (
        List<Element> list, Comparator<Element> order) {
        Iterator<Element> first, second, last;

        first = list.iterator();
        first.reset();

        second = (Iterator)first.clone();

        last = (Iterator)first.clone();
        while (!last.done())
            last.advance();

        while (!first.equals(last)) {
            second.setEqualTo(first);
            second.advance();
            while (!second.equals(last)) {
                if (order.compare(second.get(),first.get()) < 0)
                    interchange(list, first, second);
                first.advance();
                second.advance();
            }
            last.setEqualTo(first);
            first.reset();
        }
    }


    private static <Element> void interchange (List<Element> list,
        Iterator<Element> first, Iterator<Element> second) {
        Element temp = first.get();
        list.set(first, second.get());
        list.set(second, temp);
    }
}
