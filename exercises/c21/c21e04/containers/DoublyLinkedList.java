package containers;

import nhUtilities.containers.List;
import nhUtilities.containers.AbstractList;

public class DoublyLinkedList<Element>
    extends AbstractList<Element> {

    private int size;
    private Node header;

    public DoublyLinkedList () {
        size = 0;
        header = new Header();
        header.next = header;
        header.previous = header;
    }

    public int size () {
        return size;
    }

    public void add (Element element) {
        Node newNode = new Node(element);
        Node last = header.previous;
        newNode.previous = last;
        newNode.next = header;
        header.previous = newNode;
        last.next = newNode;
        size = size + 1;
    }

    public void add (int index, Element element) {
        Node newNode = new Node(element);
        Node p = getNode(index-1);
        newNode.previous = p;
        newNode.next = p.next;
        p.next.previous = newNode;
        p.next = newNode;
        size = size + 1;
    }

    public void remove (int index) {
        Node p = getNode(index);
        p.previous.next = p.next;
        p.next.previous = p.previous;
        size = size - 1;
    }

    public Element get (int index) {
        Node p = getNode(index);
        return p.element;
    }

    private Node getNode (int i) {
        Node p = header;
        int pos = -1;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public void set (int index, Element element) {
        Node p = getNode(index);
        p.element = element;
    }

    public List<Element> copy () {
        return null;
    }

    private class Node {

        Element element;
        Node next;
        Node previous;

        public Node (Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    } // end of class Node

    private class Header extends Node {
        public Header () {
            super(null);
        }
    }
}
