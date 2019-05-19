package iteratorExercises;

import nhUtilities.containers2.List;
import nhUtilities.containers2.DefaultList;
import nhUtilities.containers2.Iterator;
import java.util.Comparator;

public class Exercise {


    /**
     * Merge the specified Lists.
     * @require    list1 and list2 are ordered.
     * @ensure     merge(list1, list2) is ordered.
     */
    public static <Element> List<Element> concatenate (
        List<Element> list1, List<Element> list2) {
        List<Element> newList = new DefaultList<Element>();
        Iterator<Element> newListIterator = newList.iterator();
        newListIterator.reset();
        Iterator i;
        int count = 0;
        while (count != 2) {
            count = count + 1;
            if (count == 1)
                i = list1.iterator();
            else
                i = list2.iterator();
            i.reset();
            while (!i.done()) {
                newList.add(newListIterator,(Element)i.get());
                newListIterator.advance();
                i.advance();
            }
        }
        return newList;
    }

}
