package utility;

import sourse.HumanBeing;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CollectionManager<T> {
    private ArrayList<HumanBeing> humanCollection = new ArrayList<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    private void loadCollection() {
        humanCollection = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * @return Коллекция.
     */

    public ArrayList<HumanBeing> getCollection() {
        return humanCollection;
    }

    /**
     * @return Время последней инициализации или null, если инициализации не было.
     */

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Время последнего сохранения или null, если сохранения не было.
     */

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return Тип коллекции.
     */
    public String collectionType() {
        return humanCollection.getClass().getName();
    }

    /**
     * @return Размер коллекции.
     */
    public int collectionSize() {
        return humanCollection.size();
    }


    /**
     * @param id ID человека.
     * @return Человек по его ID или null, если человек не найден.
     */
    public HumanBeing getById(Long id) {
        for (HumanBeing human : humanCollection) {
            if (human.getId().equals(id)) return human;
        }
        return null;
    }

    /**
     * Добавление нового человека в коллекцию.
     */

    public void addToCollection(HumanBeing human) {
        humanCollection.add(human);
    }

    /**
     * Удаление человека из коллекции.
     */

    public void removeFromCollection(HumanBeing human) {
        humanCollection.remove(human);
    }

    /**
     * Удалить из коллекции человека, превышающего заданный.
     */

    public void removeGreater(HumanBeing humanToCompare) {
        humanCollection.removeIf(human -> human. > 0);
    }

    /**
     * Clears the collection.
     */
    public void clearCollection() {
        marinesCollection.clear();
    }


}

/*    public int generateNextId();
    public void sort();
    public String getHelp();
    public String getInfo();
    public String show();
    public void add(T element);
    public void updateByID(Integer id, T newElement);
    public void removeByID(Integer id);
    public void clear();
    public void save();
    public void addIfMax(T element);
    public void printStartsWithName(String start);
    public boolean deserializeCollection(String json);
*/

