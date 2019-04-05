package ch9.nimExercise;

/**
 * A dummy class for subtype exercises.
 */
public class TimidPlayer implements Player {
  
  /**
   * Create a TimidPlayer.
   */
  public TimidPlayer () {
  }
  
  public String myClass () {
    return "TimidPlayer";
  }
  
  public boolean isTimid () {
    return true;
  }
  
}
