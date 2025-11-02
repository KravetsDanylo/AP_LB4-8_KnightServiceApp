package commands;

public class ShowKnightEquipmentCommand implements Command {
    private KnightService service;

    public ShowKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.showKnightEquipment();
    }

}
