package recursionExercises;

import org.junit.*;
import static org.junit.Assert.*;
import static recursionExercises.Exercise.*;

public class PalindromeTest {

    @Test
    public void testPalindrome () {
        assertTrue(palindrome("a"));
        assertTrue(palindrome("aba"));
        assertTrue(palindrome("racecar"));
        assertTrue(palindrome("ablewasiereisawelba"));
        assertTrue(palindrome("amanaplanacanalpanama"));
        assertFalse(palindrome("ab"));
        assertFalse(palindrome("false"));
    }
}
