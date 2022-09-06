package dimensional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class DimensionalArrayTest {

    DimensionalArray<Integer> test;
    
    @Before
    public void before() {
        test = new DimensionalArray<>(4, n -> null, 4, 4, 4, 4);
    }
    
    @Test
    public void testGetSize() {
        assertEquals(256, test.getSize());
        assertEquals(4, test.getSize(0));
    }
    
    @Test
    public void testGetAndSet() {
        test.set(24, 0, 1, 2, 0);
        assertEquals(Integer.valueOf(24), test.get(0, 1, 2, 0));
    }
    
    @Test
    public void testGetDimension() {
        assertEquals(4, test.getDimension());
    }
    
    @Test
    public void testToString() {
        assertEquals(Arrays.toString(new String[256]), test.toString());
    }
    
    @Test
    public void testExceptions() {
        ThrowingRunnable testRunnable = new ThrowingRunnable() {
            @Override
            public void run() {
                DimensionalArray<Integer> arr = new DimensionalArray<>(4, 1, 2, 3);
            }
        };
        
        assertThrows(IllegalArgumentException.class, testRunnable);
    }
    
}
