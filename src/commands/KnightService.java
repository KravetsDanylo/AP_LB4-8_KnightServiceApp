package commands;
import equipment.*;
import knight.Knight;

public class KnightService {
    private Knight knight;
    private Arsenal arsenal;

    public KnightService(Knight knight, Arsenal arsenal) {
        this.knight = knight;
        this.arsenal = arsenal;
    }

    public void showArsenal(){}
    public void showKnightEquipment(){}
    public void calculateTotalCost(){}
    public void sortEquipmentByWeight(){}
    public void findEquipmentByPrice(){}
    public void equipKnight(){}
    public void unequipKnight(){}
    public void addNewItemToArsenal(){}
    public void loadToFile(){}
    public void loadFromFile(){}

}
