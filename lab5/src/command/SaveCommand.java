package command;

import collection.SpaceMarineCollection;
import command.interfaces.Command;
import java.io.IOException;
import service.dataProviderService.JSONProvider;

public class SaveCommand implements Command {
    private JSONProvider json;

    public SaveCommand() {
        json = new JSONProvider("mainCollection.json");
    }

    @Override
    public void executeFromConsole(String argument) {
        try {
            json.write(SpaceMarineCollection.getSpaceMarines().values());
            System.out.print("Saved\n");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeFromFile(String argument) {
        try {
            json.write(SpaceMarineCollection.getSpaceMarines().values());
            System.out.print("Saved\n");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
