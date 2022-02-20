package utility;
//todo x26 exception ?? human asker

import exceptions.*;
import run.App;
import sourse.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;

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
     * Запрашивает у пользователя имя человека.
     * @return Имя человека.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */
    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException(); //ошибка пустого ввода
                break;
            } catch (NoSuchElementException exception) { //не найдено
                Console.printerror("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
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

    public double askY() throws IncorrectInputInScriptException { //ошибка неверного ввода в скрипте
        String strY;
        double y;
        while (true) {
            try {
                Console.println("Введите координату Y:");
                Console.print(App.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Double.parseDouble(strY);
                break;
            } catch (NoSuchElementException exception) { //элемент не найден
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException(); //ошибка неверного ввода в скрипте
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException(); //ошибка неверного ввода в скрипте
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }

    /**
     * Запрашивает у пользователя координаты человека.
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


    /**
     * Запрашивает у пользователя статус человека.
     * @return Статус человека.
     * @throws
     */

//TODO
    public boolean askRealHero() throws IncorrectInputInScriptException {
        String strRealHero;
        boolean realHero;
        while (true) {
            try {
                Console.println("Он реальный герой или пиздит?");
                Console.println(App.PS2);
                strRealHero = userScanner.nextLine().trim();
                if (fileMode) Console.println(strRealHero); //?????????????
                if (strRealHero.equals("yes") || strRealHero.equals("Yes") || strRealHero.equals("да") || strRealHero.equals("Да") || strRealHero.equals("пизда")){
                    realHero = true;
                    //ошибка пустого ввода?
                }
            }
            catch (NoSuchElementException e) {
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException e) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
            /*
            catch (NotInDeclaredLimitsException e) {
                Console.printerror("Ответ не может быть пустым вводом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            }

            vot etot blok nichego ne vizivaet
             */
        }
        /*
        return realHero; // do etogo nikogda ne doidet iz za while (true)


         zachem method boolean tut, luchse ego sdelai void'om
         */
        // в пизду

        // etot method dolzhn chto to throw'it', pri etom on boolean, i nichego ne vikidivaet. zachem?
    }

    /**
     * Запрашивает у пользователя наличие зубочистки.
     * @return Наличие зубочистки.
     * @throws
     */

//TODO
    public boolean askHasToothPick() throws IncorrectInputInScriptException {
        String strhasHoothpick;
        boolean hasToothpick = false;
        while (true) {
            try {
                Console.println("Зубачистка в зубах есть? чи не?");
                Console.println(App.PS2);
                strhasHoothpick = userScanner.nextLine().trim();
                if (fileMode) Console.println(strhasHoothpick); //?????????????
                if (strhasHoothpick.equals("yes") || strhasHoothpick.equals("Yes") || strhasHoothpick.equals("да") || strhasHoothpick.equals("Да") || strhasHoothpick.equals("пизда"))
                    hasToothpick = true;
                    //ошибка пустого ввода?
                } catch (NoSuchElementException exception) {
                        Console.printerror("Ответ не распознан!");
                        if (fileMode) throw new IncorrectInputInScriptException();
                    } catch (MustBeNotEmptyException exception) {
                        Console.printerror("Ответ не может быть пустым вводом!");
                        if (fileMode) throw new IncorrectInputInScriptException();
                    } catch (NullPointerException | IllegalStateException exception) {
                        Console.printerror("Непредвиденная ошибка!");
                        System.exit(0);
                    }
                }
        return hasToothpick;
    }

    /**
     * Запрашиваает у пользователя скорость удара человека.
     * @return Скорость удара человека.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */

    public Integer askImpactSpeed() throws IncorrectInputInScriptException {
        String strSpeed;
        Integer speed;
        while (true) {
            try {
                Console.println("Введите cкорость удара:");
                Console.print(App.PS2);
                strSpeed = userScanner.nextLine().trim();
                if (fileMode) Console.println(strSpeed);
                speed = Integer.parseInt(strSpeed);
                if (speed == null) throw new NotInDeclaredLimitsException(); //или отдельная ошибка пустого ввода?
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Скорость удара не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Скорость удара не может быть пустым вводом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            }catch (NumberFormatException exception) {
                Console.printerror("Cкорость удара должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return speed;
    }

    /**
     * Запрашивает у пользователя название песни.
     * @return Название песни.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */

    public String askSoundtrackName() throws IncorrectInputInScriptException {
        String soundtrackName;
        while (true) {
            try {
                Console.println("Введите название песни:");
                Console.print(App.PS2);
                soundtrackName = userScanner.nextLine().trim();
                if (fileMode) Console.println(soundtrackName);
                if (soundtrackName.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Название песни не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Название песни не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return soundtrackName;
    }

    /**
     * Запрашивает у пользователя количество минут ожидания.
     * @return Количество минут ожидания.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */

    public float askMinutesOfWaiting() throws IncorrectInputInScriptException {
        String strMinutesOfWaiting;
        float minutesOfWaiting;
        while (true) {
            try {
                Console.println("Введите количество минут ожидания:");
                Console.print(App.PS2);
                strMinutesOfWaiting = userScanner.nextLine().trim();
                if (fileMode) Console.println(strMinutesOfWaiting);
                minutesOfWaiting = Float.parseFloat(strMinutesOfWaiting);
            } catch (NoSuchElementException exception) {
                Console.printerror("Количество минут ожидания не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Количество минут ожидания должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return minutesOfWaiting;
    }

    public WeaponType askWeaponType() throws IncorrectInputInScriptException {
        String strWeaponType;
        WeaponType weaponType;
            while (true) {
                try {
        Console.println("Введите вид оружия:" + WeaponType.nameList());
        Console.println(App.PS2);
        strWeaponType = userScanner.nextLine().trim();
        if (fileMode) Console.println(strWeaponType);
                    weaponType = WeaponType.valueOf(strWeaponType.toUpperCase());
                    break;
                } catch (NoSuchElementException exception) {
                    Console.printerror("Оружие не распознано!");
                    if (fileMode) throw new IncorrectInputInScriptException();
                } catch (IllegalArgumentException exception) {
                    Console.printerror("Оружия нет в списке!");
                    if (fileMode) throw new IncorrectInputInScriptException();
                } catch (IllegalStateException exception) {
                    Console.printerror("Непредвиденная ошибка!");
                    System.exit(0);
                }
            }
        return  weaponType;
    }

        /**
         * Запрашивает у пользователя название машины.
         * @return Название машины.
         * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
         */

    public Car askCar() throws IncorrectInputInScriptException {
        String name;
        Car car = null;
            while (true) {
                try {
        Console.println("Введите название машины");
        Console.println(App.PS2);
        name = userScanner.nextLine().trim();
            if (fileMode) Console.println(name);
            if (name.equals("")) throw new MustBeNotEmptyException(); //ошибка пустого ввода
                    car = new Car(name, true);
            break;
        } catch (NoSuchElementException exception) { //не найдено
            Console.printerror("Название машины не распознано!");
            if (fileMode) throw new IncorrectInputInScriptException();
        } catch (MustBeNotEmptyException exception) {
            Console.printerror("Название машины не может быть пустым!");
            if (fileMode) throw new IncorrectInputInScriptException();
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
            System.exit(0);
        }
            }
        return car;
    }

    /**
     * Задает пользователю вопрос.
     * @return Ответ.
     * @param question Вопрос.
     * @throws IncorrectInputInScriptException Если скрипт запущен и что-то идет не так.
     */

    public boolean askQuestion(String question) throws IncorrectInputInScriptException { //ошибка неверного ввода в скрипте
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(App.PS2);
                answer = userScanner.nextLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException(); //выход за пределы
                break;
            } catch (NoSuchElementException exception) { // 'элемент не найден
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException(); //ошибка неверного ввода в скрипте
            } catch (NotInDeclaredLimitsException exception) { //выход за пределы
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
                if (fileMode) throw new IncorrectInputInScriptException(); //ошибка неверного ввода в скрипте
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }
}


