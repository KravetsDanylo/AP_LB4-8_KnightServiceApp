package commands;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Exit the program";
    }
}
