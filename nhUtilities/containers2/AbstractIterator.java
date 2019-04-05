package nhUtilities.containers2;

/**
 * A utility class that implements java.util.Iterator methods in terms of the
 * nhUtilities.containers2.Iterator methods.
 */
abstract class AbstractIterator<Element> implements Iterator<Element> {
  
  /**
   * {@inheritDoc}
   */
  public boolean hasNext () {
    return !this.done();
  }
      
  /**
   * {@inheritDoc}
   * @require    <code>!this.done()</code>
   */
  public Element next () {
    Element temp = this.get();
    this.advance();
    return temp;
  }
    
  /**
   * {@inheritDoc}
   */
  public void remove () {
    throw new UnsupportedOperationException(
      "nhUtilities.containers2.Iterator.remove())");
  }
  
  /**
   * {@inheritDoc}
   */
  public Object clone () {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }
  
}


