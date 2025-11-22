package menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import commands.Command;


public class MenuController {
    private Map<Integer, Command> commands = new HashMap<>();
    private Scanner scanner;

    public MenuController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addCommand(int key, Command command) {
        commands.put(key, command);
    }

    public void runMenu() {
        System.out.println("======Knight Service app======");
        while (true) {
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    private void displayMenu() {
        System.out.println("===========MENU===========");
        for (Map.Entry<Integer, Command> command : commands.entrySet()) {
            System.out.println(command.getKey() + ". " + command.getValue().getDescription());
        }
    }
}
