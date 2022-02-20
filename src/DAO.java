import sourse.HumanBeing;
import utility.HumanAsker;
import javax.json.*;
import java.util.ArrayList;

public interface DAO {
    int create(HumanAsker properties);
    int update(int id, HumanAsker properties);
    int delete(int id);
    HumanBeing get(int id);
    ArrayList<HumanBeing> getAll();
    int clear();
    //JsonObject getJSONDescription();
    //void sort();
}
