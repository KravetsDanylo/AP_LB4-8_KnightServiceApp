package commands;

public class LoadToFileCommand implements Command{
    KnightService service;

    public LoadToFileCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.loadToFile();
    }
}
