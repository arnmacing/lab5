package utility;

import sourse.HumanBeing;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonParseException;

/**
 * Класс FileManager, отвечающий за работу с файлом.
 */

public class FileManager {
    private final String filePath;
    public static java.util.Date lastInit;

    /**
     * Поле объект Gson
     */

    private final Gson GSON= new Gson();

    public FileManager(String fileName) {
        this.filePath = fileName;
    }

    /**
     * Считывание коллекции из файла.
     * @return Коллекция.
     */

    public ArrayList<HumanBeing> readCollection() {
        if (System.getenv().get(filePath) != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv().get(filePath)))) {
                ArrayList<HumanBeing> collection;
                Type collectionType = new TypeToken<ArrayList<HumanBeing>>() {
                }.getType();
                collection = GSON.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                Console.println("Коллекция успешна загружена!");
                return collection;
            } catch (FileNotFoundException exception) {
                Console.printerror("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                Console.printerror("Загрузочный файл пуст!");
            } catch (NullPointerException e) {
                Console.printerror("Искомая коллекция отсутствует в файле!");
            } catch (JsonParseException exception) {
                Console.printerror("В загрузочном файле не обнаружена необходимая коллекция!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
        return new ArrayList<HumanBeing>();
    }

    public void lastInit(){
        lastInit = new Date();
    }

    /**
     * Функция записи в файл.
     * @param data - коллекция для записи в файл.
     */

    public void writeCollection(Collection<HumanBeing> data) {
        if (System.getenv().get(filePath) != null) {
        try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv().get(filePath)))) {
            collectionFileWriter.write(GSON.toJson(data));
            collectionFileWriter.close();
            Console.println("Коллекция успешна сохранена в файл!");
        } catch (IOException exception) {
            Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
        }
    } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
}

    @Override
    public boolean equals(Object o){
        return this == o;
    }
}
