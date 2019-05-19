package genericExercises;

import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;
import java.util.*;

public class OrderedList<Type> {

    // Private components:

    private List<Type> list;
    private Comparator<? super Type> order;

    // Constructors:

    public OrderedList (List<? extends Type> source,
        Comparator<? super Type> order) {
        this.list = new DefaultList<Type>();
        this.order = order;
        for (int i = 0; i < source.size(); i = i+1)
            this.add(source.get(i));
    }

    public OrderedList (List<? extends Type> source) {
        this(source, new Comparator<Type>() {
            public int compare (Type first, Type second) {
                return ((Comparable)first).compareTo(
                        (Comparable)second);
            }
        });
    }

    public int size () {
        return list.size();
    }

    public Type get (int index) {
        return list.get(index);
    }

    public void add (Type e) {
        int i;
        for (i = 0; i < list.size() &&
             order.compare(list.get(i),e) < 0; ++i)
            ;
        list.add(i,e);
    }

    public void remove (int index) {
        list.remove(index);
    }

    public String toString () {
        return list.toString();
    }
}
