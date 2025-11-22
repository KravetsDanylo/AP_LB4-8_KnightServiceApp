package commands;

import equipment.Ammunition;
import menu.ConsoleHelper;
import services.KnightService;

import java.util.List;


public class FindKnightEquipmentCommand implements Command {
    private KnightService service;
    private ConsoleHelper consoleHelper;

    public FindKnightEquipmentCommand(KnightService service, ConsoleHelper consoleHelper) {
        this.service = service;
        this.consoleHelper = consoleHelper;
    }

    @Override
    public void execute() {
        System.out.println("---SEARCH EQUIPMENT BY PRICE---");

        double min = consoleHelper.readNonNegativeNumber("Enter the first price(min):");
        double max = consoleHelper.readNonNegativeNumber("Enter the second price(max):");

        try {
            System.out.println("---Equipment by price(" + min + " - " + max + ")---");
            List<Ammunition> foundEquipment = service.findEquipmentByPrice(min, max);
            if (foundEquipment.isEmpty()) {
                System.out.println("No equipment found in this price range.");
            } else {
                for (Ammunition ammunition : foundEquipment) {
                    System.out.println(ammunition);
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Find equipment by price(price1 - price2)";
    }
}
