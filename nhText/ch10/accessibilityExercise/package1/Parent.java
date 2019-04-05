package ch10.accessibilityExercise.package1;

import ch10.accessibilityExercise.package2.Child;

public class Parent {
  
  public int pub;
  private int pri;
  protected int pro;
  int res;
 
  public void accessSameClass (Parent parent) {
    parent.pub = 1;
    parent.pri = 2;      // private feature visible in defining class
    parent.pro = 3;
    parent.res = 4;
  }
  
  public void accessSubClass (Child child) {
    child.pub = 1;
//  child.pri = 2;       // private features are not inherited
    child.pro = 3;       // inherited protected feature visible to any class in
                         // package1
//  child.res = 4;       // package private feature looks like private
                         // from a different package -- not inherited
  }

