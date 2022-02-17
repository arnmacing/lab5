package utility;

/**
 * Класс для генерации ответов клиенту.
 */

public class ResponseOutputer {
    private static StringBuilder stringBuilder = new StringBuilder();

    /**
     * Добавление объекта out в конец строки.
     */

    public static void append(Object toOut) {
        stringBuilder.append(toOut);
    }

    /**
     * Добавьление описания ошибки и разрыв строки в конец строки.
     */

    public static void appenderror(Object toOut) {
        stringBuilder.append("error: " + toOut + "\n");
    }

    /**
     * Принимает сконструированную строку.
     */

    public static String getString() {
        return stringBuilder.toString();
    }

    /**
     * Добавьте таблицу с двумя элементами в конец строки.
     */

    public static void appendtable(Object element1, Object element2) {
        stringBuilder.append(String.format("%-37s%-1s%n", element1, element2));
    }

    /**
     * Takes a constructed string.
     *
     * @return Сonstructed string.
     */
    /**
     * Принимает сконструированную строку и очищает буфер.
     */

    public static String getAndClear() {
        String toReturn = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return toReturn;
    }

    /**
     * Очищает буфер.
     */
    public static void clear() {
        stringBuilder.delete(0, stringBuilder.length());
    }
}
