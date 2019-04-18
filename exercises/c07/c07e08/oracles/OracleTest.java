package oracles;

import org.junit.*;
import static org.junit.Assert.*;

public class OracleTest {

    private Oracle oracle;

    @Before
    public void setUp () {
        oracle = new Oracle();
    }

    @Test
    public void testInitialState () {
        assertFalse(oracle.isAwake());
    }

    /**
     * Test the awaken method.
     */
    @Test
    public void testAwaken () {
        oracle.awaken();
        assertTrue(oracle.isAwake());
    }

    /**
     * Test the sleep method.
     */
    @Test
    public void testSleep () {
        oracle.awaken();
        assertTrue(oracle.isAwake());
        oracle.sleep();
        assertFalse(oracle.isAwake());
    }

    /**
     * Test that the fortune does not change if the
     * Oracle stays awake.
     */
    @Test
    public void testFortuneDoesNotChange () {
        String firstFortune, secondFortune;
        oracle.awaken();
        firstFortune = oracle.fortune();
        secondFortune = oracle.fortune();
        assertEquals(firstFortune,secondFortune);
    }

    /**
     * Test that the fortune does not change if the
     * Oracle is awakened twice.
     */
    @Test
    public void testWakeTwiceNoSleep () {
        String firstFortune, secondFortune;
        oracle.awaken();
        firstFortune = oracle.fortune();
        oracle.awaken();
        secondFortune = oracle.fortune();
        assertEquals(firstFortune,secondFortune);
    }

    /**
     * Test that the fortune given after being
     * put to sleep and awaken a second time is
     * different from the first fortune.
     */
    @Test
    public void testFortuneChanges () {
        String firstFortune, secondFortune;
        oracle.awaken();
        firstFortune = oracle.fortune();
        oracle.sleep();
        oracle.awaken();
        secondFortune = oracle.fortune();
        assertNotEquals(firstFortune,secondFortune);
    }

    /**
     * Test that the fortunes given alternate.
     */
    @Test
    public void testFortunesAreDifferent () {
        String firstFortune, secondFortune;
        String thirdFortune, fourthFortune;
        oracle.awaken();
        firstFortune = oracle.fortune();
        oracle.sleep();
        oracle.awaken();
        secondFortune = oracle.fortune();
        oracle.sleep();
        oracle.awaken();
        thirdFortune = oracle.fortune();
        oracle.sleep();
        oracle.awaken();
        fourthFortune = oracle.fortune();
        assertEquals(firstFortune,thirdFortune);
        assertEquals(secondFortune,fourthFortune);
    }

    /**
     * Test that the fortunes given are not null.
     */
    @Test
    public void testFortunesNotNull () {
        String firstFortune, secondFortune;
        oracle.awaken();
        firstFortune = oracle.fortune();
        oracle.sleep();
        oracle.awaken();
        secondFortune = oracle.fortune();
        assertNotEquals(null,firstFortune);
        assertNotEquals(null,secondFortune);
    }
}
