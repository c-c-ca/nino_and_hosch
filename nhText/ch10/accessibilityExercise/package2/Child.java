package ch10.accessibilityExercise.package2;

import ch10.accessibilityExercise.package1.Parent;
import ch10.accessibilityExercise.package3.GrandChild;

public class Child extends Parent {
  
  public void accessSameClass (Child child) {
    child.pub = 1;       // public feature is inherited and globally visible
//  child.pri = 2;       // private features are not inherited
    child.pro = 3;       // protected feature is inherited
//  child.res = 4;       // package private feature looks like private
                         // from a different package -- not inherited
  }

  public void accessSuperClass (Parent parent) {
    parent.pub = 1;      // public feature is inherited and globally visible
//  parent.pri = 2;      // private feature visible only in defining class
//  parent.pro = 3;      // can't see parent's protected feature
//  parent.res = 4;      // package private feature looks like private
                         // from a different package
  }
  
  public void accessSubClass (GrandChild grandChild) {
    grandChild.pub = 1;  // public feature is inherited and globally visible
    grandChild.pro = 3;  // protected feature ingerited by GrandChild through
                         // Child is visible in Child
  }
   
