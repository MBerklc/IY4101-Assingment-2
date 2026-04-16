public class Triangle extends Shape {
    private Coordinates vertexA;
    private Coordinates vertexB;
    private Coordinates vertexC;

    // Constructor
    public Triangle(Coordinates vertexA, Coordinates vertexB, Coordinates vertexC) {
        super(3, vertexA);
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    @Override
    public void scale(int factor, boolean sign) {
        vertexA.scale(factor, sign);
        vertexB.scale(factor, sign);
        vertexC.scale(factor, sign);
    }

    @Override
    public void translate(int dx, int dy) {
        vertexA.translate(dx, dy);
        vertexB.translate(dx, dy);
        vertexC.translate(dx, dy);
    }

    @Override
    public double getArea() {
        double a = vertexA.distance(vertexB);
        double b = vertexB.distance(vertexC);
        double c = vertexC.distance(vertexA);
        double s = (a + b + c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public double getPerimeter() {// if perimeter zero ask again
        double a = vertexA.distance(vertexB);
        double b = vertexB.distance(vertexC);
        double c = vertexC.distance(vertexA);
        return a + b + c;
    }

    @Override
    public String display() {
        return "Triangle at " + position.display() + ", VertexA: " + vertexA.display() + ", VertexB: " + vertexB.display() + ", VertexC: " + vertexC.display();
    }
}