package containers;

import nhUtilities.containers2.*;

/**
 * A doubly-linked list with header.
 */
public class DoublyLinkedList<Element> extends AbstractList<Element> {

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
