package utility;

import sourse.HumanBeing;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.ArrayList;

public class FileManager {
     public static java.util.Date lastInit;
     public static ArrayList<HumanBeing> humanCollection = new ArrayList<>();

    /**
     * Считывание коллекции из файла.
     */

    public ArrayList<HumanBeing> readCollection() {
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
