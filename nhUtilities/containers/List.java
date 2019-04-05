package nhUtilities.containers;

/**
 * A finite list of <code>Element</code>s.
 */
public interface List<Element> extends java.lang.Iterable<Element>, Indexed<Element> {
  
  /**
   * Number of elements in this <code>List</code>.
   * @ensure     <code>this.size() &gt;= 0</code>
   */
  public int size ();

  /**
   * This <code>List</code> contains no elements.
   * <br>
   * <code>this.isEmpty() == (this.size() == 0)</code>
   */
  public boolean isEmpty ();

  /**
   * The <code>Element</code> with the specified index.
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   */
  public Element get (int index);

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
  public int indexOf (Element element);

  /**
   * This <code>List</code> contains the specified <code>Element</code>.
   * <br>
   * <code>this.contains(element) == (this.indexOf(element) &gt;= 0)</code>
   */
  public boolean contains (Element element);

  /**
   * Append the specified <code>Element</code> to the end of this <code>List</code>.
   * <br>
   * Equivalent to <code>this.add(this.size(),element)</code>.
   * @require    <code>element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>this.get(this.size()-1).equals(element)</code>
   */
  public void add (Element element);

  /**
   * Insert the specified <code>Element</code> at the specified index.
   * @require    <code>element != null</code><br>
   *             <code>0 &lt;= index &amp;&amp; index &lt;= this.size()</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>this.get(index).equals(element)</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; old.size()</code> implies<br>
   *             <code>&nbsp;&nbsp;old.get(j).equals(this.get(j+1))</code>
   */
  public void add (int index, Element element);

  /**
   * Replace the element at the specified position with the specified <code>Element</code>.
   * @require    <code>element != null</code><br>
   *             <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.get(index).equals(element)</code>
   */
  public void set (int index, Element element);

  /**
   * Remove the element with the specified index.
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; this.size()</code> inmplies<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(old.get(j+1))</code>
   */
  public void remove (int index);

  /**
   * Remove the first occurrence of the specified <code>Element</code> from this <code>List</code>.
   * Has no effect if the <code>Element</code> is not contained in this <code>List</code>.<br>
   * if <code>this.indexOf(element) &gt;= 0</code>, equivalent to <code>this.remove(this.indexOf(element))</code>.
   */
  public void remove (Element element);

  /**
   * A copy of this <code>List</code>.
   * @ensure     <code>this.copy() != this</code><br>
   *             <code>this.copy().size() == this.size()</code><br>
   *             for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(this.copy().get(j))</code>
   */
  public List<Element> copy ();
  
  /**
   * A <code>java.util.Iterator</code> for this <code>List</code>. (For
   * compatibility with the "enhanced <code>for</code>" semantics. sigh.)
   */
  public java.util.Iterator<Element> iterator ();
  
}
