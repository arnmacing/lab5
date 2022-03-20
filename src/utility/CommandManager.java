package utility;

import java.util.ArrayList;
import java.util.List;

import commands.*;
import exceptions.CommandNotFoundException;

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
    // todo for what?
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
     * Выводит информацию обо всех командах.
     *
     * @param argument Аргумент.
     * @return Статус выхода команды.
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
     * Выводит сообщение о том, что команда не найдена.
     *
     * @param command Команда, которая не найдена.
     * @return Статус выхода команды.
     */

    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }

    /**
     * Выполнение необходимых команд.
     *
     * @param argument Аргумент.
     * @return Статус выхода команды.
     */

    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    public boolean add(String argument) {
        return addCommand.execute(argument);
    }

    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    public boolean removeByID(String argument) {
        return removeByIDCommand.execute(argument);
    }

    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    public boolean addIfMax(String argument) {
        return addIfMaxCommand.execute(argument);
    }

    public boolean removeGreater(String argument) {
        return removeGreaterCommand.execute(argument);
    }

    public boolean insertAtIndex(String argument) {
        return insertAtIndexCommand.execute(argument);
    }

    public boolean removeAllByWeaponType(String argument) {
        return removeAllByWeaponTypeCommand.execute(argument);
    }

    public boolean averageOfMinutesOfWaiting(String argument) {
        return averageOfMinutesOfWaitingCommand.execute(argument);
    }

    public boolean filterStartsWithName(String argument) {
        return filterStartsWithNameCommand.execute(argument);
    }

    public Command getCommandByName(String name) {
        for (Command command : commands) {
            if (command.getName().equals(name)) return command;
        }
        throw new IllegalStateException("Хочу пиво, баунти и ашкудишку");
    }
}
