package dao;

import sourse.HumanBeing;
import utility.HumanAsker;

import javax.json.*;
import java.util.ArrayList;

public interface DAO {
    int create(HumanBeing human);

    void update(HumanBeing human);

    void delete(int id);

    void clear();

    void sort();

    HumanBeing get(int id);

    ArrayList<HumanBeing> getAll();

}
