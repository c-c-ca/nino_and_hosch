package ch22.exercise;

import nhUtilities.containers2.*;

/**
 * Utilities for the exercises.
 */
public class Exercise {
  
  /**
   * Generate a LinkedList<Integer> containg n elements.
   */
  public static List<Integer> generateLinked (int n) {
    List<Integer> list = new LinkedList<Integer>();
    for (int i = 1; i <= n; i = i+1)
      list.add(0,new Integer(i));
    return list;
  }

  /**
   * Generate a DefaultList<Integer> containg n elements.
   */
  public static List<Integer> generateDefault (int n) {
    List<Integer> list = new DefaultList<Integer>();
    for (int i = 1; i <= n; i = i+1)
      list.add(new Integer(i));
    return list;
  }
  
  /**
   * Search by index.
   */
  public static boolean contains1 (List<Integer> list, Integer i) {
    int index = 0;
    int n = list.size();
    while (index < n && !i.equals(list.get(index)))
      index = index + 1;
    return index < n;
  }
  
  /**
   * Search by Iterator.
   */
  public static boolean contains2 (List<Integer> list, Integer i) {
    Iterator<Integer> iter = list.iterator();
    iter.reset();
    while (!iter.done() && !i.equals(iter.get()))
      iter.advance();
    return !iter.done();
  }
  
}  

