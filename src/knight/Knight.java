package knight;

import java.util.ArrayList;
import java.util.List;

import equipment.Ammunition;

import java.io.Serial;
import java.io.Serializable;

public class Knight implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Ammunition> equipment;


    public Knight(String name) {
        this.name = name;
        this.equipment = new ArrayList<>();
    }

    public List<Ammunition> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Ammunition> equipment) {
        this.equipment = equipment;
    }

    public boolean equip(Ammunition item) {
        if (item == null) {
            return false;
        }
        if (isSlotFull(item.getSlotType())) {
            return false;
        }
        equipment.add(item);
        return true;
    }

    public boolean unequip(Ammunition item) {
        if (item == null) {
            return false;
        }
        return equipment.remove(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Ammunition ammunition : equipment) {
            totalCost += ammunition.getPrice();
        }
        return totalCost;
    }

    public void sortEquipmentByWeight() {
        equipment.sort((Ammunition a1, Ammunition a2) -> Double.compare(a1.getWeight(), a2.getWeight()));
    }

    public List<Ammunition> findEquipmentByPrice(double min, double max) {
        List<Ammunition> foundEquipment = new ArrayList<>();
        for (Ammunition ammunition : equipment) {
            if (ammunition.getPrice() >= min && ammunition.getPrice() <= max) {
                foundEquipment.add(ammunition);
            }
        }
        return foundEquipment;
    }

    private boolean isSlotFull(String slotType) {
        if (!slotType.equals("HELMET") && !slotType.equals("CHEST")) {
            return false;
        }
        for (Ammunition ammunition : equipment) {
            if (ammunition.getSlotType().equals(slotType)) {
                return true;
            }
        }
        return false;
    }
}
