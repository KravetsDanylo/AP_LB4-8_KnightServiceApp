package knight;
import java.util.ArrayList;
import java.util.List;
import equipment.Ammunition;
public class Knight {
    private String name;
    private List<Ammunition> equipment;


    public Knight(String name) {
        this.name = name;
        this.equipment =new ArrayList<>();
    }

    public void equip(Ammunition item){}
    public void unequip(Ammunition item){}
    public double calculateTotalCost(){
        double totalCost = 0;
        return totalCost;
    }
    public void sortEquipmentByWeight(){}
    public List<Ammunition> findEquipmentByPrice(double min, double max){
        return new ArrayList<>();
    }



}
