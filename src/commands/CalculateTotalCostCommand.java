package commands;

public class CalculateTotalCostCommand implements Command {
    private KnightService service;

    public CalculateTotalCostCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.calculateTotalCost();
    }
}
