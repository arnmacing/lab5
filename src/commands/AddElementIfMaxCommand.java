package commands;

import sourse.HumanBeing;
import utility.CollectionManager;
import utility.HumanAsker;

/**
 * Command 'add_if_max'. Adds a new element to collection if it's more than the largest.
 */

public class AddElementIfMaxCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public AddElementIfMaxCommand (CollectionManager collectionManager, HumanAsker humanAsker)
    {
        super("add_if_max {element}", "добавить новый элемент, если его значение больше, чем у наибольшего");
        this.collectionManager = collectionManager;
        this.humanAsker = humanAsker;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */

    @Override
    public boolean execute(String commandStringArgument, Object commandObjectArgument) {
        return false;
    }
}
