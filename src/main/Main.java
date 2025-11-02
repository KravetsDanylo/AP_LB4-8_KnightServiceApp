package main;
import commands.*;
import equipment.Arsenal;
import knight.Knight;
import menu.MenuController;


public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight("knight1");
        Arsenal arsenal = new Arsenal();
        KnightService service = new KnightService(knight, arsenal);
        MenuController menu = new MenuController();
        menu.addCommand(1, new ShowArsenalCommand(service));
        menu.addCommand(2, new AddItemToArsenalCommand(service));
        menu.addCommand(3, new ShowKnightEquipmentCommand(service));
        menu.addCommand(4, new EquipKnightCommand(service));
        menu.addCommand(5, new UnequipKnightCommand(service));
        menu.addCommand(6, new FindKnightEquipmentCommand(service));
        menu.addCommand(7, new SortKnightEquipmentCommand(service));
        menu.addCommand(8, new CalculateTotalCostCommand(service));
        menu.addCommand(9, new LoadToFileCommand(service));
        menu.addCommand(10, new LoadFromFileCommand(service));
        menu.addCommand(0, new ExitCommand());
        menu.runMenu();


    }
}
