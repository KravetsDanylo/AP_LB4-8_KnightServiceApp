package commands;

import services.KnightService;

public class FindKnightEquipmentCommand implements Command {
    private KnightService service;

    public FindKnightEquipmentCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.findEquipmentByPrice();
    }

    @Override
    public String getDescription() {
        return "Find equipment by price(price1 - price2)";
    }
}
