public abstract class Shape {
    // Attributes
    protected Coordinates position;
    protected int sides; // Not needed but included for completeness

    // Constructor
    public Shape(int noOfSides, Coordinates coord) {
        this.position = coord;
        this.sides = noOfSides;
    }

    // Get coordinates of the object
    public Coordinates getCoordinates() {
        return position;
    }

    // Get the number of sides of the shape
    public int getSides() {
        return sides;
    }

    // Set new coordinates
    public void setCoordinates(Coordinates newCoord) {
        this.position = newCoord;
    }

    // Translate the shape
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    // Abstract methods (must be implemented by subclasses)
    public abstract void scale(int factor, boolean sign);
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String display();
}

