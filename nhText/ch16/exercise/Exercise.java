package ch16.exercise;
import java.io.*;

public class Exercise {
  
  public static void printOut (File f) throws IOException {
    PrintStream out = new PrintStream(new FileOutputStream(f));
    int b = 51;
    out.write(b);
    out.print(b);
    out.close();
  }
  
  public static void writeOut (File f1, File f2) throws IOException {
    OutputStreamWriter out1 = new OutputStreamWriter(new FileOutputStream(f2));
    OutputStreamWriter out2 = new OutputStreamWriter(new FileOutputStream(f1),
                                                     "UTF-16BE");
    int c = (int)'a';
    out1.write(c);
    out2.write(c);
    out1.close();
    out2.close();
  }
  
  public static void printLine (File f) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(f));
    out.println("abc");
    out.println("def");
    out.close();
  }
  
  public static void displayFile (File f) throws IOException {
    FileInputStream input = new FileInputStream (f);
    int count = 0;
    int b;
    while ((b = input.read()) != -1) {
      System.out.print(b + " ");
      count = count + 1;
      if (count == 20) {
        System.out.println();
        count = 0;
      }
    }
    if (count != 0) System.out.println();
    input.close();
  }
}
  
