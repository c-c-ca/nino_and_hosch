package tests;

import org.junit.*;
import static org.junit.Assert.*;

public class CircularListTest {

    // Test fixture:

    private array.CircularList<Integer> array;
    private linked.CircularList<Integer> linked;

    @Before
    public void setUp () {
        array = new array.CircularList<Integer>();
        linked = new linked.CircularList<Integer>();
    }

    @Test
    public void testInitialState () {
        // test behavior for getting an element from an
        // empty list
        assertEquals(null,array.get());
        assertEquals(null,linked.get());
    }

    @Test
    public void testAdd () {
        int number = 5;
        for (int i = 0; i < number; i = i+1) {
            array.add(i);
            linked.add(i);
        }
        // test that the current element is the
        // element that was just added
        assertEquals(number-1,array.get().intValue());
        assertEquals(number-1,linked.get().intValue());
        // test that the next element in the list is the first
        // element that was added
        array.next();
        linked.next();
        assertEquals(0,array.get().intValue());
        assertEquals(0,linked.get().intValue());
        // test that elements are in the same order that
        // they were added
        for (int i = 0; i < number; i = i+1) {
            assertEquals(i,array.get().intValue());
            assertEquals(i,linked.get().intValue());
            array.next();
            linked.next();
        }
        // test that calling get after calling next n times
        // where n equals the number of elements in the list,
        // returns the same element that was returned on the
        // call to get prior to the initial call to next
        assertEquals(0,array.get().intValue());
        assertEquals(0,linked.get().intValue());
    }

    @Test
    public void testRemove () {
        // test behavior when removing from an empty list
        array.remove();
        linked.remove();
        assertEquals(null,array.get());
        assertEquals(null,linked.get());
        // test behavior after removing all elements from a list
        array.add(1);
        linked.add(1);
        array.remove();
        linked.remove();
        assertEquals(null,array.get());
        assertEquals(null,linked.get());
        // test that the current element is the same after
        // an add and remove call (i.e. the list state is
        // unchanged)
        int number = 5;
        for (int i = 0; i < number; i = i+1) {
            array.add(i);
            linked.add(i);
        }
        assertEquals(number-1,array.get().intValue());
        assertEquals(number-1,linked.get().intValue());
        int n = 92;
        array.add(n);
        linked.add(n);
        assertEquals(n,array.get().intValue());
        assertEquals(n,linked.get().intValue());
        array.remove();
        linked.remove();
        assertEquals(number-1,array.get().intValue());
        assertEquals(number-1,linked.get().intValue());
        // test typical usage: adding and removing an element
        // from some arbitrary position in the list
        for (int i = 0; i <= number/2; i = i+1) {
            array.next();
            linked.next();
        }
        assertEquals(number/2,array.get().intValue());
        assertEquals(number/2,linked.get().intValue());
        array.add(n);
        linked.add(n);
        assertEquals(n,array.get().intValue());
        assertEquals(n,linked.get().intValue());
        array.next();
        linked.next();
        for (int i = 0, j = number/2+1; i < number;
             i = i+1, j = (j+1)%number) {
            assertEquals(j,array.get().intValue());
            assertEquals(j,linked.get().intValue());
            array.next();
            linked.next();
        }
        assertEquals(n,array.get().intValue());
        assertEquals(n,linked.get().intValue());
        array.remove();
        linked.remove();
        for (int i = 0, j = number/2; i < number;
             i = i+1, j = (j+1)%number) {
            assertEquals(j,array.get().intValue());
            assertEquals(j,linked.get().intValue());
            array.next();
            linked.next();
        }
        assertEquals(number/2,array.get().intValue());
        assertEquals(number/2,linked.get().intValue());
    }

    @Test
    public void testEmptyList () {
        array.next();
        linked.next();
    }

}
