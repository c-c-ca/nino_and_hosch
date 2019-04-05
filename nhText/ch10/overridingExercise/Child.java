package ch10.overridingExercise;

public class Child extends Parent {
  
  public void report (Child child) {
    System.out.println("Child, Child parameter");
  }
  
  public void report (Object obj) {
    System.out.println("Child, Object parameter");
  }
  
}
