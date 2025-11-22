package menu;

import equipment.Ammunition;

import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {
    private final Scanner scanner;

    public ConsoleHelper(Scanner scanner) {
        this.scanner = scanner;
    }
    public double readNonNegativeNumber(String prompt) {
        double value = -1.0;
        while (value < 0) {
            try {
                System.out.println(prompt);
                value = Double.parseDouble(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Invalid input! A number cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
        return value;
    }
    public double readPositiveNumber(String prompt) {
        double value = 0.0;
        while (value <= 0) {
            try {
                System.out.println(prompt);
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    System.out.println("Invalid input! A number must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
        return value;
    }

    public String readSpecificType(String prompt, String option1, String option2) {
        String input = "";
        while (!(input.equals(option1) || input.equals(option2))) {
            System.out.println(prompt);
            input = scanner.nextLine().trim().toLowerCase();
            if (!(input.equals(option1) || input.equals(option2))) {
                System.out.println("Invalid input! Enter a " + option1 + " or a " + option2);
            }
        }
        return input;
    }

    public boolean readBoolean(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            }
            if (input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Invalid input. Enter yes or no.");
        }
    }

    public String readNonEmptyString(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
        return input;
    }

    public void displayListWithIndexes(List<Ammunition> list) {
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
        }
    }

    public int readIntInRange(String prompt, int max) {
        int index = -1;
        while (index < 1 || index > max) {
            try {
                System.out.println(prompt + " (1 - " + max + "):");
                index = Integer.parseInt(scanner.nextLine());
                if (index < 1 || index > max) {
                    System.out.println("Invalid input! Enter the number from 1 to " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter the number.");
            }
        }
        return index - 1;
    }
}
