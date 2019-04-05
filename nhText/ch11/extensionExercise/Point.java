package ch11.extensionExercise;

/**
 * A point in the Cartesian plane. (Just an exercise class.)
 */
public class Point {
  
  private int x;     // x coordinate of this Point
  private int y;     // y coordinate of this Point
 
  /**
   * Create a new Point with coordinates (0,0)
   */
  public Point () {
    this.x = 0;
    this.y = 0;
  }
  
  /**
   * Set the x-coordinate of this Point to the specified value.
   */
  public void setX (int newX) {
    this.x = newX;
  }
  
  /**
   * Set the y-coordinate of this Point to the specified value.
   */
  public void setY (int newY) {
    this.y = newY;
  }

  /**
   * Set the x and y coordinates of this Point to the specified values.
   */
  public void setPoint (int newX, int newY) {
    setX(newX);
    setY(newY);
  }

  /**
   * The x coordinate of this Point.
   */
  public int x () {
    return this.x;
  }
  
  /**
   * The y coordinate of this Point.
   */
  public int y () {
    return this.y;
  }
}
  
