package commands;

import equipment.Ammunition;
import services.KnightService;

import java.util.List;

public class ShowArsenalCommand implements Command {
    KnightService service;

    public ShowArsenalCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("---ARSENAL---");
        List<Ammunition> items = service.getArsenal();
        if (items.isEmpty()) {
            System.out.println("Arsenal is empty. Firstly add equipments.");
        } else {
            for (Ammunition ammunition : items) {
                System.out.println(ammunition);
            }
        }
        System.out.println("---------------");
    }

    @Override
    public String getDescription() {
        return "Show arsenal";
    }
}
