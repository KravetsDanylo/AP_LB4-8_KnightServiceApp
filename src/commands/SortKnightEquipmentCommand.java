package commands;

public class SortKnightEquipmentCommand implements Command {
    private KnightService service;

    public SortKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.sortEquipmentByWeight();
    }
}
