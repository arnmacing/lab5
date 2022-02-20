import sourse.HumanBeing;
import utility.HumanAsker;
//todo написать dao & update collection manager)))))0
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javax.json.*;

/**
*Класс, который имплементируется от DAO. В нём мы реализуем методы для работы с коллекцией и инициализируем саму коллекцию */
class DAOHumanBeign implements DAO {
    private ZonedDateTime initDateTime;
    private int availableId = 1;
    private final ArrayList<HumanBeing> humanCcollection = new ArrayList<>();

    public DAOHumanBeign() {
        initDateTime = ZonedDateTime.now();
    }

    public DAOHumanBeign(JsonObject description) {
        String initTime = description.getString("init date");

        if (initTime == null)
            initDateTime = ZonedDateTime.now();
        else
            initDateTime = ZonedDateTime.parse(initTime, DateTimeFormatter.ofPattern("dd.MM.uuuu: HH:mm:ss"));

        JsonArray dragons = description.getJsonArray("elements");

        for (int i = 0; i < description.getInt("size"); ++i)
            humanCcollection.add(new Dragon(dragons.getJsonObject(i)));

        int maxId = -1;
        for(Dragon d: humanCcollection)
            maxId = d.getId() > maxId?d.getId():maxId;

        availableId = maxId > description.getInt("availableId")? maxId + 1: description.getInt("availableId");
    }
    /**
    * Метод добавления элемента в коллекцию
    * @param properties - свойства элемента
    * */
    @Override
    public int create(HumanAsker properties) {
        humanCcollection.add(new (availableId++, properties));
        return 0;
    }
    /**
     * Метод обновления элемента в коллекции по его id
     * @param properties - свойства элемента
     * @param id - id элемента, который пользователь хочет обновить
     * */
    @Override
    public int update(int id, HumanAsker properties) {
        for(Dragon dragon1 : humanCcollection){
            if (id == dragon1.getId()) {
                dragon1.update(properties);
                return 0;
            }
        }
        return -1;
    }
    /**
     * Метод удаления элемента из коллекции по его id
     * @param id - id элемента, который пользователь хочет удалить
     * */
    @Override
    public int delete(int id) {
        if (humanCcollection.removeIf(dragon -> dragon.getId() == id))
            return 0;
        return -1;
    }
    /**
     * Метод получения элемента из коллекции по его id
     * @param id - id элемента, который пользователь хочет получить
     * @return dragon - элемент коллекции
     * */
    @Override
    public Dragon get(int id) {
        for(Dragon dragon : humanCcollection){
            if (dragon.getId() == id) {
                return dragon;
            }
        }
        return null;
    }
    /**
     * Метод получения всей коллекции
     * @return outputCollection - копия коллекции
     * */
    @Override
    public ArrayList<HumanBeing> getAll(){
        ArrayList<HumanBeing> outputCollection = new ArrayList<>();
        outputCollection.addAll(humanCcollection);
        return outputCollection;
    }
    /**
     * Метод очистки всей коллекции
     * */
    @Override
    public int clear() {
        humanCcollection.clear();
        return 0;
    }
    /**
     * Метод возвращения информации о коллекции
     * @return output - информация о коллекции
     * */
    @Override
    public JsonObject getJSONDescription() {

        JsonArrayBuilder dragons = Json.createArrayBuilder();
        for (Dragon d: humanCcollection)
            dragons.add(d.getJSONDescription());

        JsonObject output = Json.createObjectBuilder().
                add("type", humanCcollection.getClass().getSimpleName()).
                add("size", humanCcollection.size()).
                add("init date", initDateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu: HH:mm:ss"))).
                add("availableId", availableId).
                add("elements", dragons.build()).build();

        return output;
    }
    /**
     * Метод сортировки коллекции
     * */
    @Override
    public void sort() {
        Collections.sort(humanCcollection);
    }
}