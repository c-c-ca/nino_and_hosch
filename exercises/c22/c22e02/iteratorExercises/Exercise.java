package iteratorExercises;

import nhUtilities.containers2.*;

public class Exercise {

    private final static int WHICH = 2;

    public static <Element> void reverse (
        DoublyLinkedList<Element> list) {
        if (WHICH == 1)
            reverse1(list);
        else
            reverse2(list);
    }

    public static <Element> void reverse1 (
        DoublyLinkedList<Element> list) {
        BiDirectionalIterator<Element> first, last;

        first = list.iterator();
        first.reset();
        last = (BiDirectionalIterator)first.clone();

        while (!last.done())
            last.advance();

        boolean done = first.equals(last);
        while (!done) {
            last.backup();
            interchange(list,first,last);
            done = first.equals(last);
            first.advance();
            done = done || first.equals(last);
        }
    }

    public static <Element> void reverse2 (
        DoublyLinkedList<Element> list) {
        BiDirectionalIterator<Element> first, last;

        first = list.iterator();
        while (!first.offLeft())
            first.backup();

        last = list.iterator();
        while (!last.offRight())
            last.advance();

        for (int n = list.size()/2; n > 0; --n) {
            first.advance();
            last.backup();
            interchange(list,first,last);
        }
    }

    private static <Element> void interchange (List<Element> list,
        Iterator<Element> first, Iterator<Element> second) {
        Element temp = first.get();
        list.set(first, second.get());
        list.set(second, temp);
    }
}
