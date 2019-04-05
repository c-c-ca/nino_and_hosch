package ch10.constructorExercise;

/**
 * A class supporting an exercise.
 */
public class Bottom {
  
  public Bottom (int i) {
    super();
    System.out.println("The Bottom class, constructor with parameter");
  }

  public Bottom () { 
    this(0);
    System.out.println("The Bottom class, constructor without parameter");
  }
  
