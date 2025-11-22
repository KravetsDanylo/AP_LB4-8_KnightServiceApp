package commands;

import equipment.Arsenal;
import knight.Knight;
import services.FileService;

import java.io.*;


public class LoadFromFileCommand implements Command {
    private FileService service;
    private String filename;
    private Knight knight;
    private Arsenal arsenal;

    public LoadFromFileCommand(FileService service, String filename, Knight knight, Arsenal arsenal) {
        this.service = service;
        this.filename = filename;
        this.knight = knight;
        this.arsenal = arsenal;
    }

    @Override
    public void execute() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            FileService.LoadedData data = service.loadInformationFromFile(ois);
            knight.setEquipment(data.knight.getEquipment());
            arsenal.setAvailableItems(data.arsenal.getAvailableItems());
            System.out.println("Knight and Arsenal successfully loaded from file " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load from file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Failed to update objects. Loaded data might be corrupted.");
        }
    }

    @Override
    public String getDescription() {
        return "Load Knight and Arsenal information from file";
    }
}
