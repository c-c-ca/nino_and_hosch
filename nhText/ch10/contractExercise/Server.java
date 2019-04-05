package ch10.contractExercise;

/**
 * A simple class supporting an exercise.
 */
public class Server {
  
  /**
   * The specified value is divisible by 3.
   * @require    <code>0 <= value && value <= 100</code>
   */
  public boolean divisibleBy3 (int value) {
    return value % 3 == 0;
  }
  
