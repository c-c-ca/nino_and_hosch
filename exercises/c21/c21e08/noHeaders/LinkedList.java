package noHeaders;

import nhUtilities.containers.List;
import nhUtilities.containers.AbstractList;

public class LinkedList<Element> extends AbstractList<Element> {

    // Private components:

    private int size;
    private Node first;

    // Constructors:

    /**
     * Create an empty LinkedList<Element>.
     */
    public LinkedList () {
        size = 0;
        first = null;
    }

    public int size () {
        return size;
    }

    /**
     * The i-th node of this LinkedList. That is, the node
     * with index i. The LinkedList must be non-empty.
     * @require    0 <= i && i < this.size()
     */
    private Node getNode (int i) {
        Node p = first;
        int pos = 0;  // p is the pos-th Node
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public Element get (int index) {
        Node p = getNode(index);
        return p.element;
    }

    public void remove (int index) {
        if (index == 0)
            first = first.next;
        else {
            Node p = getNode(index-1);
            p.next = p.next.next;
        }
        size = size - 1;
    }

    public void remove (Element element) {
        boolean found = false;

        if (first != null && element.equals(first.element)) {
            first = first.next;
            found = true;
        } else {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
                found = true;
            }
        }

        if (found)
            size = size - 1;
    }

    public void removeAll (Element element) {
        int sizeBefore;

        do {
            sizeBefore = size;
            remove(element);
        } while (sizeBefore > size);
    }

    public void add (int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next= newNode;
        }
        size = size + 1;
    }

    public void add(Element element) {
        add(this.size(),element);
    }

    public void set (int index, Element element) {
        Node p = getNode(index);
        p.element = element;
    }

    public List<Element> copy () {
        LinkedList<Element> theCopy = new LinkedList<Element>();
        Node p, cp, newNode;

        theCopy.size = size;
        p = first;
        cp = null;
        while (p != null) {
            newNode = new Node(p.element);
            if (cp == null)
                theCopy.first = newNode;
            else
                cp.next = newNode;
            cp = newNode;
            p = p.next;
        }
        return theCopy;
    }

    private Node find (Element element) {
        Node p = null;

        if (first != null) {
            p = first;
            while (p.next != null &&
                   !element.equals(p.next.element))
                p = p.next;

            if (p.next == null)
                p = null;
        }

        return p;
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
} // end of class LinkedList
