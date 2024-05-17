package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import model.SpaceMarine;
import service.dataProviderService.JSONProvider;

public class UpdateCommand implements Command {
    private SpaceMarineCollection collection;
    private JSONProvider json;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public UpdateCommand(SpaceMarineCollection collection) throws IOException {
        this.collection = collection;
        this.json = new JSONProvider("tmp.json");
    }

    @Override
    public void executeFromConsole(String argument) {
        try {
            if (argument == null || argument.trim().isEmpty()) {
                throw new IllegalArgumentException("ID для обновления не указан.");
            }
            System.out.println("> Выполнение команды update из консоли");
            SpaceMarine spaceMarine = collection.updateElementFromConsole(argument);
            collection.update(spaceMarine);
            //json.write(SpaceMarineCollection.getSpaceMarines().values());
            System.out.println("> " + ANSI_YELLOW + "show" + ANSI_RESET + " - посмотреть обновленную коллекцию");
        } catch (IllegalArgumentException e) {
            System.out.println("> " + ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }

    @Override
    public void executeFromFile(String argument) {
        try {
            if (argument == null || argument.trim().isEmpty()) {
                throw new IllegalArgumentException("ID для обновления не указан.");
            }
            System.out.println("> Выполнение команды update из файла");
            SpaceMarine spaceMarine = collection.updateElementFromFile(argument);
            collection.update(spaceMarine);
            //json.write(SpaceMarineCollection.getSpaceMarines().values());
            System.out.println("> " + ANSI_YELLOW + "show" + ANSI_RESET + " - посмотреть обновленную коллекцию");
        } catch (IllegalArgumentException e) {
            System.out.println("> " + ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }
}
