package headers;

import nhUtilities.containers.List;
import nhUtilities.containers.AbstractList;

/**
 * A singly-linked list with header
 */
public class LinkedList<Element> extends AbstractList<Element> {

  private int size;
  private Node head;

  public LinkedList () {
    size = 0;
    head = new Node(null);  // the header
  }

  public int size () {
    return size;
  }

  public Element get (int index) {
    Node p = getNode(index);
    return p.element;
  }

  public int indexOf (Element element) {
    Node p = head.next;
    int pos = 0;
    while (p != null && !element.equals(p.element)) {
      p = p.next;
      pos = pos+1;
    }
    if (p == null)
      return -1;
    else
      return pos;
  }

  public void add (int index, Element element) {
    Node newNode = new Node(element);
    Node p = getNode(index-1);
    newNode.next = p.next;
    p.next = newNode;
    size = size + 1;
  }

  public void set (int index, Element element) {
    Node p = getNode(index);
    p.element = element;
  }

  public void remove (int index) {
    Node p = getNode(index-1);
    p.next = p.next.next;
    size = size - 1;
  }

  public void remove (Element element) {
    Node p = find(element);
    if (p != null) {
      p.next = p.next.next;
      size = size - 1;
    }
  }

  public List<Element> copy () {
    LinkedList<Element> theCopy = new LinkedList<Element>();
    theCopy.size = this.size;
    Node p = head;
    Node cp = theCopy.head;
    while (p.next != null) {
      cp.next = new Node(p.next.element);
      p = p.next;
      cp = cp.next;
    }
    return theCopy;
  }

  private Node getNode (int i) {
    Node p = head;
    int pos = -1;     // p is the pos-th Node
    while (pos != i) {
      p = p.next;
      pos = pos + 1;
    }
    return p;
  }

  private Node find (Element element) {
    Node p = head;

    while (p.next != null && !element.equals(p.next.element))
      p = p.next;

    if (p.next == null)
      return null;
    else
      return p;
  }

  /**
   * A list Node.
   */
  private class Node {

    private Element element;
    private Node next;

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
