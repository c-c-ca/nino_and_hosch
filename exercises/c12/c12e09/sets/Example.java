package sets;

import nhUtilities.containers.*;

public class Example {

    private static List<Integer> makeList (int i1, int i2, int i3,
                                    int i4, int i5, int i6) {
        Integer item;
        List<Integer> list = new DefaultList<Integer>();
        item = Integer.valueOf(i1);
        list.add(item);
        item = Integer.valueOf(i2);
        list.add(item);
        item = Integer.valueOf(i3);
        list.add(item);
        item = Integer.valueOf(i4);
        list.add(item);
        item = Integer.valueOf(i5);
        list.add(item);
        item = Integer.valueOf(i6);
        list.add(item);
        return list;
    }

    public static void main (String[] argv) {
        List<Integer> l1, l2;
        Set<Integer> set1, set2;
        l1 = makeList(5,2,34,14,4,5);
        l2 = makeList(2,34,14,5,4,3);
        set1 = new Set<Integer>(l1);
        set2 = new Set<Integer>(l2);
        set2.remove(3);
        set2.remove(4);
        // set1.remove(34);
        System.out.println("Set #1: " + set1);
        System.out.println("Set #2: " + set2);
        System.out.println(
            "Set #2 is a subset of Set #1: " + set2.isSubSetOf(set1));

    }
}
