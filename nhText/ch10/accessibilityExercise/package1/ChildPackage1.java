package ch10.accessibilityExercise.package1;

public class ChildPackage1 extends Parent {
  
  public void accessSameClass (ChildPackage1 child) {
    child.res = 4;       // package private feature looks like public
                         // in the same package -- inherited
  }
}
