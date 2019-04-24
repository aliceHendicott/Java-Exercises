package oop.Shapes;

public class Main {

    public static void main(String[] args){
        Shape a = new Tetrahedron(5);
        System.out.println(a.volume());

        Shape b = new SquarePyramid(3, 5);
        Shape c = new Cone(4, 2);
        Shape[] shapes = {a, b, c};

        double volumeTotal = ShapeHandler.volumeSum(shapes);
        double surfaceAreaTotal = ShapeHandler.surfaceAreaSum(shapes);

        System.out.println("Total volume: " + volumeTotal);
        System.out.println("Total surface area: " + surfaceAreaTotal);
    }

}
