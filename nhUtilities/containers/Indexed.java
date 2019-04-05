package nhUtilities.containers;

/**
 * A container that can be iterated over by index.
 */
interface Indexed<Element> {
  
  /**
   * Number of elements in this container.
   * @ensure     <code>this.size() &gt;= 0</code>
   */
  public int size ();

  /**
   * The <code>Element</code> with the specified index.
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   */
  public Element get (int index);
}


  