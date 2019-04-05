package ch19.quickSort;

public interface Order<Element> {
  
  /**
   * e1 precedes e2 in the ordering.
   * inOrder is antisymmetric:
   *     inOrder(x,y) implies !inOrder(y,x).
   * inOrder is transitive:
   *     inOrder(x,y) && inOrder(y,z) implies inOrder(x,z).
   */
  boolean inOrder (Element e1, Element e2);
  
}
