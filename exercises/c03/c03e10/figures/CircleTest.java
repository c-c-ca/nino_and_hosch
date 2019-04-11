package figures;

/**
 * A simple class to test the class Circle.
 */
class CircleTest {

    /**
     * Run the test.
     */
    public void runTest () {
        Circle circle;
        // create a Circle with a radius of 0
        circle = new Circle(0);
        testInitialState(circle);

        // create a Circle with a radius of 1
        circle = new Circle(1);
        testInitialState(circle);

        // create a Circle with a radius of 3
        circle = new Circle(3);
        testInitialState(circle);
    }

    /**
     * Test the Circle's initial state.
     */
    private void testInitialState (Circle circle) {
        System.out.println("testInitialState:");
        System.out.println("Initial radius:        " + circle.radius());
        System.out.println("Initial diameter:      " + circle.diameter());
        System.out.println("Initial area:          " + circle.area());
        System.out.println("Initial circumference: " + circle.circumference());
    }

}
