package oop.Shapes;

public class ShapeHandler {

	// Returns the sum of the volumes of the given shapes.
	public static double volumeSum(Shape[] shapes) {
		double total = 0;
		for (Shape shape : shapes){
			double volume = shape.volume();
			total += volume;
		}
		return total;

	}

	// Returns the sum of the surface areas of the given shapes.
	public static double surfaceAreaSum(Shape[] shapes) {
		double total = 0;
		for (Shape shape : shapes){
			double surfaceArea = shape.surfaceArea();
			total += surfaceArea;
		}
		return total;
	}
}