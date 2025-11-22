package commands;

import services.KnightService;

public class CalculateTotalCostCommand implements Command {
    private KnightService service;

    public CalculateTotalCostCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("--- TOTAL COST OF EQUIPMENT ---");
        double totalCost = service.calculateTotalCost();
        if (totalCost == 0) {
            System.out.println("Knight has no equipment. Total cost: 0.0");
        } else {
            System.out.println(String.format("Total cost: %.2f", totalCost));
        }
        System.out.println("---------------------------------");
    }

    @Override
    public String getDescription() {
        return "Calculate total cost of knight equipment";
    }
}
