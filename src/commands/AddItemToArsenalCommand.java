package commands;

import services.KnightService;

public class AddItemToArsenalCommand implements Command {
    private KnightService service;

    public AddItemToArsenalCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.addNewItemToArsenal();
    }

    @Override
    public String getDescription() {
        return "Add item to arsenal";
    }
}
