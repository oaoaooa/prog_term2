package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import service.dataProviderService.JSONProvider;

public class ClearCommand implements Command {
    private SpaceMarineCollection collection;
    private JSONProvider json;

    public ClearCommand(SpaceMarineCollection collection) {
        this.collection = collection;
        this.json = new JSONProvider("tmp.json");
    }

    @Override
    public void executeFromConsole(String argument) {
        try {
            collection.clear();
            SpaceMarineCollection.lastId = 0;
            System.out.println("Коллекция очищена!");
            json.write(SpaceMarineCollection.getSpaceMarines().values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeFromFile(String argument) {
        try {
            collection.clear();
            System.out.println("Коллекция очищена!");
            json.write(SpaceMarineCollection.getSpaceMarines().values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
