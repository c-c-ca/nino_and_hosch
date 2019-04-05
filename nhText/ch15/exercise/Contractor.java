package ch15.exercise;

/**
 * A dummy exercise class.
 */
public class Contractor {
  
  int step;   // package private so we can see it in Catcher
  private ExceptionGenerator subContractor;
  
  public Contractor () {
    step = 0;
    subContractor = new ExceptionGenerator();
  }
  
  public void doIt (int choice) throws java.io.FileNotFoundException {
    step = 1;
    int temp = subContractor.tryIt(choice);
    step = 2;
  }
  
}

