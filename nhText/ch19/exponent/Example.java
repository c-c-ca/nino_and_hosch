package ch19.exponent;

/**
 * A utility exercise class.
 */
public class Example {
  
  /**
   * The specified number raised to the specified power.
   * @require     exponent >= 0
   */
  public static int power (int number, int exponent) {
    int result;
    if (exponent == 0)
      result = 1;
    else
      result = number * power(number,exponent-1);
    return result;
  }
