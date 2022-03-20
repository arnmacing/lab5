package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import commands.Command;
import exceptions.*;


/**
 * Управление вводом команд.
 */

public class Console {
    private CommandManager commandManager;
    private Scanner userScanner;
    private HumanAsker humanAsker;
    private List<String> scriptStack = new ArrayList<>();
    public static final String PS1 = "$ ";

    public Console(CommandManager commandManager, Scanner userScanner, HumanAsker humanAsker) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.humanAsker = humanAsker;
    }

    /**
     * Получение команд от клиента.
     */

    public void interactiveMode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            do {
                Console.print(PS1);
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandStatus = launchCommand(userCommand);
            } while (commandStatus != 2);
        } catch (NoSuchElementException exception) {
            Console.printerror("Пользовательский ввод не обнаружен!");
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
        } catch (CommandNotFoundException e) {
            // todo
        }
    }

    /**
     * Запуск команды.
     */
//todo
    public int launchCommand(String[] userCommand) throws CommandNotFoundException {
        Command command = commandManager.getCommandByName(userCommand[0]);
        if (command == null) throw new CommandNotFoundException();
        else command.execute(userCommand[1]);
        return 1;
    }


    /**
     * Выводит toOut.toString() на консоль.
     *
     * @param toOut Объект для печати.
     */

    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Выводит ошибку toOut.toString() на консоль.
     *
     * @param toOut Ошибка при печати.
     */

    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    @Override
    public String toString() {
        return "Console (класс для обработки ввода команд)";
    }

    /**
     * Выводит форматированную таблицу из 2 элементов на консоль
     */

    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }

    /**
     * Выводит toOut.toString() + \n на консоль.
     *
     * @param toOut Объект для печати.
     */

    public static void println(Object toOut) {
        System.out.println(toOut);
    }
}


