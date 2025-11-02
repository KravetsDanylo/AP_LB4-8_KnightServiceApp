package commands;

public class EquipKnightCommand implements Command{
    private KnightService service;

    public EquipKnightCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.equipKnight();
    }
}
