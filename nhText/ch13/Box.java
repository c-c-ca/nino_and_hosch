package ch13;

/**
 * An int variable wrapped in an object.
 */
public class Box {
  
  private int value;
  
  /**
   * Create a new Box intialized to the specified value.
   */
  public Box (int value) {
    this.value = value;
  }
  
  /**
   * The value of the variable wrapped in the Box.
   */
  public int value () {
    return this.value;
  }
  
  /**
   * Set the value of the variable wrapped in this Box.
   */
  public void setValue (int v) {
    this.value = v;
  }
  
  /**
   * The value of the wrapped variable as a String.
   */
  public String toString () {
    return this.value + "";
  }
}
