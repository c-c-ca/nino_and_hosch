package ch5.exercise;

/**
 * This class does not model anything. It is an artifact for the exercise.
 */
public class Toy {
  
  /**
   * Twice the value of the specified number.
   * @require    0 <= number && number <= 10
   * @ensure     0 <= this.twice(number) && this.twice(number) <= 20
   */
  public int twice (int number) {
    return 2*number;
  }
  
  /**
   * One more than the specified number. Cyclic in the range (-5,5).
   * @require    -5 <= number && number <= 5
   * @ensure     -5 <= this.next(number) && this.next(number) <= 5
   *             this.next(5) == -5.
   */
  public int next (int number) {
    int temp = number + 1;
    if (temp > 5)
      temp = -5;
    return temp;
  }
