package dimensional;

public class DimensionalVector {

	public static DimensionalVector add(DimensionalVector v1, DimensionalVector v2) {
		if(v1.getDimensions() != v2.getDimensions())
			throw new IllegalArgumentException("vectors must be in the same dimension");
		double arr[] = new double[v1.getDimensions()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = v1.getMagnitude(i) + v2.getMagnitude(i);
		return new DimensionalVector(arr);
	}
	
	private double[] arr;
	
	public DimensionalVector(double ... magnitudes) {
		arr = magnitudes;
	}
	
	public void normalize() {
		double mag = getMagnitude();
		for(int i = 0; i < arr.length; i++) {
			arr[i] /= mag;
		}
	}
	
	public double dotProduct(DimensionalVector v) {
		if(arr.length != v.getDimensions())
			throw new IllegalArgumentException("vectors must be in the same dimension");
		double d = 0;
		for(int i = 0; i < arr.length; i++)
			d += arr[i] * v.getMagnitude(i);
		return d;
	}
	
	public double getMagnitude() {
		double num = 0;
		for(double d: arr)
			num += d*d;
		return Math.sqrt(num);
	}
	
	public double getMagnitude(int dimension) {
		return arr[dimension];
	}
	
	public int getDimensions() {
		return arr.length;
	}
	
	public static void main(String[] args) {
		DimensionalVector test = new DimensionalVector(1, 2, 3);
		System.out.println(test.getMagnitude());
		test.normalize();
		System.out.println(test.getMagnitude());
	}
	
}
