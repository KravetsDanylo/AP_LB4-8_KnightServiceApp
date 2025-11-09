package commands;

import services.FileService;

public class LoadFromFileCommand implements Command {
    FileService service;

    public LoadFromFileCommand(FileService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.loadInformationFromFile();
    }

    @Override
    public String getDescription() {
        return "Load Knight and Arsenal information from file";
    }
}
