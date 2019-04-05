package ch10.contractExercise;

/**
 * A simple class supporting an exercise.
 */
public class Client {
  
  private Server checker;
 
  /**
   * Create a new Client with the specified Server.
   */
  public Client (Server checker){
    this.checker = checker;
  }
 
  /**
   * Report whether or not the specified value is divisible by three.
   * @require    <code>0 <= value && value <= 100</code>
   */
  public void report (int value) {
    if (checker.divisibleBy3(value))
      System.out.println(value + " is a good value.");
    else
      System.out.println(value + " is not a good value.");
  }
  
}
