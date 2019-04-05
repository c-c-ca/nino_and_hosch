package ch7.figures;

/**
 * A simple rectangle with integer dimensions.
 */
public class Rectangle {
  
  private int length;
  private int width;

  /**
   * Create a new Rectangle with the specified dimensions.
   * @require    length >= 0 && width >= 0
   */
  public Rectangle (int length, int width) {
    this.length = length;
    this.width = width;
  }
  
  /**
   * The length of this Rectangle.
   * @ensure     this.length() >= 0
   */
  public int length () {
    return this.length;
  }
  
  /**
   * The width of this Rectangle.
   * @ensure     this.width() >= 0
   */
  public int width () {
    return this.width;
  }

  /**
   * The area of this Rectangle.
   * @ensure     this.area() >= 0
   */
  public int area () {
    return this.length * this.width;
  }

  /**
   * The perimeter of this Rectangle.
   * @ensure     this.perimeter() >= 0
   */
  public int perimeter () {
    return 2*this.length + 2*this.width;
  }
  
}
