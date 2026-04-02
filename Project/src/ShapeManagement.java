import java.util.Scanner;

public class ShapeManagement {
    public void display(){
        //Scanner
        Scanner cin = new Scanner(System.in);

        //Variables
        String choice = "47";
        String menu = "     ~~Menu~~\n";
        String askChoice = "Enter your choice: ";
        while(!choice.equals("0")){
            System.out.println(menu + askChoice);
            choice = cin.next();
        }
    }
}