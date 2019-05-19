package linked;

public class CircularList<Element> {

    // Private components:

    private Node current;
    private int size;

    // Constructors:

    public CircularList () {
        this.current = null;
        this.size = 0;
    }

    // Queries:

    public Element get () {
        if (current != null)
            return current.element;
        else
            return null;
    }

    // Commands:

    public void next () {
        if (current != null)
            current = current.next;
    }

    public void add (Element element) {
        Node p = new Node(element);
        if (current == null)
            p.next = p;
        else {
            p.next = current.next;
            current.next = p;
        }
        current = p;
        size = size + 1;
    }

    public void remove () {
        if (current != null) {
            if (current.next == current)
                current = null;
            else {
                Node p = current;
                while (p.next != current)
                    p = p.next;
                p.next = p.next.next;
                current = p;
            }
            size = size - 1;
        }
    }

    private class Node {

        Element element;
        Node next;

        /**
         * Create a Node containing the specified
         * element.
         */
        public Node (Element element) {
            this.element = element;
            this.next = null;
        }
    } // end of class Node


}
