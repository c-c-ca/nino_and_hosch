package containers;

import nhUtilities.containers.*;

public class Example {
    private static void printIndexOf (List<Integer> list, int i) {
        System.out.println(list);
        System.out.println(
            "index of " + i + ": " + list.indexOf(i));
    }

    public static void main (String[] argv) {
        List<Integer> list =
            new ModifiedDefaultList<Integer>();
        list.add(Integer.valueOf(5));
        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(9));
        printIndexOf(list,3);
    }
}
