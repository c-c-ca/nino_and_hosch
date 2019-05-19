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
    public static <Element> List<Element> merge (
        List<Element> list1, List<Element> list2,
        Comparator<Element> order) {
        List<Element> newList =
            new DefaultList<Element>();
        Iterator newListIterator = newList.iterator();
        Iterator i1 = list1.iterator();
        Iterator i2 = list2.iterator();
        i1.reset();
        i2.reset();
        while (!i1.done() && !i2.done()) {
            Element e1 = (Element)i1.get();
            Element e2 = (Element)i2.get();
            if (order.compare(e1,e2) < 0) {
                newList.add(newListIterator,e1);
                i1.advance();
            } else {
                newList.add(newListIterator,e2);
                i2.advance();
            }
            newListIterator.advance();
        }
        Iterator i = i1.done() ? i2 : i1;
        while (!i.done()) {
            newList.add(newListIterator,(Element)i.get());
            i.advance();
            newListIterator.advance();
        }
        return newList;
    }

}
