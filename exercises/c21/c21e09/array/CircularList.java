package array;

public class CircularList<Element> {

    // Named constants:

    private final static int SIZE = 2;
    private final static double GROWTH_FACTOR = 1.5;

    // Private components:

    private int current;
    private int size;
    private Object[] elements;

    // Constructors:

    public CircularList () {
        this.current = -1;
        this.elements = new Object[SIZE];
    }

    // Queries:

    public Element get () {
        if (size > 0)
            return (Element)elements[current];
        else
            return null;
    }

    // Commands:

    public void next () {
        if (size > 0)
            current = (current + 1) % size;
    }

    public void add (Element element) {
        if (size == elements.length)
            grow();
        current = current + 1;
        for (int i = size; i > current; i = i-1)
            elements[i] = elements[i-1];
        elements[current] = element;
        size = size + 1;
    }

    public void remove () {
        if (size > 0) {
            for (int i = current; i < size-1; i = i+1)
                elements[i] = elements[i+1];
            size = size - 1;
            if (size != 0)
                current = (size + current - 1) % size;
            else
                current = -1;
        }
    }

    private void grow () {
        int newSize = (int) (elements.length * GROWTH_FACTOR);
        Object[] newElements = new Object[newSize];
        for (int i = 0; i < size; i = i+1)
            newElements[i] = elements[i];
        elements = newElements;
    }


}
