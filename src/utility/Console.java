package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import commands.*;
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
        }
    }

    /**
     * Запуск команды.
     */
    /* //todo
    public int launchCommand(String[] userCommand) throws CommandNotFoundException {
        Command command = commandManager.getCommandByName(userCommand[0]);
        if (command == null) throw new CommandNotFoundException();
        else command.execute(userCommand[1]);
        return 1;
    }
*/
    private int launchCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
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
            case "insert_at index":
                if (!commandManager.insertAtIndex(userCommand[1])) return 1;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(userCommand[1])) return 1;
                break;
            case "remove_all_by_weapon_type":
                if (!commandManager.removeAllByWeaponType(userCommand[1])) return 1;
                break;
            case "average_of_minutes_of_waiting":
                if (!commandManager.averageOfMinutesOfWaiting(userCommand[1])) return 1;
                break;
            case "filter_starts_with_name":
                if (!commandManager.filterStartsWithName(userCommand[1])) return 1;
                break;
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }

    public int scriptMode(String fileName) {
        String[] userCommand = {"", ""};
        int commandStatus;
        scriptStack.add(fileName);
        try (Scanner scriptScanner = new Scanner(new File(fileName))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = humanAsker.getUserScanner();
            humanAsker.setUserScanner(scriptScanner);
            humanAsker.setFileMode();
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                Console.println(Console.PS1 + String.join(" ", userCommand));
                if (userCommand[0].equals("execute_script")) {
                    for (String script : scriptStack) {
                        if (userCommand[1].equals(script)) throw new ScriptRecursionException();
                    }
                }
                commandStatus = launchCommand(userCommand);
            } while (commandStatus == 0 && scriptScanner.hasNextLine());
            humanAsker.setUserScanner(tmpScanner);
            humanAsker.setUserMode();
            if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                Console.println("Проверьте скрипт на корректность введенных данных!");
            return commandStatus;
        } catch (FileNotFoundException exception) {
            Console.printerror("Файл со скриптом не найден!");
        } catch (NoSuchElementException exception) {
            Console.printerror("Файл со скриптом пуст!");
        } catch (ScriptRecursionException exception) {
            Console.printerror("Скрипты не могут вызываться рекурсивно!");
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
            System.exit(0);
        } finally {
            scriptStack.remove(scriptStack.size() - 1);
        }
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

    public static void run(String scriptPath) {
        Console.println("Начало работы программы!");
        Console.println("Для получения справочной информации, наберите в командной строке команду help. На экран выведется список основных команд.");
        while (true) {
            try {
                try (Scanner userScanner = new Scanner(System.in)) {

                    HumanAsker humanAsker = new HumanAsker(userScanner);
                    FileManager fileManager = new FileManager(System.getenv(scriptPath));
                    CollectionManager collectionManager = new CollectionManager(fileManager);
                    CommandManager commandManager = new CommandManager(
                        new HelpCommand(collectionManager),
                        new InfoCommand(collectionManager),
                        new ShowCommand(collectionManager),
                        new AddCommand(collectionManager, humanAsker),
                        new UpdateElementCommand(collectionManager, humanAsker),
                        new RemoveElementByIDCommand(collectionManager),
                        new ClearCommand(collectionManager),
                        new SaveCommand(collectionManager),
                        new ExecuteScriptCommand(),
                        new ExitCommand(),
                        new InsertElementAtIndexCommand(collectionManager, humanAsker),
                        new AddElementIfMaxCommand(collectionManager, humanAsker),
                        new RemoveGreaterCommand(collectionManager, humanAsker),
                        new RemoveAllByWeaponTypeCommand(collectionManager),
                        new AverageOfMinutesCommand(collectionManager),
                        new FilterStartsWithNameCommand(collectionManager));
                    Console console = new Console(commandManager, userScanner, humanAsker);
                    console.interactiveMode();
                }
            } catch (ExitException e) {
                Console.printerror(e.getMessage());
                break;
            }
        }
    }
}


