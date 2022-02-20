package utility;

import run.App;
import sourse.HumanBeing;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Управление вводом команд.
 */

public class Console {
    private CommandManager commandManager;
    private Scanner userScanner;
    private HumanAsker humanAsker;
    private List<String> scriptStack = new ArrayList<>();

    public Console(CommandManager commandManager, Scanner userScanner, HumanAsker humanAsker) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.humanAsker = humanAsker;
    }

    /**
     * Получение команд от клиента.
     */

    public void interactiveMode() {
    }

    /**
     * Перехват команды.
     * @param argument Это сам аргумент.
     * @return выход.
     */

    public int scriptMode(String argument) {
        return 1;
    }

    /**
     * Запуск команды.
     * @param userCommand Команда для запуска.
     * @return Выход.
     */

    private int launchCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
                //todo help in console
                if (!commandManager.help(userCommand[1])) return 1;
                break;
            case "info":
                if (!commandManager.info(userCommand[1])) return 1;
                break;
            case "show":
                if (!commandManager.show(userCommand[1])) return 1;
                break;
            case "add":
                if (!commandManager.add(userCommand[1])) return 1;
                break;
            case "update":
                if (!commandManager.update(userCommand[1])) return 1;
                break;
            case "remove_by_id":
                if (!commandManager.removeByID(userCommand[1])) return 1;
                break;
            case "clear":
                if (!commandManager.clear(userCommand[1])) return 1;
                break;
            case "save":
                if (!commandManager.save(userCommand[1])) return 1;
                break;
            case "execute_script":
                if (!commandManager.executeScript(userCommand[1])) return 1;
                else return scriptMode(userCommand[1]);
            case "add_if_max":
                if (!commandManager.addIfMax(userCommand[1])) return 1;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(userCommand[1])) return 1;
                break;
            case "remove_all_by_weapon_type":
                if (!commandManager.removeAllByWeaponType(userCommand[1])) return 1;
                break;
            case "average_of_minutes_of_waiting":
                //todo x3 - generate methods in commandManager
                if (!commandManager.averageOfMinutesOfWaiting(userCommand[1])) return 1;
                break;
            case "filter_starts_with_name":
                if (!commandManager.filterStartsWithName(userCommand[1])) return 1;
                break;
            case "exit":
                //todo some problem in exit (console)
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }

    /**
     * Выводит toOut.toString() на консоль.
     * @param toOut Объект для печати.
     */

    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Выводит ошибку toOut.toString() на консоль.
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
     * Выводит toOut.toString() + \n на консоль.
     * @param toOut Объект для печати.
     */

    public static void println(Object toOut) {
        System.out.println(toOut);
    }
}
