package sourse;

public class Car {
    private String name; //Поле может быть null
    private boolean cool;

    public Car(String name, boolean cool) {
        this.name = name;
        this.cool = cool;
    }

    /**
     * @return Name of the car.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Cool car.
     */

    public boolean checkCool() {
        return cool;
    }
}

