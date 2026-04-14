import java.util.Scanner;

public class ShapeManagement {
    public void display(){
        //Scanner
        Scanner cin = new Scanner(System.in);

        String line = "\n----------------------------------------------------------";
        //Variables
        String choice = "47";
        String menu = "     ~~Menu~~\n";
        while(!choice.equals("0")){
            choice = "Enter your choice: ";
            System.out.println(menu + choice);
            choice = cin.next();
            switch(choice){
                case "0":
                    System.out.printf("Exiting...%s", line);
                //----------------------------------------------------------
                case "1":
                //----------------------------------------------------------
                //----------------------------------------------------------
                //----------------------------------------------------------
                //----------------------------------------------------------
                //----------------------------------------------------------
            }
        }
    }
}