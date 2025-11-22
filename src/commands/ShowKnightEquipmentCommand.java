package commands;

import equipment.Ammunition;
import services.KnightService;

import java.util.List;

public class ShowKnightEquipmentCommand implements Command {
    private KnightService service;

    public ShowKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("---KNIGHT EQUIPMENT---");
        List<Ammunition> knightEquipment = service.getKnightEquipment();
        if (knightEquipment.isEmpty()) {
            System.out.println("Knight Equipment is empty! Equip the knight.");
        } else {
            for (Ammunition ammunition : knightEquipment) {
                System.out.println(ammunition);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Show knight equipment";
    }
}
