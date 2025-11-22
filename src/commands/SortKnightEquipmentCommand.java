package commands;

import equipment.Ammunition;
import services.KnightService;

public class SortKnightEquipmentCommand implements Command {
    private KnightService service;

    public SortKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("---SORTED EQUIPMENT OF THE KNIGHT(BY WEIGHT)---");
        boolean success = service.sortEquipmentByWeight();
        if(!success){
            System.out.println("Knight equipment is empty!");
        }
        else{
            for (Ammunition ammunition : service.getKnightEquipment()) {
                System.out.println(ammunition);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Sort equipment by weight";
    }
}
