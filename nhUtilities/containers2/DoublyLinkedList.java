package nhUtilities.containers2;

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
   * <p>
   * Note: provides a <code>BiDirectionalIterator</code>.
   */
  public nhUtilities.containers2.BiDirectionalIterator<Element> iterator () {
    return new LocalIterator();
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
   * @ensure     if <code>this.indexOf(element) &gt;= 0<br>
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
   * @ensure     <code>this.size() == old.size() + 1<br>
   *             this.get(index).equals(element)</code><br>
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
   * @require    <code>iterator.traverses(this) &amp;&amp; element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>!iterator.done()</code><br>
   *             <code>iterator.get().equals(element)</code><br>
   *             if <code>!old.iterator().done()</code> then<br>
   *             <code>&nbsp;&nbsp;(iterator.advance(); iterator.get()).equals(old.iterator.get())</code>
   */
  public void add (Iterator<Element> iterator, Element element) {
    LocalIterator it = (LocalIterator)iterator;
    Node newNode = new Node(element);
    insertBefore(newNode,it.current);
    it.current = newNode;
    it.offRight = it.offLeft = false;
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
   * {@inheritDoc}
   * @require    <code>iterator.traverses(this) &amp;&amp; !iterator.done() &amp;&amp; element != null</code>
   * @ensure     <code>this.get(iterator).equals(element)</code>
   */
  public void set (Iterator<Element> iterator, Element element) {
    ((LocalIterator)iterator).current.element = element;
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
   *             &<code>nbsp;&nbsp;this.get(j).equals(old.get(j+1))</code>
   */
  public void remove (int index) {
    Node p = getNode(index);
    removeNode(p);
    size = size - 1;
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>iterator.traverses(this) &amp;&amp; !iterator.done()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             if <code>!iterator.done()<br>
   *             &nbsp;&nbsp;iterator.get().equals(old.iterator.advance(); old.iterator.get()))</code>
   */
  public void remove (Iterator<Element> iterator) {
    assert !iterator.done() : "Remove element with done iterator";
    LocalIterator it = (LocalIterator)iterator;
    Node remove = it.current;
    it.current = it.current.next;
    removeNode(remove);
    it.offRight = it.current == head;
    size = size - 1;
    if (size == 0) it.offLeft = true;
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
   * An Iterator for a DoublyLinkedList.
   */
  private class LocalIterator extends AbstractIterator<Element> implements nhUtilities.containers2.BiDirectionalIterator<Element> {
    
    Node current;
    boolean offRight;
    boolean offLeft;

    /**
     * Create a new iterator for this DoublyLinkedList.
     */
    public LocalIterator () {
      reset();
    }
    
    /**
     * Initialize this Iterator to reference the first element.
     */
    public void reset () {
      current = DoublyLinkedList.this.head.next;
      offRight = current == DoublyLinkedList.this.head; // true if list is empty
      offLeft = offRight;
    }

    /**
     * Advance this Iterator to the next element.
     * @require    !this.offRight()
     */
    public void advance () {
      assert !offRight : "Advance iterator that is offRight";
      current = current.next;
      if (offLeft) offLeft = current == DoublyLinkedList.this.head;
      offRight = current == DoublyLinkedList.this.head;
    }

    /**
     * Move this Iterator back to previous element.
     * @require    !this.offLeft()
     */
    public void backup () {
      assert !offLeft : "Backup iterator that is offLeft";
      current = current.previous;
      if (offRight) offRight = current == DoublyLinkedList.this.head;
      offLeft = current == DoublyLinkedList.this.head;
    }

    /**
     * This Iterator has been advance'd past the last element or the container is empty.
     * this.done() == this.offRight()
     */
    public boolean done () {
      return offRight;
    }

    /**
     * This Iterator has been advance'd past the last element,
     * or the container is empty.
     */
    public boolean offRight () {
      return offRight;
    }

    /**
     * This Iterator has been backup'ed past the first element,
     * or the container is empty.
     */
    public boolean offLeft () {
      return offLeft;
    }

    /**
     * Container element this Iterator currently references.
     * @require    !DoublyLikedList.this.isEmpty()
     */
    public Element get () {
      return current.element;
    }

    /**
     * The specified Object is a DoublyLinkedListIterator,
     * and references the same relative item of the same container.
     */
    public boolean equals (Object obj) {
      if (obj instanceof DoublyLinkedList<?>.LocalIterator)
        return this.current == ((LocalIterator)obj).current;
      else
        return false;
    }

    /**
     * This Iterator traverses the specified container.
     */
    public boolean traverses (Object container) {
      return container == DoublyLinkedList.this;
    }

    /**
     * Set this Iterator to reference the same container element as the speciifed
     * Iterator. Both Iterators must traverse the same container.
     * @require    this.traverses(container) implies other.traverses(container)
     * @ensure     this.equals(other)
     */
    public void setEqualTo (Iterator<Element> other) {
      this.current = ((LocalIterator)other).current;
      this.offRight = ((LocalIterator)other).offRight;
      this.offLeft = ((LocalIterator)other).offLeft;
    }
    
  } // end of class LocalIterator

}
