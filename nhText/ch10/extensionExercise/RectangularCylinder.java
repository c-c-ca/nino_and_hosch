package ch10.extensionExercise;

/**
 * A rectangular right cylinder.  (This class defined only for exercise purposes.)
 */
public class RectangularCylinder extends Cylinder {
  
  private int length;    // length of the base
  private int width;     // width of the base

  /**
   * Create a RectangularCylinder with the specified length, width, and height.
   * Arguments must be >= 0.
   */
  public RectangularCylinder (int baseLength, int baseWidth, int height) {
    super(height);
    this.length = baseLength;
    this.width = baseWidth;
  }
 
  /**
   * The area of the base of this RectangularCylinder.
   */
  public int baseArea () {
    return this.length * this.width;
  }
  
}
