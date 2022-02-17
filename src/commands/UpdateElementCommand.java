package commands;

import sourse.HumanBeing;
import utility.CollectionManager;
import utility.HumanAsker;

/**
 * Command 'update'. Updates the information about human.
 */

public class UpdateElementCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public UpdateElementCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
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