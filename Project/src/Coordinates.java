public class Coordinates {
    //Attributes
    private int x;
    private int y;
    //Constructor
    public Coordinates(int x1, int y1){
        this.x = x1;
        this.y = y1;
    }
    //Getters
    public int getX(){
        return  x;
    }
    public int getY(){
        return y;
    }
    // Distance between two coordinates
    public double distance(Coordinates p) {
        int distX = this.x - p.getX();
        int distY = this.y - p.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }

    // Translate the coordinate
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Scale the coordinate
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            this.x /= factor;
            this.y /= factor;
        }
    }

    // Display the current coordinate position
    public String display() {
        String msg = "X = " + x + ", Y = " + y;
        if (x < 0 || y < 0) {
            msg += "\nNote: Negative X or Y, Coordinates are out of zone.\n";
        }
        return msg;
    }

}
