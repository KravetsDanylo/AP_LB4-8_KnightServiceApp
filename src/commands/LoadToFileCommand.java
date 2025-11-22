package commands;

import equipment.Arsenal;
import knight.Knight;
import services.FileService;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LoadToFileCommand implements Command {
    private FileService service;
    private String filename;
    private Knight knight;
    private Arsenal arsenal;

    public LoadToFileCommand(FileService service, String filename, Knight knight, Arsenal arsenal) {
        this.service = service;
        this.filename = filename;
        this.knight = knight;
        this.arsenal = arsenal;
    }

    @Override
    public void execute() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            service.saveInformationToFile(oos, knight, arsenal);
            System.out.println("Knight and Arsenal successfully saved to file " + filename);
        } catch (Exception e){
            System.out.println("Cannot save to file: " + e.getMessage());
        }

    }

    @Override
    public String getDescription() {
        return "Save Knight and Arsenal information to file";
    }
}
