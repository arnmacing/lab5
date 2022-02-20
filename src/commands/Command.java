package commands;

/**
 * Интерфейс для всех команд.
 */

public interface Command {
    String getDescription();
    String getName();
    boolean execute(String argument);
}