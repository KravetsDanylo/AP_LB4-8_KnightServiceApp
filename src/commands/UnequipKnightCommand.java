package commands;

import equipment.Ammunition;
import menu.ConsoleHelper;
import services.KnightService;

import java.util.List;

public class UnequipKnightCommand implements Command {
    private KnightService service;
    private ConsoleHelper consoleHelper;

    public UnequipKnightCommand(KnightService service, ConsoleHelper consoleHelper) {
        this.service = service;
        this.consoleHelper = consoleHelper;
    }

    @Override
    public void execute() {
        System.out.println("---UNEQUIPMENT OF THE KNIGHT---");
        List<Ammunition> knightItems = service.getKnightEquipment();
        if (knightItems.isEmpty()) {
            System.out.println("Knight Equipment is empty! Equip the knight.");
            return;
        }
        consoleHelper.displayListWithIndexes(knightItems);
        int index = consoleHelper.readIntInRange("Enter number of ammunition to remove", knightItems.size());
        Ammunition itemToRemove = knightItems.get(index);
        try{
            service.unequipKnight(itemToRemove);
            System.out.println(itemToRemove.getName() + " successfully removed from equipment.");

        }catch(IllegalArgumentException | IllegalStateException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Unequip knight";
    }
}
