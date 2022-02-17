package utility;

import run.App;
import sourse.Coordinates;
import sourse.HumanBeing;

import java.util.Scanner;

/**
 * Запрашивает у пользователя данные человека.
 */

public class HumanAsker {
    private Scanner userScanner;
    private boolean fileMode;

    public HumanAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    /**
     * Задает сканер для сканирования пользовательского ввода.
     */

    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Сканер, который используется для ввода пользователем..
     */

    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Устанавливает режим запрашивающего пользователя в 'File Mode'.
     */

    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Устанавливает режим humanAsker в 'User Mode'.
     */

    public void setUserMode() {
        fileMode = false;
    }

    /**
     * Запрашивает у пользователя координату X.
     * @return Координата Х.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */

    public double askX() throws IncorrectInputInScriptException {
        String strX;
        double x;
        while (true) {
            try {
                Console.println("Введите координату X:");
                Console.print(App.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Double.parseDouble(strX);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }


    /**
     * Запрашивает у пользователя координату Y.
     * @return Координата Y.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */

    public Float askY() throws IncorrectInputInScriptException {
        String strY;
        Float y;
        while (true) {
            try {
                Console.println("Введите координату Y < " + (MAX_Y+1) + ":");
                Console.print(App.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Float.parseFloat(strY);
                if (y > MAX_Y) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата Y не может превышать " + MAX_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }

    /**
     * Запрашивает у пользователя координаты морского пехотинца.
     * @return Координаты.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */
    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        double x;
        double y;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }


}
