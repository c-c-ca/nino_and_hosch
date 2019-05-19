package containers;

import nhUtilities.containers.List;

public class Exercise {

    private final static int SIZE = 10;

    public static void main (String[] argv) {
        DoublyLinkedList<Integer> list =
            new DoublyLinkedList<Integer>();
        for (int i = 0; i < SIZE; i = i+1)
            list.add(i,i);
        list.add(SIZE);
        System.out.println("List Integers 1-10:");
        System.out.println(list);
        list.add(SIZE/2,SIZE+1);
        System.out.println("Add 11 at index 5:");
        System.out.println(list);
        list.add(0,SIZE+2);
        System.out.println("Add 12 at index 0:");
        System.out.println(list);
        list.remove(0);
        System.out.println("Remove item at index 0:");
        System.out.println(list);
        list.remove(5);
        System.out.println("Remove item at index 5:");
        System.out.println(list);
        list.remove(list.size());
        System.out.println("Remove item at end of list:");
        System.out.println(list);
    }
}
