package nhUtilities.containers2;

/**
 * A singly-linked list with header
 */
public class LinkedList<Element> extends AbstractList<Element> {
  
  private int size;
  private Node head;

  /**
   * Create an empty <code>LinkedList&lt;Element&gt;</code>.
   * @ensure    <code>this.isEmpty()</code>
   */
  public LinkedList () {
    size = 0;
    head = new Node(null);  // the header
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
   */
  public Iterator<Element> iterator () {
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
    while (p != null && !element.equals(p.element)) {
      p = p.next;
      pos = pos+1;
    }
    if (p == null)
      return -1;
    else
      return pos;
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
    Node newNode = new Node(element);
    Node p = getNode(index-1);
    newNode.next = p.next;
    p.next = newNode;
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
    LocalIterator i = (LocalIterator)iterator;
    Node newNode = new Node(element);
    newNode.next = i.previous.next;
    i.previous.next = newNode;
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
    LocalIterator i = (LocalIterator)iterator;
    i.previous.next.element = element;
  }
    
  /**
   * {@inheritDoc}
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; this.size()</code> inmplies<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(old.get(j+1))</code>
   */
  public void remove (int index) {
    Node p = getNode(index-1);
    p.next = p.next.next;
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
    LocalIterator i = (LocalIterator)iterator;
    i.previous.next = i.previous.next.next;
  }
    
  /**
   * {@inheritDoc}
   * @ensure     <code>this.copy() != this</code><br>
   *             <code>this.copy().size() == this.size()</code><br>
   *             for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(this.copy().get(j))</code>
   */
  public List<Element> copy () {
    LinkedList<Element> theCopy = new LinkedList<Element>();
    theCopy.size = this.size;
    Node p = head;
    Node cp = theCopy.head;
    while (p != null) {
      cp.next = new Node(p.next.element);
      p = p.next;
      cp = cp.next;
    }
    return theCopy;
  }
  
  /**
   * The i-th node of this LinkedList.
   * Returns the header if i is -1.
   * @require     -1 &lt;= i &amp;&amp; i &lt; this.size()
   */
  private Node getNode (int i) {
    Node p = head;
    int pos = -1;     // p is the pos-th Node
    while (pos != i) {
      p = p.next;
      pos = pos + 1;
    }
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
  
  /**
   * An Iterator for a LinkedList.
   */
  private class LocalIterator extends AbstractIterator<Element> {
    
    private Node previous;   // the Node preceding the current Element.
    
    /**
     * Create a new Iterator for this LinkedList.
     */
    public LocalIterator () {
      reset();
    }
    
    /**
     * Initialize this Iterator to reference the first element.
     */
    public void reset () {
      previous = LinkedList.this.head;
    }
    
    /**
     * Advance this Iterator to next element.
     * @require    !this.done()
     */
    public void advance () {
      previous = previous.next;
    }
    
    /**
     * No more elements to traverse in the container.
     */
    public boolean done () {
      return previous.next == null;
    }
    
    /**
     * Container element this Iterator currently references.
     * @require    !this.done()
     */
    public Element get () {
      return previous.next.element;
    }
    
    /**
     * The specified Object is an Iterator of the same class
     * as this, and references the same relative element of the same container.
     */
    public boolean equals (Object obj) {
      if (obj instanceof LinkedList<?>.LocalIterator) {
        LocalIterator i = (LocalIterator)obj;
        return this.previous == i.previous;
      } else
        return false;
    }
    
    /**
     * This Iterator traverses the specified container.
     */
    public boolean traverses (Object container) {
      return container == LinkedList.this;
    }
    
    /**
     * Set this Iterator to reference the same container element as the speciifed
     * Iterator. Both Iterators must traverse the same container.
     * @require    this.traverses(container) implies other.traverses(container)
     * @ensure     this.equals(other)
     */
    public void setEqualTo (Iterator<Element> other) {
      this.previous = ((LocalIterator)other).previous;
    }
    
  } // end of class LinkedList.Iterator
  
}
