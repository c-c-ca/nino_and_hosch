package iteratorExercises;

import nhUtilities.containers2.*;
import org.junit.*;
import static org.junit.Assert.*;
import static iteratorExercises.Exercise.isPalindrome;

public class IsPalindromeTest {

    // Test fixture:

    private DoublyLinkedList<String> emptyList;
    private DoublyLinkedList<String> singleElement;
    private DoublyLinkedList<String> aPalindrome;
    private DoublyLinkedList<String> notAPalindrome;

    private DoublyLinkedList<String> stol (String s) {
        DoublyLinkedList<String> l =
            new DoublyLinkedList<String>();
        for (int i = 0; i < s.length(); i = i+1)
            l.add(String.valueOf(s.charAt(i)));
        return l;
    }

    @Before
    public void setUp () {
        emptyList = stol("");
        singleElement = stol("a");
        aPalindrome = stol("ablewasiereisawelba");
        notAPalindrome = stol("notapalindrome");
    }

    @Test
    public void testIsPalindrome () {
        assertTrue(isPalindrome(emptyList));
        assertTrue(isPalindrome(singleElement));
        assertTrue(isPalindrome(aPalindrome));
        assertFalse(isPalindrome(notAPalindrome));
    }
}
