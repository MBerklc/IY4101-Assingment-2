import java.util.Scanner;

public class ShapeManagement {
    ShapeList shapeList = new ShapeList();
    //Scanner
    Scanner cin = new Scanner(System.in);
    public void display(){

        String line = "\n----------------------------------------------------------";
        //Variables
        String choice = "47";
        String menu = "\n          ~~~ Menu ~~~\n1. Add a shape\n";
        menu += "2. Remove a shape by ID\n3. Get information about a shape by ID\n";
        menu += "4. Area and perimeter of a shape by ID\n5. Display information of all the shapes\n";
        menu+= "6. Translate all the shapes\n7. Scale all the shapes\n";
        menu += "0. Quit program";
        while(!choice.equals("0")){
            System.out.printf("%s %s \nEnter your choice: ", menu , line);
            choice = cin.next();
            switch(choice){
                case "0":
                    System.out.printf("Exiting...%s", line);
                    break;
                //----------------------------------------------------------
                case "1":
                    addShape();
                    System.out.println(line);
                    break;
                    //----------------------------------------------------------
                case "2":
                    removeShape();
                    System.out.printf("Going back to main menu %s", line);
                    break;
                    //----------------------------------------------------------
                case "3":
                    getShape();
                    System.out.printf("Going back to main menu %s", line);
                    break;
                    //----------------------------------------------------------
                case "4":
                    areaPerimeter();
                    System.out.printf("Going back to main menu %s", line);
                    break;
                    //----------------------------------------------------------
                case "5":
                    displayAll();
                    System.out.printf("Going back to main menu %s", line);
                    break;
                    //----------------------------------------------------------
                case "6":
                    translateShapes();
                    System.out.printf("Going back to main menu %s", line);
                    break;
                    //----------------------------------------------------------
                case "7":
                    scaleShapes();
                    System.out.printf("Going back to main menu %s", line);
                    break;
                    //----------------------------------------------------------
                default:
                    System.out.printf("Wrong input try again, %s", line);
                    break;
                    //----------------------------------------------------------
            }
        }
    }

    public void addShape(){
        String menu1 = " --Select your shape--\nFor circle enter 'C'\nFor square enter 'S'\n";
        menu1 += "For rectangle enter 'R'\nFor triangle enter 'T'\nFor exit enter 'E'";
        String line1 = "\n----------------------------";
        int x, y;
        String shapeChoice = "0";

        while(!shapeChoice.equals("E")){
            System.out.printf("%s\n%s %s \nEnter your choice: " ,line1, menu1 , line1);
            shapeChoice = cin.next().toUpperCase();

            switch (shapeChoice){
                case "C":
                    System.out.print("Enter X coordinate: ");
                    x = cin.nextInt();
                    System.out.print("Enter Y coordinate: ");
                    y = cin.nextInt();
                    System.out.print("Enter radius: ");
                    double radius = cin.nextDouble();
                    shapeList.addShape(new Circle(new Coordinates(x, y), radius));
                    System.out.println("Circle added! " + line1);
                    break;
                case "S":
                    System.out.print("Enter X coordinate: ");
                    x = cin.nextInt();
                    System.out.print("Enter Y coordinate: ");
                    y = cin.nextInt();
                    System.out.print("Enter side: ");
                    double side = cin.nextDouble();
                    shapeList.addShape(new Square(new Coordinates(x, y), side));
                    System.out.println("Square added! " + line1);
                    break;
                case "R":
                    System.out.println(line1);
                    System.out.print("Enter X coordinate: ");
                    x = cin.nextInt();
                    System.out.print("Enter Y coordinate: ");
                    y = cin.nextInt();
                    System.out.print("Enter length: ");
                    double length = cin.nextDouble();
                    System.out.print("Enter width: ");
                    double width = cin.nextDouble();
                    shapeList.addShape(new Rectangle(new Coordinates(x, y), length, width));
                    System.out.println("Rectangle added! " + line1);
                    break;
                case "T":
                    System.out.print("Enter vertexA's X coordinate: ");
                    int ax = cin.nextInt();
                    System.out.print("Enter vertexA's Y coordinate: ");
                    int ay = cin.nextInt();
                    Coordinates v1 = new Coordinates(ax, ay);
                    System.out.print("Enter vertexB's X coordinate: ");
                    int bx = cin.nextInt();
                    System.out.print("Enter vertexB's Y coordinate: ");
                    int by = cin.nextInt();
                    Coordinates v2 = new Coordinates(bx, by);
                    System.out.print("Enter vertexC's X coordinate: ");
                    int cx = cin.nextInt();
                    System.out.print("Enter vertexC's Y coordinate: ");
                    int cy = cin.nextInt();
                    Coordinates v3 = new Coordinates(cx, cy);
                    Triangle t1 = new Triangle(v1, v2, v3);

                    //Check if it's a real triangle
                    if(t1.getArea() != 0){
                        shapeList.addShape(t1);
                        System.out.println("Triangle added! " + line1);
                    } else System.out.print("This is not a triangle, try again...");
                    break;
                case "E":
                    System.out.printf("Going back to main menu... %s", line1);
                    break;
                default:
                    System.out.printf("Wrong input try again... %s" , line1);
                    break;
            }
        }
    }
    private void removeShape(){
        try {
            System.out.print("Enter ID to remove: ");
            int id = cin.nextInt();
            if(shapeList.isValid(id)) shapeList.removeShape(id);
            else System.out.println("Wrong ID try again...");
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number...");
            cin.next();
        }
    }

    private void getShape(){
        try {
            System.out.print("Enter ID to display: ");
            int id = cin.nextInt();
            if(shapeList.isValid(id)) System.out.println(shapeList.getShape(id).display());
            else System.out.println("Wrong ID try again...");
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number...");
            cin.next();
        }
    }

    private void areaPerimeter(){
        try {
            System.out.print("Enter ID to display area and perimeter: ");
            int id = cin.nextInt();
            if(shapeList.isValid(id)){
                System.out.println(shapeList.getShape(id).display());
                System.out.printf("Area: %.2f%n", shapeList.area(id));
                System.out.printf("Perimeter: %.2f%n", shapeList.perimeter(id));
            }
            else System.out.println("Wrong ID try again...");
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number...");
            cin.next();
        }
    }

    private void displayAll(){
        if (shapeList.size() == 0) System.out.println("There is no saved shape");
        else {
            System.out.println("      ---Saved Shapes---");
            System.out.println(shapeList.display() );
        }
    }
    private void translateShapes(){
        try {
            System.out.print("Translate X value: ");
            int dx = cin.nextInt();
            System.out.print("Translate Y value: ");
            int dy = cin.nextInt();
            shapeList.translateShapes(dx, dy);
            System.out.println("All shapes translated successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number...");
            cin.next();
        }
    }

    private void scaleShapes(){
        try {
            int factor;
            while(true){
                System.out.print("Provide scaling factor: ");
                factor = cin.nextInt();
                if(factor != 0) break;
                System.out.println("Factor zero is not acceptable!");
            }
            System.out.print("Provide scale sign (true/false): ");
            boolean sign = cin.nextBoolean();
            shapeList.scale(factor, sign);
            System.out.println("All shapes scaled successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number...");
            cin.next();
        }
    }
}
