package dimensional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DimensionalVectorTest {

    private DimensionalVector test1, test2;
    
    @BeforeEach
    public void before() {
        test1 = new DimensionalVector(1, 2, 3, 4);
        test2 = new DimensionalVector(4, 3, 2, 1);
    }
    
    @Test
    public void testAdd() {
        assertEquals(5, DimensionalVector.add(test1, test2).getMagnitude(0));
    }
    
    @Test
    public void testDotProduct() {
        assertEquals(20, DimensionalVector.dotProduct(test1, test2));
        
    }
    
    @Test
    public void testNormalize() {
        assertNotEquals(1, test1.getMagnitude());
        test1.normalize();
        assertEquals(1, test1.getMagnitude(), 0.0001);
    }

}
