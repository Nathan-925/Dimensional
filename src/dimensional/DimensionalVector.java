package dimensional;

public class DimensionalVector {

	public static DimensionalVector add(DimensionalVector v1, DimensionalVector v2) {
		if (v1.getDimension() != v2.getDimension())
			throw new IllegalArgumentException("vectors must be in the same dimension");
		double arr[] = new double[v1.getDimension()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = v1.getMagnitude(i) + v2.getMagnitude(i);
		return new DimensionalVector(arr);
	}

	public static double dotProduct(DimensionalVector v1, DimensionalVector v2) {
		if (v1.getDimension() != v2.getDimension())
			throw new IllegalArgumentException("vectors must be in the same dimension");
		double d = 0;
		for (int i = 0; i < v1.getDimension(); i++)
			d += v1.getMagnitude(i) * v2.getMagnitude(i);
		return d;
	}

	private double[] arr;

	public DimensionalVector(double... magnitudes) {
		arr = magnitudes;
	}

	public void normalize() {
		double mag = getMagnitude();
		for (int i = 0; i < arr.length; i++) {
			arr[i] /= mag;
		}
	}

	public double getMagnitude() {
		double num = 0;
		for (double d : arr)
			num += d * d;
		return Math.sqrt(num);
	}

	public double getMagnitude(int dimension) {
		return arr[dimension];
	}

	public int getDimension() {
		return arr.length;
	}

}
