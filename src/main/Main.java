package main;

import commands.*;
import menu.ConsoleHelper;
import services.FileService;
import services.KnightService;
import equipment.Arsenal;
import knight.Knight;
import menu.MenuController;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight("knight1");
        Arsenal arsenal = new Arsenal();
        Scanner scanner = new Scanner(System.in);
        ConsoleHelper consoleHelper = new ConsoleHelper(scanner);
        KnightService service = new KnightService(knight, arsenal);
        FileService fileService = new FileService();
        MenuController menu = new MenuController(scanner);
        menu.addCommand(1, new ShowArsenalCommand(service));
        menu.addCommand(2, new AddItemToArsenalCommand(service, consoleHelper));
        menu.addCommand(3, new ShowKnightEquipmentCommand(service));
        menu.addCommand(4, new EquipKnightCommand(service, consoleHelper));
        menu.addCommand(5, new UnequipKnightCommand(service, consoleHelper));
        menu.addCommand(6, new FindKnightEquipmentCommand(service, consoleHelper));
        menu.addCommand(7, new SortKnightEquipmentCommand(service));
        menu.addCommand(8, new CalculateTotalCostCommand(service));
        menu.addCommand(9, new LoadToFileCommand(fileService, "KnightInformation.txt", knight, arsenal));
        menu.addCommand(10, new LoadFromFileCommand(fileService, "KnightInformation.txt", knight, arsenal));
        menu.addCommand(0, new ExitCommand());
        menu.runMenu();
    }
}
