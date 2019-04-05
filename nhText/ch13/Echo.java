package ch13;

/**
 * An application that simply displays its command line arguments.
 */
public class Echo {
  
  public static void main (String[] args) {
    System.out.println("Number of command line arguments: " + args.length);
    for (int i = 0; i < args.length; i = i+1) {
      System.out.println(args[i]);  }
  }
}
