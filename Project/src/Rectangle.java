public class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(Coordinates coord, double length, double width) {
        super(4, coord);
        this.length = length;
        this.width = width;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.length *= factor;
            this.width *= factor;
        } else {
            this.length /= factor;
            this.width /= factor;
        }
    }

    @Override
    public double getArea() {return length * width;}

    @Override
    public double getPerimeter() {return (2 * width)+ (2 * length);}

    @Override
    public String display() {return "Rectangle at " + position.display() + ", Length: " + length + " ,Width: " + width;}
}