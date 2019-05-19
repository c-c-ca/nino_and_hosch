package recursionExercises;

import org.junit.*;
import static org.junit.Assert.*;

import static recursionExercises.Exercise.*;

public class NineDigitNumberTest {

    @Test
    public void testFindNineDigitNumber () {
        int number = findNineDigitNumber();
        for (int i = 9; i > 0; i = i-1) {
            assertTrue(number%i == 0);
            number = number / 10;
        }
    }
}
