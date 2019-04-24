package oop.Shapes;

public class Tetrahedron implements Shape {

    //Private properties
    private double edge;

    // Constructs a Tetrahedron shape with edge
    public Tetrahedron(double edge){
        this.edge = edge;
    }

    public double volume(){
        double volume = Math.pow(edge, 3) / (6 * Math.sqrt(2));
        return volume;
    }

    public double surfaceArea(){
        double surfaceArea = Math.sqrt(3) * Math.pow(edge, 2);
        return surfaceArea;
    }
}
