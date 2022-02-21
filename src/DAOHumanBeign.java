import sourse.*;

//todo написать dao & update collection manager)))))0
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
*Класс, который имплементируется от DAO. В нём мы реализуем методы для работы с коллекцией и инициализируем саму коллекцию */
public final class DAOHumanBeign implements DAO {
    private ZonedDateTime initDateTime;
    private static int availableId = 1;
    private final ArrayList<HumanBeing> humanCcollection = new ArrayList<>();

    //todo это что?
    public DAOHumanBeign() {
        initDateTime = ZonedDateTime.now();
    }

//    public DAOHumanBeign(JsonObject description) {
//        String initTime = description.getString("init date");
//
//        if (initTime == null)
//            initDateTime = ZonedDateTime.now();
//        else
//            initDateTime = ZonedDateTime.parse(initTime, DateTimeFormatter.ofPattern("dd.MM.uuuu: HH:mm:ss"));
//
//        JsonArray dragons = description.getJsonArray("elements");
//
//        for (int i = 0; i < description.getInt("size"); ++i)
//            humanCcollection.add(new Dragon(dragons.getJsonObject(i)));
//
//        int maxId = -1;
//        for(Dragon d: humanCcollection)
//            maxId = d.getId() > maxId?d.getId():maxId;
//
//        availableId = maxId > description.getInt("availableId")? maxId + 1: description.getInt("availableId");
//    }
    /**
    * Метод добавления элемента в коллекцию
    * */
    @Override
    public int create(HumanBeing human) {
        humanCcollection.add(new HumanBeing(availableId, human.getName(),human.getCoordinates(), human.getCreationDate(),
                human.checkRealHero(), human.checkHasToothpick(), human.getImpactSpeed(), human.getSoundtrackName(),
                human.getMinutesOfWaiting(), human.getWeaponType(), human.getCar()));
        return availableId++;
    }


    /**
     * Метод обновления элемента в коллекции по его id

     * */
    @Override
    public void update(HumanBeing human) {
        HumanBeing existedHuman = get(human.getId());

        if (existedHuman != null) {
            existedHuman.setName(human.getName());
            existedHuman.setCoordinates(human.getCoordinates());
            existedHuman.setCreationDate(human.getCreationDate());
            existedHuman.setRealHero(human.checkRealHero());
            existedHuman.setHasToothpick(human.checkHasToothpick());
            existedHuman.setImpactSpeed(human.getImpactSpeed());
            existedHuman.setSoundtrackName(human.getSoundtrackName());
            existedHuman.setMinutesOfWaiting(human.getMinutesOfWaiting());
            existedHuman.setWeaponType(human.getWeaponType());
            existedHuman.setCar(human.getCar());
        }
    }
    /**
     * Метод удаления элемента из коллекции по его id
     * @param id - id элемента, который пользователь хочет удалить
     * */
    @Override
    public void delete(int id) {
        HumanBeing existedHuman = get(id);

        if (existedHuman != null) {
            humanCcollection.remove(existedHuman);
        }
    }
    /**
     * Метод получения элемента из коллекции по его id
     * @param id - id элемента, который пользователь хочет получить
     * @return dragon - элемент коллекции
     * */
    @Override
    public HumanBeing get(int id) {
        for(HumanBeing dragon : humanCcollection){
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
    public void clear() {
        humanCcollection.clear();
    }

    @Override
    public void sort() {

    }

    /**
     * Метод возвращения информации о коллекции
     * @return output - информация о коллекции
     * */

//    @Override
//    public JsonObject getJSONDescription() {
//
//        JsonArrayBuilder dragons = Json.createArrayBuilder();
//        for (Dragon d: humanCcollection)
//            dragons.add(d.getJSONDescription());
//
//        JsonObject output = Json.createObjectBuilder().
//                add("type", humanCcollection.getClass().getSimpleName()).
//                add("size", humanCcollection.size()).
//                add("init date", initDateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu: HH:mm:ss"))).
//                add("availableId", availableId).
//                add("elements", dragons.build()).build();
//
//        return output;
//    }

}