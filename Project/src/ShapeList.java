import java.util.ArrayList;

class ShapeList {
    private ArrayList<Shape> listOfShapes;

    public ShapeList() {
        listOfShapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        listOfShapes.add(s);
    }

    public void translateShapes(int dx, int dy) {
        for (Shape each : listOfShapes) {
            each.translate(dx, dy);
        }
    }

    public Shape getShape(int id) {
        return listOfShapes.get(id - 1);
    }

    public Shape removeShape(int id) {
        return listOfShapes.remove(id - 1);
    }

    public double area(int id) {
        return listOfShapes.get(id - 1).getArea();
    }

    public void scale(int factor, boolean sign) {
        for (Shape each : listOfShapes) {
            each.scale(factor, sign);
        }
    }

    public double perimeter(int id) {
        return listOfShapes.get(id - 1).getPerimeter();
    }

    public String display() {
        StringBuilder displayString = new StringBuilder();
        int id = 1;
        for (Shape each : listOfShapes) {
            displayString.append("\nID (Required to find a shape) : ").append(id).append("\n");
            displayString.append(each.display()).append("\n");
            id++;
        }
        return displayString.toString();
    }

    public int size() {
        return listOfShapes.size();
    }

    public boolean isValid(int id) {
        return id > 0 && id <= listOfShapes.size();
    }
}
