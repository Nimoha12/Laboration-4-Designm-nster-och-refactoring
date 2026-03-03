import java.awt.*;
import java.util.ArrayList;

public class Collision {
    ArrayList<Car> cars;
    ArrayList<Workshop<Volvo240>> workshops;

    public Collision(ArrayList<Car> cars, ArrayList<Workshop<Volvo240>> workshops){
        this.cars = cars;
        this.workshops = workshops;
    }

    public void CollisionLoadCar(){
        for (Car car : cars) {
            for (Workshop<Volvo240> ws : workshops){
             Rectangle carRect = new Rectangle(
                     (int) car.getX(),
                     (int) car.getY(),
                     car.getWidth(),
                     car.getHeight()
             );

             Rectangle wsRect = new Rectangle(
                     ws.getPosition().x,
                     ws.getPosition().y,
                     ws.getWidth(),
                     ws.getHeight()
             );

             if (carRect.intersects(wsRect)){
                 if (car instanceof Volvo240 volvo)
                     ws.load(volvo);
                }
            }
        }
    }
}
