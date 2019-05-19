package containers;

import nhUtilities.containers.List;

public class Exercise {

    private final static int SIZE = 10;

    public static void main (String[] argv) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < SIZE; i = i+1)
            list.add(i);
        list.reverse();
        List<Integer> copy = list.copy();
        System.out.println(copy);
    }
}
