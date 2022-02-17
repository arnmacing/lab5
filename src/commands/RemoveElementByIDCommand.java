package commands;

import utility.CollectionManager;

/**
 * Command 'remove_by_id'. Removes the element by its ID.
 */

public class RemoveElementByIDCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public RemoveElementByIDCommand(CollectionManager collectionManager) {
        super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
        this.collectionManager = collectionManager;
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
