package containers;

import nhUtilities.containers.List;
import nhUtilities.containers.AbstractList;

public class LinkedList<Element> extends AbstractList<Element> {

    // Private components:

    private int size;
    private Node last;

    // Constructors:

    /**
     * Create an empty LinkedList<Element>.
     */
    public LinkedList () {
        size = 0;
        last = null;
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
        Node p = last;
        int pos = size-1;  // p is the pos-th Node
        while (pos != i) {
            p = p.previous;
            pos = pos - 1;
        }
        return p;
    }

    public Element get (int index) {
        Node p = getNode(index);
        return p.element;
    }

    public void remove (int index) {
        if (index == size)
            last = last.previous;
        else {
            Node p = getNode(index+1);
            p.previous = p.previous.previous;
        }
        size = size - 1;
    }

    public void add (int index, Element element) {
        Node newNode = new Node(element);
        if (index == size) {
            newNode.previous = last;
            last = newNode;
        } else {
            Node p = getNode(index);
            newNode.previous = p.previous;
            p.previous= newNode;
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
        return null;
    }

    private class Node {

        Element element;
        Node previous;

        /**
         * Create a Node containing the specified
         * element.
         */
        public Node (Element element) {
            this.element = element;
            this.previous = null;
        }
    } // end of class Node
} // end of class LinkedList
