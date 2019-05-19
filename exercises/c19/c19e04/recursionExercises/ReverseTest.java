package recursionExercises;

import org.junit.*;
import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void testReverse () {
        assertEquals(Exercise.reverse("a"),"a");
        assertEquals(Exercise.reverse("abc"),"cba");
        assertEquals(Exercise.reverse("abcd"),"dcba");
        assertEquals(
            Exercise.reverse("Hello, world"), "dlrow ,olleH");
    }
}
