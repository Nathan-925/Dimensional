package dimensional;

import java.util.ArrayList;
import java.util.function.Function;

public class DimensionalArray<T> {

	private int[] widths;
	private ArrayList<T> arr;

	public DimensionalArray(Function<Integer, T> function, int... widths) {
		this.widths = widths;
		int num = 1;
		for (int n : widths)
			num *= n;
		arr = new ArrayList<>(num);
		for (int i = 0; i < num; i++)
			arr.add(function.apply(i));
	}

	public DimensionalArray(T initial, int... widths) {
		this(n -> initial, widths);
	}
	
	public DimensionalArray(int... widths) {
		this(n -> null, widths);
	}

	private int getIndex(int[] indexes) {
		if (indexes.length != widths.length)
			throw new IllegalArgumentException("number of indexes must be equal to number of dimensions");

		int ind = 0, factor = 1;
		for (int i = 0; i < indexes.length; i++) {
			if(indexes[i] >= widths[i])
				throw new IllegalArgumentException("Index "+indexes[i]+" is out of bounds for length "+widths[i]);
			ind += indexes[i] * factor;
			factor *= widths[i];
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
