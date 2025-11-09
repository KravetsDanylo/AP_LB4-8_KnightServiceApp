package commands;

import services.KnightService;

public class CalculateTotalCostCommand implements Command {
    private KnightService service;

    public CalculateTotalCostCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.calculateTotalCost();
    }

    @Override
    public String getDescription() {
        return "Calculate total cost of knight equipment";
    }
}
