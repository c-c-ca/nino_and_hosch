package figures;

/**
 * Models a simple circle with double dimensions.
 */
class Circle {

    // Private Components:

    private double radius;  // the radius of this circle

    /**
     * Create a new Circle with the specified radius.
     * The radius must be a non-negative double.
     */
    public Circle (double radius) {
        this.radius = radius;
    }

    // Queries:

    /**
     * The radius of this Circle.
     */
    public double radius () {
        return radius;
    }

    /**
     * The diameter of this Circle.
     */
    public double diameter () {
        return radius * 2;
    }

    /**
     * The area of this Circle.
     */
    public double area () {
        return Math.PI * radius * radius;
    }

    /**
     * The circumference of this Circle.
     */
    public double circumference () {
        return 2 * Math.PI * radius;
    }

}
