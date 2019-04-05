package ch7;

/**
 * Not a proper class. Just examples for chapter 7.
 */
public class Examples {
  
  /**
   * The number of occurances of the specified character in the specified
   * String.
   */
  public static int charCount (char c, String s) {
    int count = 0;
    int index = 0;
    char current;
    while (index < s.length()) {
      current = s.charAt(index);
      if (c == current)
        count = count + 1;
      index = index + 1;
    }
    return count;
  }
 
  /**
   * The i-th Fibonacci number. The Fibonacci numbers are
   * 1,1,2,3,5,8,13,...
   * where each number in the sequence is the sum of the preceding two.
   * 
   * @require    i > 0
   */
  public static int fibonacci (int i) {
    int previous = 0;     // (index-1)th fibonacci number
    int number = 1;       // index-th fibonacii number
    int index = 1;
    while (index != i) {
      int temp = previous;
      previous = number;
      number = number + temp;
      index = index + 1;
    }
    return number;
  }
 
  /**
   * The i-th factorial.
   * 0! = 1, and for n > 0, n! = 1*2*3*...*n
   * 
   * @require    i >= 0
   */
  public static int factorial (int i) {
    int factorial = 1;    // factorial == (factor-1)!
    int factor = 1;
    while ((factor-1) != i) {
      factorial = factorial * factor;
      factor = factor + 1;
    }
    return factorial;
  }
  
}
