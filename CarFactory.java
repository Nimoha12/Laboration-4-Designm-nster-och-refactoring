import java.util.Random;
import java.awt.*;

public class CarFactory {
    public static Car createRandomCar(Point pos) {
        int rand = new Random().nextInt(3);
        Car car  = switch (rand) {
            case 0 -> new Volvo240();
            case 1 -> new Saab95();
            case 2 -> new Scania();
            default -> throw new IllegalStateException();
        };
        car.setX(pos.x);
        car.setY(pos.y);
        return car;
    }

    public static Volvo240 createVolvo(Point pos){
        Volvo240 volvo = new Volvo240();
        volvo.setX(pos.x);
        volvo.setY(pos.y);
        return volvo;
    }

    public static Saab95 createSaab(Point pos){
        Saab95 saab = new Saab95();
        saab.setX(pos.x);
        saab.setY(pos.y);
        return saab;
    }

    public static Scania createScania(Point pos){
        Scania scania = new Scania();
        scania.setX(pos.x);
        scania.setY(pos.y);
        return scania;
    }
}
