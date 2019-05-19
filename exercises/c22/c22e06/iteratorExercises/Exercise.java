package iteratorExercises;

import nhUtilities.containers2.*;

public class Exercise {

    public static <Element> boolean isPalindrome (
        DoublyLinkedList<Element> list) {
        BiDirectionalIterator<Element> first, last;

        first = list.iterator();
        while (!first.offLeft())
            first.backup();

        last = list.iterator();
        while (!last.offRight())
            last.advance();

        first.advance();
        last.backup();
        int n = list.size()/2;
        while (n > 0 && first.get().equals(last.get())) {
            first.advance();
            last.backup();
            n = n - 1;
        }

        return n == 0;
    }
}
