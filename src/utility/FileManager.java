package utility;

import sourse.HumanBeing;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import javax.json.*;
import javax.json.stream.JsonParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonParseException;



public class FileManager {

      private String envVariable;
      public static java.util.Date lastInit;
      public static final Gson gson = new Gson();

      public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    /**
     * Считывание коллекции из файла.
     * @return
     */

    public ArrayList<HumanBeing> readCollection() {
        if (System.getenv().get(envVariable) != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv().get(envVariable)))) {
                ArrayList<HumanBeing> collection;
                Type collectionType = new TypeToken<ArrayList<HumanBeing>>() {}.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                Console.println("Коллекция успешна загружена!");
                return collection;
            } catch (FileNotFoundException exception) {
                Console.printerror("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                Console.printerror("Загрузочный файл пуст!");
            } catch (JsonParseException | NullPointerException exception) {
                Console.printerror("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
        return new ArrayList<HumanBeing>();
    }

    public void lastInit(){
        lastInit = new Date();
    }

    public void writeCollection(Collection<?> collection) {
        if (System.getenv().get(envVariable) != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv().get(envVariable)))) {
                collectionFileWriter.write(gson.toJson(collection));
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
