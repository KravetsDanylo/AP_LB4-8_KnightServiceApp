package commands;

public class FindKnightEquipmentCommand implements Command{
    private KnightService service;

    public FindKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.findEquipmentByPrice();
    }
}
