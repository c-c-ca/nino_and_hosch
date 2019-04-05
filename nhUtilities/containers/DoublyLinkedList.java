package nhUtilities.containers;

/**
 * A doubly-linked list with header.
 */
public class DoublyLinkedList<Element> extends AbstractList<Element> {

  private int size;
  private Node head;
  
  /**
   * Create an empty <code>DoublyLinkedList&lt;Element&gt;</code>.
   * @ensure     <code>this.isEmpty()</code>
   */
  public DoublyLinkedList () {
    size = 0;
    head = new Node(null);
    head.next = head;
    head.previous = head;
  }

  /**
   * {@inheritDoc}
   * @ensure     <code>this.size() &gt;= 0</code>
   */
  public int size () {
    return size;
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   */
  public Element get (int index) {
    Node p = getNode(index);
    return p.element;
  }
  
  /**
   * The index of the first occurrence of the specified element,
   * or -1 if this <code>List</code> does not contain the specified element.
   * @ensure     if <code>this.indexOf(element) &lt;= 0<br>
   *             &nbsp;&nbsp;this.get(this.indexOf(element)).equals(element)<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>: <code>j &lt; this.indexOf(element)</code> implies<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code><br>
   *             if <code>this.indexOf(element) == -1<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code>
   */
  public int indexOf (Element element) {
    Node p = head.next;
    int pos = 0;
    while (p != head && !element.equals(p.element)) {
      p = p.next;
      pos = pos+1;
    }
    if (p == head)
      return -1;
    else
      return pos;
  }
  
  /**
   * Append the specified <code>Element</code> to the end of this <code>List</code>.<br>
   * Equivalent to <code>this.add(this.size(),element)</code>.
   * @require    <code>element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>this.get(this.size()-1).equals(element)</code>
   */
  public void add (Element element) {
    insertBefore(new Node(element),head);
    size = size + 1;
  }

  /**
   * {@inheritDoc}
   * @require    <code>element != null</code><br>
   *             <code>0 &lt;= index &amp;&amp; index &lt;= this.size()</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>this.get(index).equals(element)</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; old.size()</code> implies<br>
   *             <code>&nbsp;&nbsp;old.get(j).equals(this.get(j+1))</code>
   */
  public void add (int index, Element element) {
    Node p = getNode(index);
    insertBefore(new Node(element),p);
    size = size + 1;
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>element != null</code><br>
   *             <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.get(index).equals(element)</code>
   */
  public void set (int index, Element element) {
    Node p = getNode(index);
    p.element = element;
  }
  
  /**
   * Remove the first occurrence of the specified <code>Element</code> from this <code>List</code>.
   * Has no effect if the <code>Element</code> is not contained in this <code>List</code>.
   */
  public void remove (Element element) {
    Node p = getNode(element);
    if (p != head) {
      removeNode(p);
      size = size - 1;
    }
  }

  /**
   * Remove the element with the specified index.
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; this.size()</code> inmplies<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(old.get(j+1))</code>
   */
  public void remove (int index) {
    Node p = getNode(index);
    removeNode(p);
    size = size - 1;
  }
  
  /**
   * A copy of this List.
   * @ensure     <code>this.copy() != this</code><br>
   *             <code>this.copy().size() == this.size()</code><br>
   *             for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(this.copy().get(j))</code>
   */
  public List<Element> copy () {
    DoublyLinkedList<Element> theCopy = new DoublyLinkedList<Element>();
    Node p = this.head.next;
    while (p != head) {
      theCopy.add(p.element);
      p = p.next;
    }
    return theCopy;
  }
  
  /**
   * {@inheritDoc}
   */
  public java.util.Iterator<Element> iterator () {
    return new LinkedIterator();
  }
  
  /**
   * String representation of this <code>List</code>.
   */
  public String toString () {
    String s = "[";
    Node p = head.next;
    if (p != head) {
      s = s + p.element.toString();
      for (p = p.next; p != head; p = p.next)
        s = s + ", " + p.element.toString();
    }
    s = s + "]";
    return s;
  }

  /**
   * The node containing the element with the specified index.
   * The head node if the specified index is -1.
   * @require    -1 &lt;= i &amp;&amp; i &lt; this.size()
   */
  private Node getNode (int i) { 
    Node p = head;
    int pos = -1;
    while (pos < i) {
      p = p.next;
      pos = pos + 1;
    }
    return p;
  }
      
  /**
   * The node containing the first occurance of the specified element.
   * The head node if the specified element is not on the list.
   */
  private Node getNode (Element e) { 
    Node p = head.next;
    while (p != head && !p.element.equals(e))
      p = p.next;
    return p;
  }

  /**
   * Insert newNode in front of the Node p.
   */
  private void insertBefore (Node newNode, Node p) {
    newNode.next = p;
    newNode.previous = p.previous;
    newNode.next.previous = newNode;
    newNode.previous.next = newNode;
  }

  /**
   * Remove the specified Node.
   */
  private void removeNode (Node remove) {
    remove.next.previous = remove.previous;
    remove.previous.next = remove.next;
  }
  
  /**
   * A list Node.
   */
  private class Node {
    
    /**
     * Create a Node containing the specified
     * element.
     */
    public Node (Element element) {
      this.element = element;
      this.next = null;
      this.previous = null;
    }
    
    private Element element;
    private Node next;
    private Node previous;
    
  } // end of class Node
  
  /**
   * An iterator for this list.  This class is only to
   * support the "extended <code>for</code> loop semantics."
   */
  private class LinkedIterator implements java.util.Iterator<Element> {
    
    private Node current; // the Node preceding the "current" one.

    /**
     * Create a new iterator for this LinkedList.
     */
    public LinkedIterator () {
      this.current = head;
    }
    
    /**
     * There are more elements to be seen.
     */
    public boolean hasNext () {
      return current.next != head;
    }
    
    /**
     * Return the current element and advance to the next.
     * @require    <code>this.hasNext()</code>
     */
    public Element next () {
      current = current.next;
      return current.element;
    }
    
    /**
     * Throw <code>UnsupportedOperationException</code>. (Removal with this
     * iterator is not allowed.)
     */
    public void remove () {
      throw new UnsupportedOperationException(
        "nhUtilities.containers.Iterator.remove())");
    }
  } // end of class LinkedIterator
}
