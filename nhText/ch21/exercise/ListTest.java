package ch21.exercise;

import nhUtilities.containers.*;

/**
 * A dummy class to support the exercise.
 */
public class ListTest {
  
  public static void buildFromFront (List<Integer> list, int n) {
    for (int i = 1; i <= n; i = i+1)
      list.add(0,new Integer(i));
  }
  
  public static void buildFromRear (List<Integer> list, int n) {
    for (int i = 1; i <= n; i = i+1)
      list.add(new Integer(i));
  }
  
  public static boolean contains (List<Integer> list, Integer i) {
    int index = 0;
    int n = list.size();
    while (index < n && !i.equals(list.get(index)))
      index = index + 1;
    return index < n;
  }
  
}
