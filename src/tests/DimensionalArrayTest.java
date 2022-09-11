package tests;

import java.util.regex.Pattern;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dimensional.DimensionalArray;

public class DimensionalArrayTest {

	private DimensionalArray<Integer> test;

	@BeforeEach
	public void before() {
		test = new DimensionalArray<>(n -> n, 4, 4, 4, 4);
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
		assertThrows(IllegalArgumentException.class, () -> test.get(1, 2, 3, 4, 5));
	}

}