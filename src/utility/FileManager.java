package utility;

import com.google.gson.*;
import sourse.Coordinates;
import sourse.HumanBeing;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

import com.google.gson.reflect.TypeToken;

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
            .registerTypeAdapter(CollectionManager.class, new CollectionManagerJsonDeserializer())
            .create();

    private static class CollectionManagerJsonDeserializer implements JsonDeserializer<CollectionManager> {
        @Override
        public CollectionManager deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray jsonArray = json.getAsJsonArray();
            List<HumanBeing> list = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                int id = jsonObject.get("id").getAsInt();
                String name = jsonObject.get("name").getAsString();
                //Coordinates coordinates = jsonObject.get("coordinates").getAs
                String creationDate = jsonObject.get("creationDate").getAsString();
                boolean realHero = jsonObject.get("realHero").getAsBoolean();
                boolean hasToothpick = jsonObject.get("hasToothpick").getAsBoolean();
                Integer impactSpeed = jsonObject.get("impactSpeed").getAsInt();
                String soundtrackName = jsonObject.get("soundtrackName").getAsString();
                Float minutesofWaiting = jsonObject.get("minutesOfWaiting").getAsFloat();
                String weaponType = jsonObject.get("weaponType").getAsString();
                JsonElement car = jsonObject.get("car");
                //
                context.deserialize(car, Car.class);
                HumanBeing humanBeing = new HumanBeing(
                        id ,
                        name,
                        //coordinates,
                        //creationDate,
                        realHero,
                        hasToothpick,
                        impactSpeed,
                        minutesofWaiting,
                        weaponType,
                        //car
                );

                list.add(humanBeing);
            }
            return new CollectionManager(list, new FileManager("LABA"));
        }
    }

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
                ArrayList<HumanBeing> collection;
                Type collectionType = new TypeToken<ArrayList<HumanBeing>>() {}.getType();
//                collection = GSON.fromJson(collectionFileScanner.nextLine().trim(), ArrayList.class);
//                collection = GSON.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                CollectionManager collectionManager = GSON.fromJson(collectionFileScanner.nextLine().trim(), CollectionManager.class);
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
                collectionFileWriter.write(GSON.toJson(data));
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
