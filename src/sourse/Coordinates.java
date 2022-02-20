package sourse;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
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
}
//todo нужен нам этот овррайд или нахуй удаляем?
    /* @Override
    public int hashCode() {
       return
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Sourse.Coordinates) {
            Sourse.Coordinates coordinatesObj = (Sourse.Coordinates) obj;
            return (x == coordinatesObj.getX()) && y.equals(coordinatesObj.getY());
        }
        return false;
    }
    */

