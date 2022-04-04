package utility;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import sourse.Car;
import sourse.Coordinates;
import sourse.HumanBeing;

import java.io.*;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import com.google.gson.reflect.TypeToken;
import sourse.WeaponType;

import javax.json.Json;

/**
 * Класс FileManager, отвечающий за работу с файлом.
 */

public class FileManager {
    private final String filePath;
    //public static java.util.Date lastInit;

    /**
     * Поле объект Gson
     */

    private final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                @Override
                public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                    out.value(value.toString());
                }

                @Override
                public ZonedDateTime read(JsonReader in) throws IOException {
                    return ZonedDateTime.parse(in.nextString());
                }
            })
            .enableComplexMapKeySerialization()
            .create();

    public FileManager(String fileName) {
        this.filePath = fileName;
    }

    /**
     * Считывание коллекции из файла.
     *
     * @return Коллекция.
     */

    public ArrayList<HumanBeing> readCollection() {
        if (System.getenv("LABA") != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv("LABA")))) {
                ModelParse modelParse = GSON.fromJson(collectionFileScanner.nextLine(), ModelParse.class);
                ArrayList<HumanBeing> collection = new ArrayList<>(modelParse.getHumanBeings());
                Console.println("Коллекция успешно загружена!");
                return collection; // если раскомментировать 103 строку то всё ок
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

//    public void lastInit() {
//        lastInit = new Date();
//    }

    /**
     * Функция записи в файл.
     *
     * @param data - коллекция для записи в файл.
     */

    public void writeCollection(Collection<HumanBeing> data) {
        if (System.getenv("LABA") != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv("LABA")))) {
                ModelParse modelParse = new ModelParse((ArrayList<HumanBeing>) data);
                collectionFileWriter.write(GSON.toJson(modelParse));
                collectionFileWriter.close();
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}