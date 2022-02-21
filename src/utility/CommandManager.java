package utility;

import java.util.ArrayList;
import java.util.List;

import commands.*;

/**
 * Управление командами.
 */

public class CommandManager {
    private List<Command> commands = new ArrayList<>();
    private Command helpCommand;
    private Command infoCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command removeByIDCommand;
    private Command clearCommand;
    private Command saveCommand;
    private Command executeScriptCommand;
    private Command exitCommand;
    private Command insertAtIndexCommand;
    private Command addIfMaxCommand;
    private Command removeGreaterCommand;
    private Command removeAllByWeaponTypeCommand;
    private Command averageOfMinutesOfWaitingCommand;
    private Command filterStartsWithNameCommand;
    private Command serverExitCommand;

    public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                          Command removeByIDCommand, Command clearCommand, Command saveCommand, Command exitCommand, Command executeScriptCommand,
                          Command addIfMaxCommand, Command insertAtIndexCommand, Command removeGreaterCommand, Command removeAllByWeaponTypeCommand,
                          Command averageOfMinutesOfWaitingCommand, Command filterStartsWithNameCommand, Command serverExitCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIDCommand = removeByIDCommand;
        this.clearCommand = clearCommand;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.addIfMaxCommand = addIfMaxCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.removeAllByWeaponTypeCommand = removeAllByWeaponTypeCommand;
        this.averageOfMinutesOfWaitingCommand = averageOfMinutesOfWaitingCommand;
        this.insertAtIndexCommand = insertAtIndexCommand;
        this.filterStartsWithNameCommand = filterStartsWithNameCommand;
        this.serverExitCommand = serverExitCommand;

        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(addCommand);
        commands.add(updateCommand);
        commands.add(removeByIDCommand);
        commands.add(clearCommand);
        commands.add(saveCommand);
        commands.add(exitCommand);
        commands.add(executeScriptCommand);
        commands.add(addIfMaxCommand);
        commands.add(removeGreaterCommand);
        commands.add(removeAllByWeaponTypeCommand);
        commands.add(averageOfMinutesOfWaitingCommand);
        commands.add(insertAtIndexCommand);
        commands.add(filterStartsWithNameCommand);
        commands.add(serverExitCommand);
    }

    public CommandManager(HelpCommand helpCommand, InfoCommand infoCommand, ShowCommand showCommand, AddCommand addCommand, UpdateElementCommand updateCommand, RemoveElementByIDCommand removeByIDCommand, ClearCommand clearCommand, SaveCommand saveCommand, ExecuteScriptCommand executeScriptCommand, ExitCommand exitCommand, InsertElementAtIndexCommand insertElementAtIndexCommand, AddElementIfMaxCommand insertAtIndexCommand, RemoveGreaterCommand removeGreaterCommand, RemoveAllByWeaponTypeCommand removeAllByWeaponTypeCommand, AverageOfMinutesCommand averageOfMinutesOfWaitingCommand, FilterStartsWithNameCommand filterStartsWithNameCommand) {

    }

    /**
     * @return Список команд.
     */

    public List<Command> getCommands() {
        return commands;
    }

    /**
    * Вывод информации обо всех командах.
    */
    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
    * Выполнение необходимых команд.
    */

    //todo чистка? что за аргументы? разобраться.
    // если в менеджере команд убирать втрой аргумент (Object) то все ок работает но я хз можно так или нет
    public boolean info(String stringArgument) {
        return infoCommand.execute(stringArgument);
    }

    public boolean show(String stringArgument, Object objectArgument) {
        return showCommand.execute(stringArgument, objectArgument);
    }

    public boolean add(String stringArgument, Object objectArgument) {
        return addCommand.execute(stringArgument, objectArgument);
    }

    public boolean update(String stringArgument, Object objectArgument) {
        return updateCommand.execute(stringArgument, objectArgument);
    }

    public boolean removeByID(String stringArgument, Object objectArgument) {
        return removeByIDCommand.execute(stringArgument, objectArgument);
    }

    public boolean clear(String stringArgument, Object objectArgument) {
        return clearCommand.execute(stringArgument, objectArgument);
    }

    public boolean save(String stringArgument, Object objectArgument) {
        return saveCommand.execute(stringArgument, objectArgument);
    }

    public boolean exit(String stringArgument, Object objectArgument) {
        return exitCommand.execute(stringArgument, objectArgument);
    }

    public boolean executeScript(String stringArgument, Object objectArgument) {
        return executeScriptCommand.execute(stringArgument, objectArgument);
    }

    public boolean addIfMax(String stringArgument, Object objectArgument) {
        return addIfMaxCommand.execute(stringArgument, objectArgument);
    }

    public boolean removeGreater(String stringArgument, Object objectArgument) {
        return removeGreaterCommand.execute(stringArgument, objectArgument);
    }

    public boolean insertAtIndex(String stringArgument, Object objectArgument) {
        return insertAtIndexCommand.execute(stringArgument, objectArgument);
    }

    public boolean removeAllByWeaponType(String stringArgument, Object objectArgument) {
        return removeAllByWeaponTypeCommand.execute(stringArgument, objectArgument);
    }

    public boolean averageOfMinutesOfWaiting(String stringArgument, Object objectArgument) {
        return averageOfMinutesOfWaitingCommand.execute(stringArgument, objectArgument);
    }

    public boolean filterStartsWithName(String stringArgument, Object objectArgument) {
        return filterStartsWithNameCommand.execute(stringArgument,objectArgument);
    }

    /**
     * Prints that command is not found.
     * @param command Comand, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }
}
