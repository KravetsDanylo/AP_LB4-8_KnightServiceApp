package menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import commands.Command;


public class MenuController {
    private Map<Integer, Command> commands = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCommand(int key, Command command){
        commands.put(key, command);
    }

    public void runMenu(){
        System.out.println("======Knight Service app======");
        while(true){
            displayMenu();
            System.out.println("Your choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                Command command = commands.get(choice);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Invalid value. Please try again");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please try again");
            }
        }

    }

    private void displayMenu(){
        System.out.println("===========MENU===========");
        System.out.println("1.  Show arsenal");
        System.out.println("2.  Add item to arsenal");
        System.out.println("3.  Show knight equipment");
        System.out.println("4.  Equip knight");
        System.out.println("5.  Unequip knight");
        System.out.println("6.  Find equipment by price(price1 between price2)");
        System.out.println("7.  Sort equipment by weight");
        System.out.println("8.  Calculate total cost of knight equipment");
        System.out.println("9.  Load Knight and Arsenal information to file");
        System.out.println("10. Load Knight and Arsenal information from file");
        System.out.println("0.  Exit the program");

    }



}
