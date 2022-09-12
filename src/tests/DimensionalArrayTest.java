package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dimensional.DimensionalArray;

public class DimensionalArrayTest {

	private DimensionalArray<String> test;

	@BeforeEach
	public void before() {
		test = new DimensionalArray<>(n -> Integer.toString(n, 4), 4, 4, 4, 4);
	}

	@Test
	public void testGetSize() {
		assertEquals(256, test.size());
		assertEquals(4, test.size(0));
	}

	@Test
	public void testGetAndSet() {
		assertEquals("3123", test.get(3, 2, 1, 3));
		test.set("24", 0, 1, 2, 0);
		assertEquals("24", test.get(0, 1, 2, 0));
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
		assertThrows(IllegalArgumentException.class, () -> test.get(1, 2, 3, 4));
	}

}
