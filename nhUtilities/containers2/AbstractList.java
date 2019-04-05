package nhUtilities.containers2;

/**
 * Base class for implementing interface <code>List</code>. To complete an implementation,
 * the following methods must be implemented:
 * <pre>   public int size ()
 *   public Element get (int)
 *   public void set (int, Element)
 *   public void add (int, Element)
 *   public void remove (int)
 *   public List&lt;Element&gt; copy ()
 * </pre>
 * If the implementation is not array-based, then <code>public Iterator&lt;Element&gt; iterator ()</code>
 * should be overridden. If <code>public Iterator&lt;Element&gt; iterator ()</code> is overridden, the following
 * must also be overridden.
 * <pre>
 *   public void set (Iterator, Element)
 *   public void add (Iterator, Element)
 *   public void remove (Iterator)
 * </pre>
 */
public abstract class AbstractList<Element> implements List<Element> {
  
  /**
   * {@inheritDoc}
   */
  public Iterator<Element> iterator () {
    return new ListIterator();
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.size()</code>.
   */
  public boolean isEmpty () {
    return this.size() == 0;
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>iterator.traverses(this) &amp;&amp; !iterator.done()</code>
   */
  public Element get (Iterator<Element> iterator) {
    assert iterator.traverses(this) && !iterator.done();
    return iterator.get();
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation advances through the list with an iterator
   * until <code>element</code> is found or the iterator is done. <code>this.iterator()</code> is invoked.
   * @ensure     if <code>this.indexOf(element) &gt;= 0<br>
   *             &nbsp;&nbsp;this.get(this.indexOf(element)).equals(element)<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>: <code>j &lt; this.indexOf(element)</code> implies<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code><br>
   *             if <code>this.indexOf(element) == -1<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code>
   */
  public int indexOf (Element element) {
    Iterator<Element> i = this.iterator();
    int index = 0;
    while (!i.done() && !i.get().equals(element)) {
      i.advance();
      index = index + 1;
    }
    if (i.done())
      return -1;
    else
      return index;
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation iterates through the list using an iterator produced
   * by <code>this.iterator()</code> until element is found or the list is exhausted.
   * @require    <code>element != null</code>
   * @ensure     if <code>element</code> equals no element of this <code>List</code> then<br>
   *             <code>&nbsp;&nbsp;iteratorAt(element).done()</code><br>
   *             else<br>
   *             <code>&nbsp;&nbsp;element.equals(iteratorAt(element).get())</code>,<br>
   *             <code>&nbsp;&nbsp;</code>and <code>iteratorAt(element)</code> references the first position in<br>
   *             <code>&nbsp;&nbsp;</code>a traversal for which this is true.
   */
  public Iterator<Element> iteratorAt (Element element) {
    Iterator<Element> iterator = this.iterator();
    while (!iterator.done() && !element.equals(iterator.get()))
      iterator.advance();
    return iterator;
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.indexOf(element)</code>.
   */
  public boolean contains (Element element) {
    return this.indexOf(element) != -1;
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.add(this.size(),element)</code>.
   * @require    <code>element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>this.get(this.size()-1).equals(element)</code>
   */
  public void add (Element element) {
    this.add(this.size(),element);
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.add(element)</code> and <code>this.add(int,element)</code>.
   * It must be overridden if <code>public Iterator&lt;Element&gt; iterator ()</code> is overridden.
   * @require    <code>iterator.traverses(this) && element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>!iterator.done()</code><br>
   *             <code>iterator.get().equals(element)</code><br>
   *             if <code>!old.iterator().done()</code> then<br>
   *             <code>&nbsp;&nbsp;(iterator.advance(); iterator.get()).equals(old.iterator.get())</code>
   */
  public void add (Iterator<Element> iterator, Element element) {
    assert iterator.traverses(this);
    if (iterator.done())
      add(element);
    else {
      ListIterator i = (ListIterator)iterator;
      add(i.current,element);
    }
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.set(int,element)</code>.
   * It must be overridden if <code>public Iterator&lt;Element&gt; iterator ()</code> is overridden.
   * @require    <code>iterator.traverses(this) &amp;&amp; !iterator.done() &amp;&amp; element != null</code>
   * @ensure     <code>this.get(iterator).equals(element)</code>
   */
  public void set (Iterator<Element> iterator, Element element) {
    assert iterator.traverses(this);
    ListIterator i = (ListIterator)iterator;
    set(i.current,element);
  }    

  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.remove(int)</code>.
   */
  public void remove (Element element) {
    int index = indexOf(element);
    if (index != -1)
      this.remove(index);
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.remove(int)</code>.
   * It must be overridden if <code>public Iterator&lt;Element&gt; iterator ()</code> is overridden.
   * @require    <code>iterator.traverses(this) &amp;&amp; !iterator.done()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             if <code>!iterator.done()<br>
   *             &nbsp;&nbsp;iterator.get().equals(old.iterator.advance(); old.iterator.get()))</code>
   */
  public void remove (Iterator<Element> iterator) {
    assert iterator.traverses(this);
    ListIterator i = (ListIterator)iterator;
    remove(i.current);
  }    
    
  /**
   * String representation of this <code>List</code>.
   * <p>
   * This implementation iterates through the list using an iterator produced
   * by <code>this.iterator()</code>.
   */
  public String toString () {
    String s = "[";
    Iterator i = this.iterator();
    if (!i.done()) {
      s = s + i.get().toString();
      for (i.advance(); !i.done(); i.advance())
        s = s + ", " + i.get().toString();
    }
    s = s + "]";
    return s;
  }
  
  /**
   * An indexed-based iterator, suitable for traversing array-based lists.
   */
  private class ListIterator extends AbstractIterator<Element> {
    
    private int current;            // index into the List
    
    /**
     * Create a new iterator for this <code>AbstractList</code>.
     */
    public ListIterator () {
      this.reset();
    }
    
    /**
     * {@inheritDoc}
     */
    public void reset () {
      current = 0;
    }
    
    /**
     * {@inheritDoc}
     * @require    <code>!this.done()</code>
     */
    public void advance () {
      current = current + 1;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean done () {
      return current >= AbstractList.this.size();
    }
    
    /**
     * {@inheritDoc}
     * @require    <code>!this.done()</code>
     */
    public Element get () {
      return AbstractList.this.get(current);
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean equals (Object obj) {
      if (obj instanceof AbstractList<?>.ListIterator) {
        ListIterator other = (ListIterator)obj;
        return this.current == other.current &&
          other.traverses(AbstractList.this);
      } else
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean traverses (Object container) {
      return container == AbstractList.this;
    }
    
    /**
     * {@inheritDoc}
     * @require    <code>this.traverses(container)</code> implies <code>other.traverses(container)</code>
     * @ensure     <code>this.equals(other)</code>
     */
    public void setEqualTo (Iterator<Element> other) {
      this.current = ((ListIterator)other).current;
    }
  }
}
