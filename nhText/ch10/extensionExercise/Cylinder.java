package ch10.extensionExercise;

/**
 * A right cylinder. (This class defined only for exercise purposes.)
 */
public abstract class Cylinder {
  
  private int height;   // this Cylinder's height
  private int volume;   // this Cylinder's area

  /**
   * Create a Cylinder with the specified height. height must be >= 0.
   */
  protected Cylinder (int height) {
    this.height = height;
    this.volume = height*baseArea();
  }
  
  /**
   * The volume of this Cylinder.
   */
  public int volume () {
    return this.volume;
  }
 
  /**
   * The area of this Cylinder's base.
   */
  abstract public int baseArea ();
  
}
