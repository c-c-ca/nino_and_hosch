package ch13;

public class ArrayUtilities {
  
  /**
   * Fill the array with some integers.
   */
  public static void fill (int[] vec) {
    for (int i = 0; i < vec.length; i = i+1)
      vec[i] = 2*i;
  }
  
  /**
   * Fill the array with boxes starting at n.
   */
  public static void fillFrom (int n, Box[] boxes) {
    for (int i = 0; i < boxes.length; i = i+1) {
      boxes[i] = new Box(n);
      n = n+1;
    }
  }
  
  /**
   * Write the int array to standard output.
   */
  public static void show (int[] vec) {
    System.out.print("{");
    if (vec.length > 0) {
      System.out.print(vec[0]);
      for (int i = 1; i < vec.length; i = i+1)
        System.out.print(","+vec[i]);
    }
    System.out.println("}");
  }
  
  /**
   * Write the Object array to standard output.
   */
  public static void show (Object[] vec) {
    System.out.print("{");
    if (vec.length > 0) {
      System.out.print(vec[0]);
      for (int i = 1; i < vec.length; i = i+1)
        System.out.print(","+vec[i]);
    }
    System.out.println("}");
  }
  
  /**
   * Write the 2d array to standard output.
   */
  public static void show2D (Object[][] mat) {
    for (int i = 0; i < mat.length; i = i+1) {
      System.out.print(i+": ");
      show(mat[i]);
    }
  }
  
}


