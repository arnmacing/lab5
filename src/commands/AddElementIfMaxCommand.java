package commands;

import Utility.CollectionManager;

/**
 * Command 'add_if_max'. Adds a new element to collection if it's more than the largest.
 */
public class AddElementIfMaxCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    // private

    public AddElementIfMaxCommand (CollectionManager collectionManager)
            //добавить человека
    {
        super("add_if_max {element}", "добавить новый элемент, если его значение больше, чем у наибольшего");
        this.collectionManager = collectionManager;
        //this.
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
