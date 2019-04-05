package ch14.exercise;
import nhUtilities.containers.*;
import java.util.Random;
import java.util.Comparator;

/**
 * Utilities for the exercises.
 */
public class Exercise {
  
  /**
   * Generate a List<Integer> containg n elements.
   * If type is 1, list is ascending.
   * If type is -1, list is descending.
   * Otherwise, list is pseudo random with type as seed, range 1 through n.
   */
  public static List<Integer> generateList (int n, int type) {
    List<Integer> list = new DefaultList<Integer>();
    if (type == 1)
      for (int i = 1; i <= n; i = i+1)
        list.add(new Integer(i));
    else if (type == -1)
      for (int i = n; i >= 1; i = i-1)
        list.add(new Integer(i));
    else {
      Random gen = new Random(type);
      for (int i = 1; i <= n; i = i+1)
        list.add(gen.nextInt(n)+1);
    }
    return list;
  }
  
  public static Comparator<Integer> oddEven = new Comparator<Integer> () {
    public int compare (Integer x, Integer y) {
      return y.intValue()%2 - x.intValue()%2;
    }
  };
}
