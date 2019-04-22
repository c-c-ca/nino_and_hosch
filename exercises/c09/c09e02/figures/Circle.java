package figures;

/**
 * Models a simple circle with double dimensions.
 */
public class Circle implements ClosedFigure {

    // Private Components:

    private int radius;  // the radius of this circle

    /**
     * Create a new Circle with the specified radius.
     * @require    radius >= 0
     */
    public Circle (int radius) {
        this.radius = radius;
    }

    // Queries:

    /**
     * The radius of this Circle.
     */
    public int radius () {
        return radius;
    }

    /**
     * The diameter of this Circle.
     */
    public int diameter () {
        return radius * 2;
    }

    /**
     * The area of this Circle.
     */
    public int area () {
        return (int) (Math.PI * (double) radius * (double) radius);
    }

    /**
     * The circumference of this Circle.
     */
    public int circumference () {
        return (int) (2.0 * Math.PI * (double) radius);
    }

}
