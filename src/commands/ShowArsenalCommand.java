package commands;

public class ShowArsenalCommand implements Command{
    KnightService service;

    public ShowArsenalCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute(){
        service.showArsenal();
    }
}
