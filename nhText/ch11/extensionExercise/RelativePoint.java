package ch11.extensionExercise;

/**
 * A point in the Cartesian plane, specified with an offset.
 */
public class RelativePoint extends Point {
  
  private int xOffset;    // x offset of this point
  private int yOffset;    // y offset of this point

  /**
   * Create a new RealtivePoint with the specified offsets.
   */
  public RelativePoint (int xOffset, int yOffset) {
    this.xOffset = xOffset;
    this.yOffset = yOffset;
    super.setPoint(xOffset,yOffset);
  }
 
  /**
   * Set the x-coordinate, relative to the x offset.
   */
  public void setX (int newX) {
    super.setX(newX + xOffset);
  }
  
  /**
   * Set the y-coordinate, relative to the y offset.
   */
  public void setY (int newY) {
    super.setY(newY + yOffset);
  }

  /**
   * Set the x and y coordinates, relative to the offsets.
   */
  public void setPoint (int newX, int newY) {
    super.setPoint(newX + xOffset, newY + yOffset);
  }
}
  
