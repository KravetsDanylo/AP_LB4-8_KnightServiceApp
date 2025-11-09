package services;

import equipment.Arsenal;
import knight.Knight;

import java.io.*;

public class FileService {
    private String filename;
    private Knight knight;
    private Arsenal arsenal;

    public FileService(String filename, Knight knight, Arsenal arsenal) {
        this.filename = filename;
        this.knight = knight;
        this.arsenal = arsenal;
    }

    public boolean saveInformationToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(knight);
            oos.writeObject(arsenal);
            System.out.println("Knight and Arsenal successfully saved to file " + filename);
            return true;
        } catch (IOException e) {
            System.out.println("Cannot save to file!" + e.getMessage());
            return false;
        }
    }

    public boolean loadInformationFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Knight loadedKnight = (Knight) ois.readObject();
            Arsenal loadedArsenal = (Arsenal) ois.readObject();
            knight.setEquipment(loadedKnight.getEquipment());
            arsenal.setAvailableItems(loadedArsenal.getAvailableItems());
            System.out.println("Knight and Arsenal successfully loaded from file " + filename);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file.");
            return false;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load from file.");
            return false;
        }
    }
}
