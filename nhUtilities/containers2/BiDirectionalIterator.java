package nhUtilities.containers2;
/**
 * An <code>Iterator</code> that can move to previous as well as next element.
 * <code>offRight</code> is true if the <code>Iterator</code> has been advanced past the last element,
 * or if the container is empty. <code>offLeft</code> is true if the <code>Iterator</code> has been
 * backed up past the first element, or if the container is empty.
 * If <code>offRight</code> and the container is not empty, <code>backup</code> positions the <code>Iterator</code> to the last element.
 * If <code>offLeft</code> and the container is not empty, <code>advance</code> positions the <code>Iterator</code> to the first element.
 * <code>done</code> is equivalent to <code>offRight</code>.
 */
public interface BiDirectionalIterator<Element> extends Iterator<Element> {

  /**
   * This <code>Iterator</code> has been advanced past the last element, backed up past the
   * first element, or the container is empty.<br>
   * <code>this.done() == this.offRight()</code>.
   */
  public boolean done ();

  /**
   * This <code>Iterator</code> has been advanced past the last element, or the container is empty.
   */
  public boolean offRight ();

  /**
   * This <code>Iterator</code> has been backed up past the first element, or the container is empty.
   */
  public boolean offLeft ();

  /**
   * Advance this <code>Iterator</code> to the next element. If <code>this.offLeft()</code> and the
   * container is not empty, move to the first element.
   * @require    <code>!this.offRight()</code>
   */
  public void advance ();

  /**
   * Move this <code>Iterator</code> back to the previous element. If <code>this.offRight()</code> and
   * the container is not empty, move to the last element.
   * @require    <code>!this.offLeft()</code>
   */
  public void backup ();

}
