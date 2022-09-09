package dimensional;

import java.util.ArrayList;
import java.util.function.Function;

public class DimensionalArray<T> {

	private int[] widths;
	private ArrayList<T> arr;

	public DimensionalArray(int dimensions, Function<Integer, T> function, int... widths) {
		if (widths.length != dimensions)
			throw new IllegalArgumentException("length of widths must equal dimensions");

		this.widths = widths;
		int num = 1;
		for (int n : widths)
			num *= n;
		arr = new ArrayList<>(num);
		for (int i = 0; i < num; i++)
			arr.add(function.apply(i));
	}

	public DimensionalArray(int dimensions, int... widths) {
		this(dimensions, n -> null, widths);
	}

	public DimensionalArray(int dimensions, T initial, int... widths) {
		this(dimensions, n -> initial, widths);
	}

	private int getIndex(int[] indexes) {
		if (indexes.length != widths.length)
			throw new IllegalArgumentException("number of indexes must be equal to number of dimensions");

		int ind = indexes[0];
		for (int i = 1; i < indexes.length; i++) {
			int n = indexes[i];
			for (int j = i - 1; j >= 0; j--)
				n *= widths[j];
			ind += n;
		}
		return ind;
	}

	public void set(T t, int... indexes) {
		arr.set(getIndex(indexes), t);
	}

	public T get(int... indexes) {
		return arr.get(getIndex(indexes));
	}

	public int getSize() {
		return arr.size();
	}

	public int getSize(int dimension) {
		return widths[dimension];
	}

	public int getDimension() {
		return widths.length;
	}

	@Override
	public String toString() {
		return arr.toString();
	}

}
