package ch10.inheritanceExercise;

/**
 * A dummy class for exercise purposes.
 */
public class SubBase extends Base {
  
  public void report () {
    System.out.println("publicMethod1: " + this.publicMethod1());
    System.out.println("publicMethod2: " + this.publicMethod2());
    this.publicMethod3();
    System.out.println("publicMethod3 changes state: " + this.publicMethod1());
//  System.out.println("privateMethod: " + this.privateMethod());
//  System.out.println("privateVariable: " + this.state);
  }
  
}
