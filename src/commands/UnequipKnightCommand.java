package commands;

import services.KnightService;

public class UnequipKnightCommand implements Command {
    private KnightService service;

    public UnequipKnightCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.unequipKnight();
    }

    @Override
    public String getDescription() {
        return "Unequip knight";
    }
}
