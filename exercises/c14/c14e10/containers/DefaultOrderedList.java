package containers;

import java.util.Comparator;

import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;
import nhUtilities.containers.OrderedList;
import nhUtilities.containers.AbstractOrderedList;


public class DefaultOrderedList<Element> extends AbstractOrderedList<Element>
    implements OrderedList<Element> {

        // Private components:

        private List<Element> list;

        // Constructors:

        /**
         * Create a new DefaultOrderedList<Element>, ordered
         * by the specified Comparator.
         * @ensure     this.isEmpty()
         */
        public DefaultOrderedList (Comparator<Element> order) {
            super(order);
            this.list = new DefaultList<Element>();
        }

        public int size () {
            return list.size();
        }

        public Element get (int index) {
            return list.get(index);
        }

        public void add (Element e) {
            int i;
            for (i = 0; i < list.size() &&
                 order.compare(list.get(i),e) < 0; ++i)
                ;
            list.add(i,e);
        }

        public void remove (int index) {
            list.remove(index);
        }

        public OrderedList<Element> copy () {
            OrderedList theList =
                new DefaultOrderedList<Element>(ordering());
            for (int i = 0; i < size(); ++i)
                theList.add(get(i));
            return theList;
        }


    }
