package services;

import equipment.*;
import knight.Knight;


import java.util.List;
import java.util.Scanner;

public class KnightService {
    private Knight knight;
    private Arsenal arsenal;
    private Scanner scanner;

    public KnightService(Knight knight, Arsenal arsenal) {
        this.knight = knight;
        this.arsenal = arsenal;
        this.scanner = new Scanner(System.in);
    }

    public void showArsenal() {
        System.out.println("---ARSENAL---");
        List<Ammunition> items = arsenal.getAvailableItems();
        if (items.isEmpty()) {
            System.out.println("Arsenal is empty. Firstly add equipments.");
        } else {
            for (Ammunition ammunition : items) {
                System.out.println(ammunition);
            }
        }
        System.out.println("---------------");
    }

    public void showKnightEquipment() {
        System.out.println("---KNIGHT EQUIPMENT---");
        List<Ammunition> knightEquipment = knight.getEquipment();
        if (knightEquipment.isEmpty()) {
            System.out.println("Knight Equipment is empty! Equip the knight.");
        } else {
            for (Ammunition ammunition : knightEquipment) {
                System.out.println(ammunition);
            }
        }
    }

    public void calculateTotalCost() {
        System.out.println("--- TOTAL COST OF EQUIPMENT ---");
        double totalCost = knight.calculateTotalCost();
        if (totalCost == 0) {
            System.out.println("Knight has no equipment. Total cost: 0.0");
        } else {
            System.out.println(String.format("Total cost: %.2f", totalCost));
        }
        System.out.println("---------------------------------");

    }

    public void sortEquipmentByWeight() {
        System.out.println("---SORTED EQUIPMENT OF THE KNIGHT(BY WEIGHT)---");
        if (knight.getEquipment().isEmpty()) {
            System.out.println("There is no equipment yet.");
            return;
        }
        knight.sortEquipmentByWeight();
        for (Ammunition ammunition : knight.getEquipment()) {
            System.out.println(ammunition);
        }
    }

    public void findEquipmentByPrice() {
        System.out.println("---FOUND EQUIPMENT BY PRICE---");
        double min = 0.1;
        double max = 0.0;
        while (min > max) {
            min = readNonNegativeNumber("Enter the first price(min):");
            max = readNonNegativeNumber("Enter the second price(max):");
            if (min > max) {
                System.out.println("Invalid input. The first price cannot be larger than the second price. Try again");
            }
        }
        System.out.println("---Equipment by price(" + min + " - " + max + ")---");
        List<Ammunition> foundEquipment = knight.findEquipmentByPrice(min, max);
        if (foundEquipment.isEmpty()) {
            System.out.println("No equipment found in this price range.");
        } else {
            for (Ammunition ammunition : foundEquipment) {
                System.out.println(ammunition);
            }
        }
    }

    public void equipKnight() {
        System.out.println("---EQUIPMENT OF THE KNIGHT---");
        showArsenal();
        List<Ammunition> arsenalItems = arsenal.getAvailableItems();
        if (arsenalItems.isEmpty()) {
            return;
        }
        displayListWithIndexes(arsenalItems);
        int index = readIntInRange("Enter number of ammunition to equip", arsenalItems.size());
        Ammunition itemToEquip = arsenalItems.get(index);
        boolean success = knight.equip(itemToEquip);
        if (success) {
            arsenal.removeItem(itemToEquip);
            System.out.println(itemToEquip.getName() + " successfully added to equipment.");
        } else {
            System.out.println("Impossible to equip " + itemToEquip.getName() + ". Slot " + itemToEquip.getSlotType() + " already taken.");
        }
    }

    public void unequipKnight() {
        System.out.println("---UNEQUIPMENT OF THE KNIGHT---");
        showKnightEquipment();
        List<Ammunition> knightItems = knight.getEquipment();
        if (knightItems.isEmpty()) {
            return;
        }
        displayListWithIndexes(knightItems);
        int index = readIntInRange("Enter number of ammunition to remove", knightItems.size());
        Ammunition itemToRemove = knightItems.get(index);
        boolean success = knight.unequip(itemToRemove);
        if (success) {
            arsenal.addItem(itemToRemove);
            System.out.println(itemToRemove.getName() + " successfully removed from equipment.");
        } else {
            System.out.println("Impossible to remove the ammunition.");
        }
    }

    public void addNewItemToArsenal() {
        String name = "";
        Double weight = 0.0;
        Double price = 0.0;
        while (true) {
            name = readNonEmptyString("Enter the name:");
            weight = readPositiveNumber("Enter a weight(in kg):");
            price = readPositiveNumber("Enter a price(in usd):");
            Ammunition newItem = null;
            String ammunitionType = readSpecificType("Which type of ammunition to add(Weapon/Armor):", "weapon", "armor");
            if (ammunitionType.equals("weapon")) {
                double damage = readPositiveNumber("Enter a damage(positive number):");
                String weaponType = readSpecificType("Which type of weapon(Sword/Spear):", "sword", "spear");
                if (weaponType.equals("sword")) {
                    double bladeLength = readPositiveNumber("Enter a blade length(in meter):");
                    boolean isOneHanded = readBoolean("Sword is one handed(yes/no):");
                    newItem = new Sword(name, weight, price, damage, bladeLength, isOneHanded);
                } else {
                    String tipType = readNonEmptyString("Enter a tip type:");
                    newItem = new Spear(name, weight, price, damage, tipType);
                }

            } else {
                double defence = readPositiveNumber("Enter a defence:");
                String armorType = readSpecificType("Which type of armor(Helmet/Breastplate)", "helmet", "breastplate");
                if (armorType.equals("helmet")) {
                    boolean hasVisor = readBoolean("Helmet has visor:");
                    newItem = new Helmet(name, weight, price, defence, hasVisor);
                } else {
                    String material = readNonEmptyString("Enter a material:");
                    newItem = new Breastplate(name, weight, price, defence, material);
                }
            }
            if (newItem != null) {
                arsenal.addItem(newItem);
                System.out.println("New item successfully added to arsenal");
                System.out.println("Do you want to continue(yes/no)?: ");
                String userInput = scanner.nextLine().trim().toLowerCase();
                if (userInput.equals("no") || userInput.equals("n")) break;
            }
        }
    }

    private double readPositiveNumber(String prompt) {
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

    private double readNonNegativeNumber(String prompt) {
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

    private String readSpecificType(String prompt, String option1, String option2) {
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

    private boolean readBoolean(String prompt) {
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

    private String readNonEmptyString(String prompt) {
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

    private void displayListWithIndexes(List<Ammunition> list) {
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
        }
    }

    private int readIntInRange(String prompt, int max) {
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
