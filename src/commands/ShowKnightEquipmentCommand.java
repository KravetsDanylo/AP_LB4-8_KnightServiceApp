package commands;

import services.KnightService;

public class ShowKnightEquipmentCommand implements Command {
    private KnightService service;

    public ShowKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.showKnightEquipment();
    }

    @Override
    public String getDescription() {
        return "Show knight equipment";
    }
}
