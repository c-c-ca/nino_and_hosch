package ch10.inheritanceExercise;

/**
 * A dummy class for exercise purposes.
 */
public class Base {
  
  private int state;
  
  public Base () {
    state = 10;
  }

  public int publicMethod1 () {
    return state;
  }
  
  public int publicMethod2 () {
    return privateMethod();
  }
  
  public void publicMethod3 () {
    state = state + 2;
  }
  
  private int privateMethod(){
    return -state;
  }
}
