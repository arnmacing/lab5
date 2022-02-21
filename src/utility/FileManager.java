package utility;

import sourse.HumanBeing;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.ArrayList;
import javax.json.*;

public class FileManager {
      //private Gson gson = new Gson();
      private String envVariable;
      public static java.util.Date lastInit;
      public static ArrayList<HumanBeing> humanCollection = new ArrayList<>();

    /**
     * Считывание коллекции из файла.
     * @return
     */

    public ArrayList<HumanBeing> readCollection() {
        if (System.getenv().get(envVariable) != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv().get(envVariable)))) {
                ArrayList<HumanBeing> collection;
                //todo typetoken in file manager
                Type collectionType = new TypeToken<ArrayList<HumanBeing>>() {}.getType();
                //todo json why do not import????????? solve
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                Console.println("Коллекция успешна загружена!");
                return collection;
            } catch (FileNotFoundException exception) {
                Console.printerror("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                Console.printerror("Загрузочный файл пуст!");
//            } catch (JsonParseException | NullPointerException exception) {
//                Console.printerror("В загрузочном файле не обнаружена необходимая коллекция!");
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

    public static ArrayList<HumanBeing> getCollection(){
        return humanCollection;
    }



    public void writeCollection(Collection<?> collection) {

    }

    @Override
    public boolean equals(Object o){
        return this == o;
    }
}
