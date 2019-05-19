package containers;

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

    public void reverse () {
        Node p, last;

        last = getNode(size-1);
        for (int i = size-1; i > 0; i = i-1) {
            p = getNode(i-1);
            p.next.next = p;
        }
        first.next = null;
        first = last;
    }

    // Implementation for LinkedList using a Header

   /** public void reverse () {
     *    Node p, last;
     *
     *    if (size > 0) {
     *        last = getNode(size-1);
     *        for (int i = size-1; i > 0; i = i-1) {
     *            p = getNode(i-1);
     *            p.next.next = p;
     *        }
     *        head.next.next = null;
     *        head.next = last;
     *    }
     * }
     */

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
