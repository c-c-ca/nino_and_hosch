package ch10.accessibilityExercise.package1;

import ch10.accessibilityExercise.package2.Child;

public class ParentPack {
 
  public void accessSameClass (Parent parent) {
    parent.pub = 1;      // public feature is globally visible
//  parent.pri = 2;      // private feature visible only in defining class
    parent.pro = 3;      // protected feature visible to any class in package1
    parent.res = 4;      // package privte feature visible to any class in package1
  }
  
  public void accessSubClass (Child child) {
    child.pub = 1;       // public feature is inherited and globally visible
    child.pro = 3;       // inherited protected feature visible to any class in
                         // package1
//  child.res = 4;       // package private feature not inherited outside the
                         // package
  }

  public void accessSubClassPackage1 (ChildPackage1 child) {
    child.res = 4;       // package private feature inherited inside the
                         // package
  }

