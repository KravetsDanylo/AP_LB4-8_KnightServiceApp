package services;

import equipment.Arsenal;
import knight.Knight;

import java.io.*;

public class FileService {


    public static class LoadedData {
        public final Knight knight;
        public final Arsenal arsenal;

        public LoadedData(Knight knight, Arsenal arsenal) {
            this.knight = knight;
            this.arsenal = arsenal;
        }
    }

    public void saveInformationToFile(ObjectOutputStream oos, Knight knight, Arsenal arsenal) throws IOException{
        oos.writeObject(knight);
        oos.writeObject(arsenal);
    }

    public LoadedData loadInformationFromFile(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Knight loadedKnight = (Knight) ois.readObject();
        Arsenal loadedArsenal = (Arsenal) ois.readObject();
        return new LoadedData(loadedKnight, loadedArsenal);
    }
}
