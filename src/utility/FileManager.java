package utility;

import com.google.gson.*;
import sourse.Car;
import sourse.Coordinates;
import sourse.HumanBeing;

import java.io.*;
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
            .registerTypeAdapter(CollectionManager.class, new CollectionManagerJsonDeserializer())
            .create();

    private static class CollectionManagerJsonDeserializer implements JsonDeserializer<CollectionManager> {
        @Override
        public CollectionManager deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            CollectionManager newCollectionManager = new CollectionManager(new FileManager("LABA"));

            JsonArray jsonArray = json.getAsJsonArray();
            //List<HumanBeing> list = new ArrayList<>(); зачем мы создаём лист
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                HumanBeing newHuman = context.deserialize(jsonObject, HumanBeing.class);

                /*int id = jsonObject.get("id").getAsInt();
                String name = jsonObject.get("name").getAsString();

                JsonObject coordinates = jsonObject.get("coordinates").getAsJsonObject();
                Coordinates newCoordinates = context.deserialize(coordinates, Coordinates.class);

                JsonObject creationDate = jsonObject.get("creationDate").getAsJsonObject(); // тут может пойти по пизде всё
                ZonedDateTime newCreationDate = context.deserialize(creationDate, ZonedDateTime.class); //  тут может пойти по пизде всё
                boolean realHero = jsonObject.get("realHero").getAsBoolean();
                boolean hasToothpick = jsonObject.get("hasToothpick").getAsBoolean();
                Integer impactSpeed = jsonObject.get("impactSpeed").getAsInt();
                String soundtrackName = jsonObject.get("soundtrackName").getAsString();
                Float minutesOfWaiting = jsonObject.get("minutesOfWaiting").getAsFloat();
                String weaponType = jsonObject.get("weaponType").getAsString();
                WeaponType newWeaponType = WeaponType.valueOf(weaponType);

                JsonObject car = jsonObject.get("car").getAsJsonObject();
                Car newCar = context.deserialize(car, Car.class);
                //context.deserialize(car, Car.class); зачем
                HumanBeing newHuman = new HumanBeing(
                        id ,
                        name,
                        newCoordinates,
                        newCreationDate,
                        realHero,
                        hasToothpick,
                        impactSpeed,
                        soundtrackName,
                        minutesOfWaiting,
                        newWeaponType,
                        newCar
                );*/

                newCollectionManager.addToCollection(newHuman);
                //list.add(humanBeing); всё тот же вопрос зачем нам лист
            }
            return newCollectionManager;
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
                //Type collectionType = new TypeToken<ArrayList<HumanBeing>>() {}.getType();
                collection = GSON.fromJson(collectionFileScanner.nextLine(), ArrayList.class);
                //collection = GSON.fromJson(collectionFileScanner.nextLine().trim(), collectionType); //это точно всё в комменты?
                //CollectionManager collectionManager = GSON.fromJson(collectionFileScanner.nextLine().trim(), CollectionManager.class);
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
