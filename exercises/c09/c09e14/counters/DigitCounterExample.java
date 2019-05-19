package counters;

/**
 * Example of a DigitCounter.
 */
public class DigitCounterExample {
    public static void main (String[] argv) {
        DigitCounter counter = new DigitCounter(5);
        for (int i = 0; i <= 100; ++i) {
            System.out.println(counter);
            counter.step();
        }
    }
}
