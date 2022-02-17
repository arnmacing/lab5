package commands;

/**
 * Интерфейс для всех команд.
 */

public interface Command {
    String getDescription();
    String getName();
    String getUsage();
    boolean execute(String commandStringArgument, Object commandObjectArgument);
}