package commands;

import equipment.Ammunition;
import menu.ConsoleHelper;
import services.KnightService;

import java.util.List;

public class EquipKnightCommand implements Command {
    private KnightService service;
    private ConsoleHelper  consoleHelper;

    public EquipKnightCommand(KnightService service, ConsoleHelper consoleHelper) {
        this.service = service;
        this.consoleHelper = consoleHelper;
    }

    @Override
    public void execute() {
        System.out.println("---EQUIPMENT OF THE KNIGHT---");
        List<Ammunition> arsenalItems = service.getArsenal();
        if (arsenalItems.isEmpty()) {
            System.out.println("Arsenal is empty. Firstly add the item to arsenal");
            return;
        }
        consoleHelper.displayListWithIndexes(arsenalItems);
        int index = consoleHelper.readIntInRange("Enter number of ammunition to equip", arsenalItems.size());
        Ammunition itemToEquip = arsenalItems.get(index);
         try{
             service.equipKnight(itemToEquip);
             System.out.println(itemToEquip.getName() + " successfully added to equipment.");
         } catch (IllegalArgumentException | IllegalStateException e){
             System.out.println("Error: " + e.getMessage());
         }
    }

    @Override
    public String getDescription() {
        return "Equip knight";
    }
}
