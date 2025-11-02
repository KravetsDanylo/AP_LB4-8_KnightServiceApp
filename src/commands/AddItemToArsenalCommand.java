package commands;

public class AddItemToArsenalCommand implements Command{
    private KnightService service;

    public AddItemToArsenalCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.addNewItemToArsenal();
    }
}
