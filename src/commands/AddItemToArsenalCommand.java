package commands;

import equipment.*;
import menu.ConsoleHelper;
import services.KnightService;

public class AddItemToArsenalCommand implements Command {
    private KnightService service;
    private ConsoleHelper consoleHelper;

    public AddItemToArsenalCommand(KnightService service, ConsoleHelper consoleHelper) {
        this.service = service;
        this.consoleHelper = consoleHelper;
    }

    @Override
    public void execute() {

        while (true) {
            String name = consoleHelper.readNonEmptyString("Enter the name:");
            double weight = consoleHelper.readPositiveNumber("Enter a weight(in kg):");
            double price = consoleHelper.readPositiveNumber("Enter a price(in usd):");
            Ammunition newItem = null;
            String ammunitionType = consoleHelper.readSpecificType("Which type of ammunition to add(Weapon/Armor):", "weapon", "armor");
            if (ammunitionType.equals("weapon")) {
                double damage = consoleHelper.readPositiveNumber("Enter a damage(positive number):");
                String weaponType = consoleHelper.readSpecificType("Which type of weapon(Sword/Spear):", "sword", "spear");
                if (weaponType.equals("sword")) {
                    double bladeLength = consoleHelper.readPositiveNumber("Enter a blade length(in meter):");
                    boolean isOneHanded = consoleHelper.readBoolean("Sword is one handed(yes/no):");
                    newItem = new Sword(name, weight, price, damage, bladeLength, isOneHanded);
                } else {
                    String tipType = consoleHelper.readNonEmptyString("Enter a tip type:");
                    newItem = new Spear(name, weight, price, damage, tipType);
                }

            } else {
                double defence = consoleHelper.readPositiveNumber("Enter a defence:");
                String armorType = consoleHelper.readSpecificType("Which type of armor(Helmet/Breastplate)", "helmet", "breastplate");
                if (armorType.equals("helmet")) {
                    boolean hasVisor = consoleHelper.readBoolean("Helmet has visor:");
                    newItem = new Helmet(name, weight, price, defence, hasVisor);
                } else {
                    String material = consoleHelper.readNonEmptyString("Enter a material:");
                    newItem = new Breastplate(name, weight, price, defence, material);
                }
            }
            try{
                service.addNewItemToArsenal(newItem);
                System.out.println("New item successfully added to arsenal");
            } catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
            if(!consoleHelper.readBoolean("Do you want to continue(yes/no)?: ")){
                break;
            }
        }
    }

    @Override
    public String getDescription() {
        return "Add item to arsenal";
    }
}
