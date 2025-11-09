package commands;

import services.KnightService;

public class SortKnightEquipmentCommand implements Command {
    private KnightService service;

    public SortKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.sortEquipmentByWeight();
    }

    @Override
    public String getDescription() {
        return "Sort equipment by weight";
    }
}
