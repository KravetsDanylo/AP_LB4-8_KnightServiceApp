package services;

import equipment.*;
import knight.Knight;


import java.util.List;


public class KnightService {
    private Knight knight;
    private Arsenal arsenal;


    public KnightService(Knight knight, Arsenal arsenal) {
        this.knight = knight;
        this.arsenal = arsenal;

    }

    public List<Ammunition> getArsenal() {
        return arsenal.getAvailableItems();
    }

    public List<Ammunition> getKnightEquipment() {
        return knight.getEquipment();
    }

    public double calculateTotalCost() {
        return knight.calculateTotalCost();
    }

    public boolean sortEquipmentByWeight() {
        if(knight.getEquipment().isEmpty()){
            return false;
        }
        knight.sortEquipmentByWeight();
        return true;
    }

    public List<Ammunition> findEquipmentByPrice(double min, double max) {
        if(min > max){
            throw new IllegalArgumentException("Invalid input. The first price cannot be larger than the second price.");
        }
        return knight.findEquipmentByPrice(min, max);
    }

    public void equipKnight(Ammunition itemToEquip) {
        if(itemToEquip == null){
            throw new IllegalArgumentException("Item to equip cannot be null.");
        }
        if(!arsenal.getAvailableItems().contains(itemToEquip)){
            throw new IllegalStateException(itemToEquip.getName() + "is not in the arsenal.");
        }
        boolean success = knight.equip(itemToEquip);
        if(success){
            arsenal.removeItem(itemToEquip);
        } else{
            throw new IllegalStateException("Impossible to equip " + itemToEquip.getName() + ". Slot " + itemToEquip.getSlotType() + " already taken.");
        }

    }

    public void unequipKnight(Ammunition itemToRemove) {
        if(itemToRemove == null){
            throw new IllegalArgumentException("Item to unequip cannot be null.");
        }
        boolean success = knight.unequip(itemToRemove);
        if(success){
            arsenal.addItem(itemToRemove);
        } else{
            throw new IllegalStateException("Impossible to remove the ammunition. Item not found in equipment.");
        }
    }

    public void addNewItemToArsenal(Ammunition newItem) {
        if(newItem == null){
            throw new IllegalArgumentException("Cannot add null item to arsenal");
        }
        arsenal.addItem(newItem);
    }


}
