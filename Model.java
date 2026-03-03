import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")

public class Model {

    //list for cars and volvo workshops.
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Workshop<Volvo240>> workshops = new ArrayList<>();

    //Logic objects
    private HitWall hitwall;
    private Collision collision;


    //Limit for how many cars
    private final int maxCars = 6;

    public Model(int panelWidth, int panelHeight) {
        //Create cars
        cars.add(CarFactory.createVolvo(new Point(0, 0)));
        cars.add(CarFactory.createSaab(new Point(0, 100)));
        cars.add(CarFactory.createScania(new Point(0, 200)));


        //Create workshop
        workshops.add(workshopFactory.createVolvoWorkshop(10, new Point(300, 300)));

        //Create logic objects
        hitwall = new HitWall(cars, panelWidth, panelHeight);
        collision = new Collision(cars,workshops);
    }

    public void update() {
        hitwall.CarHitsWall();
        collision.CollisionLoadCar();

        for (Car car : cars) {
            car.move();
        }
    }

    //Logic for all methods used in Controller
    void startAllEngines() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllEngines() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    // Calls the break method for each car once
    void brake(int amount) {
        for (Car car : cars) {
            double brake = ((double) amount) / 100;
            car.brake(brake);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void stopTurbo() {
        for (Car car : cars) {
            if (car instanceof Turboable turboable) {
                turboable.setTurboOff();
            }
        }
    }

    void startTurbo() {
        for (Car car : cars) {
            if (car instanceof Turboable turboable) {
                turboable.setTurboOn();
            }
        }
    }

    void liftTheBed(double degrees) {
        for (Car car : cars) {
            if (car instanceof Rampable rampable) {
                rampable.raiseRamp(degrees);
            }
        }
    }

    void lowerTheBed(double degrees) {
        for (Car car : cars) {
            if (car instanceof Rampable rampable) {
                rampable.lowerRamp(degrees);

            }
        }
    }

    public void addCar() {
        if (cars.size() >= maxCars) return;
        Point startPos = new Point(0, cars.size() * 100);
        cars.add(CarFactory.createRandomCar(startPos));

    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            cars.removeLast();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Workshop<Volvo240>> getWorkshops(){
        return workshops;
    }
}
