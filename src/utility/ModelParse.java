package utility;

import sourse.HumanBeing;

import java.util.ArrayList;

public class ModelParse {

    private ArrayList<HumanBeing> collections;

    public ModelParse(){
        collections = new ArrayList<>();
    }

    public ModelParse(ArrayList<HumanBeing> humanBeings){
        this.collections = humanBeings;
    }

    public void setHumanBeings(ArrayList<HumanBeing> humanBeings) {
        this.collections = humanBeings;
    }

    public ArrayList<HumanBeing> getHumanBeings(){
        return collections;
    }

}
