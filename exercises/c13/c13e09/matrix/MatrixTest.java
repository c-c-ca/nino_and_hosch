package matrix;

import org.junit.*;
import static org.junit.Assert.*;

public class MatrixTest {

    // Test fixture:

    private Matrix matrix;

    private void fill (Matrix m) {
        int value = 0;
        for (int i = 0; i < 3; i = i+1)
            for (int j = 0; j < 3; j = j+1)
                m.setValue(i,j,value++);
    }

    @Before
    public void setUp () {
        matrix = new Matrix(3,3);
        fill(matrix);
    }

    @Test
    public void testGetValue () {
        assertEquals(5,matrix.getValue(1,2));
    }
}
