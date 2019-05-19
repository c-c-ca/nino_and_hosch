package maps;

import nhUtilities.containers.*;
import java.util.*;

public class KeyValueTableUtilities {

    public static <Key, Entry extends Keyed<Key>>
        void tableSort (KeyValueTable<Key,Entry> table,
                        Comparator<? super Key> order) {
        int first, last, small;

        last = table.size() - 1;
        first = 0;
        while (first < last) {
            small = smallestOf(table, first, last, order);
            interchange(table, first, small);
            first = first+1;
        }
    }

    private static <Key, Entry extends Keyed<Key>>
        int smallestOf (KeyValueTable<Key,Entry> table,
                        int first, int last,
                        Comparator<? super Key> order) {
        int next, small;

        small = first;
        next = first+1;
        while (next <= last) {
            if (order.compare(
                table.get(next).getKey(),table.get(small).getKey()) < 0)
                small = next;
            next = next+1;
        }
        return small;
    }

    private static <Key, Entry extends Keyed<Key>>
        void interchange (KeyValueTable<Key,Entry> table,
                          int i, int j) {
        Entry temp = table.get(i);
        table.set(i, table.get(j));
        table.set(j, temp);
    }
}
