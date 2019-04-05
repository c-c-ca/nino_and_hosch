package nhUtilities.containers;

/**
 * A simple iterator that iterates with a list index. This class is only to
 * support the "extended <code>for</code> loop semantics."
 */
class IndexingIterator<Element> implements java.util.Iterator<Element> {
  
  private int current; // index to the current element
  private Indexed<Element> list; // the container this Itertor iterates over.
  
  /**
   * Create a new <code>IndexingIterator</code> for the specified container.
   * @require    <code>list != null</code>
   */
  public IndexingIterator (Indexed<Element> list) {
    this.list = list;
    this.current = 0;
  }
  
  /**
   * There are more elements to be seen.
   */
  public boolean hasNext () {
    return current < list.size();
  }
  
  /**
   * Return the current element and advance to the next.
   * @require    <code>this.hasNext()</code>
   */
  public Element next () {
    current = current + 1;
    return list.get(current-1);
  }
  
  /**
   * Throw <code>UnsupportedOperationException</code>. (Removal with this
   * iterator is not allowed.)
   */
  public void remove () {
    throw new UnsupportedOperationException(
      "nhUtilities.containers.IndexingIterator.remove())");
  }
}
