import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("ALL")


// metoder ligger i CC men skulle kunna flyttas till en CarService
//För renare SRP och CC skulle då kunna anropa service-metoder istället
//för att hantera logiken själv ??


public class CarController {
    //20 updates a sec (hz)
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    //Logic objects
    private HitWall hitwall;
    private Collision collision;

    //Limit for how many cars
    private final int maxCars = 6;

    // view
    CarView frame;

    //list for cars and volvo workshops.
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Workshop<Volvo240>> workshops = new ArrayList<>();


    public CarController(){
        //Create cars
        cars.add(CarFactory.createVolvo(new Point(0,0)));
        cars.add(CarFactory.createSaab(new Point(0,100)));
        cars.add(CarFactory.createScania(new Point(0,200)));


        //Create workshop
        workshops.add(workshopFactory.createVolvoWorkshop(10,new Point(300,300)));


        //Create view
        frame = new CarView("CarSim 1.0", this);

        //Logic objects
        hitwall = new HitWall (cars,
                                frame.drawPanel.getWidth(),
                                frame.drawPanel.getHeight());

        collision = new Collision(cars, workshops);

        timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int panelWidth = frame.drawPanel.getWidth();
            int panelHeight = frame.drawPanel.getHeight();


            hitwall.CarHitsWall();
            collision.CollisionLoadCar();



          for (Car car : cars) {
              car.move();
               }

            frame.drawPanel.repaint();
        }
    }


    //methods:
    public static void main(String[] args) {
        // Instance of this class
        new CarController();
    }


    void startAllEngines() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllEngines(){
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

    void stopTurbo(){
        for (Car car : cars){
            if (car instanceof Turboable turboable){
                turboable.setTurboOff();
            }
        }
    }
    void startTurbo(){
        for (Car car : cars){
            if (car instanceof Turboable turboable) {
                turboable.setTurboOn();
            }
        }
    }
    void liftTheBed(double degrees){
        for (Car car: cars){
            if (car instanceof Rampable rampable){
                rampable.raiseRamp(degrees);
            }
        }
    }
    void lowerTheBed(double degrees){
        for(Car car: cars){
            if (car instanceof Rampable rampable){
                rampable.lowerRamp(degrees);

            }
        }
    }

    public void addCar() {
        if(cars.size() >= maxCars) return;
        Point startPos = new Point (0, cars.size() * 100);
       cars.add(CarFactory.createRandomCar(startPos));

    }

    public void removeCar() {
        if(!cars.isEmpty()) {
            cars.remove(cars.size()-1);
        }


    }
}
