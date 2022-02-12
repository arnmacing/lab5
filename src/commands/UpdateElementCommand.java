package commands;

import Utility.CollectionManager;

/**
 * Command 'update'. Updates the information about human.
 */

public class UpdateElementCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    // private

    public UpdateElementCommand(CollectionManager collectionManager) {
        // добавить человека
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
        this.collectionManager = collectionManager;
        // this.
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */

    @Override
    public boolean execute(String argument) {
        return false;
    }
}