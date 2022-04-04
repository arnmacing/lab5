package sourse;

import java.util.Objects;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(){

    }

    /**
     * @return X-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * @return Y-coordinate.
     */

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}




