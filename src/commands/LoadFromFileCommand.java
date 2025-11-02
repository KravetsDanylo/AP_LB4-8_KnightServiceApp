package commands;

import knight.Knight;

public class LoadFromFileCommand implements Command{
    KnightService service;

    public LoadFromFileCommand(KnightService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.loadFromFile();
    }
}
