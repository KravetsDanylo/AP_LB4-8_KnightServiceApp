package commands;

import services.FileService;

public class LoadToFileCommand implements Command {
    FileService service;

    public LoadToFileCommand(FileService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.saveInformationToFile();
    }

    @Override
    public String getDescription() {
        return "Save Knight and Arsenal information to file";
    }
}
