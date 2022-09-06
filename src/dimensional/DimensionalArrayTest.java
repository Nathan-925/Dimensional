package dimensional;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.*;
import org.junit.function.ThrowingRunnable;

public class DimensionalArrayTest {

    DimensionalArray<Integer> test;
    
    @Before
    public void before() {
        test = new DimensionalArray<>(4, n -> n, 4, 4, 4, 4);
    }
    
    @Test
    public void testGetSize() {
        assertEquals(256, test.getSize());
        assertEquals(4, test.getSize(0));
    }
    
    @Test
    public void testGetAndSet() {
    	assertEquals(Integer.valueOf(159), test.get(3, 3, 1, 2));
        test.set(24, 0, 1, 2, 0);
        assertEquals(Integer.valueOf(24), test.get(0, 1, 2, 0));
    }
    
    @Test
    public void testGetDimension() {
        assertEquals(4, test.getDimension());
    }
    
    @Test
    public void testToString() {
        assertTrue(Pattern.matches("\\[(\\d+,?\\s*)*\\]", test.toString()));
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
        
        testRunnable = new ThrowingRunnable() {
        	@Override
			public void run() {
				test.get(1, 2, 3, 4, 5);
			}
        };
        assertThrows(IllegalArgumentException.class, testRunnable);
    }
    
}
