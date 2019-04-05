package ch10.contractExercise;

/**
 * A simple class supporting an exercise.
 */
public class ServerSubClass extends Server {
  
  /**
   * The specified value is divisible by 3.
   * @require    <code>0 <= value && value <= 10</code>
   */
  public boolean divisibleBy3 (int value) {
    return value == 0 || value == 3 || value == 6 || value == 9;
  }
