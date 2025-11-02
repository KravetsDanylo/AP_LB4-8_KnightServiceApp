package commands;

public class UnequipKnightCommand implements Command{
    private KnightService service;

    public UnequipKnightCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.unequipKnight();    }
}
