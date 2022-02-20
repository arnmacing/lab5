package commands;

import sourse.HumanBeing;
import utility.CollectionManager;
import utility.Console;
import utility.HumanAsker;

import java.util.ArrayList;

public class InsertElementAtIndexCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public InsertElementAtIndexCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("insert_at index {element}", "добавить новый элемент в заданную позицию");
        this.collectionManager = collectionManager;
        this.humanAsker = humanAsker;
    }

    /**
     * Выполняет команду.
     * @return Статус выхода команды.
     */

    @Override
public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            ArrayList<HumanBeing>


            if (humanToInsert == null) throw new HumanNotFoundException();
            collectionManager.removeFromCollection(humanToInsert);
            Console.println("Человек успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (NumberFormatException exception) {
            Console.printerror("Индекс должен быть представлен числом!");
        }
        return false;
    }
}

/*
 case ("insert"):
                    try {
                        if (FileController.getCollection().get(Long.parseLong(command[1])) != null) {
                            System.out.println("Элемент с таким айди уже есть. Хотите заменить его?(Да/Нет)");
                            String temp = scanner.nextLine().toLowerCase(Locale.ROOT);
                            if (temp.equals("да")) {
                                if (Integer.parseInt(command[1]) <= 0) throw new IncorrectIdException();
                                new CollectionController(command[1]);
                                System.out.println("Успешно удалено!");
                            } else if (temp.equals("нет")) break;
                            else System.out.println("Такой ответ не предусмотрен большим братом");
                        } else {
                            if (Integer.parseInt(command[1]) <= 0) throw new IncorrectIdException();
                            new CollectionController(command[1]);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Ошибка. Вы не ввели аргумент команды.");
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка. Ввёден неправильный аргумент команды");
                    }catch (IncorrectIdException e){
                        System.err.println("Ошибка. Id должен быть больше нуля.");
                    }
                    break;
 */