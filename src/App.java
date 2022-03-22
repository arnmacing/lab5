import dao.DAO;
import utility.*;

/**
 * Класс App, запускающий программу.
 */

public class App {

    private final DAO dao;

    public App(DAO dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        Console.run("LABA");
    }

    //todo exit ebaniy
    //todo date&time formatter

}