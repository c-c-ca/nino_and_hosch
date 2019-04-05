package ch15.exercise;

/**
 * A dummy exercise class.
 */
public class Catcher {
  
  private Contractor contractor;

  public Catcher () {
    contractor = new Contractor();
  }
  
  public void doIt (int option) {
    try {
      contractor.doIt(option);
    } catch (NullPointerException e) {
      System.out.println("Caught a NullPointerException");
    } catch (RuntimeException e) {
      System.out.println("Caught a RunTimeException");
    } catch (Exception e) {
      System.out.println("Caught an Exception");
    }
    System.out.println("Contractor step: " + contractor.step);
  }
  
}

  
