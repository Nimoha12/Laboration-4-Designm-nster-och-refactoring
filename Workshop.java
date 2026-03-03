import java.awt.*;

@SuppressWarnings("ALL")
public class Workshop < T extends Car > {
    private final Storable <T> workshop;
    private final Point position;
    private int width;
    private int height;

    public Workshop(int capacity, Point position, int width, int height) {
        workshop = new Storable<>(capacity);
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Point getPosition() {
        return position;
    }

    //loads car into workshop if workshop is not full
    public void load(T car){
       workshop.store(car);
    }

    //removes the desired car
    public T unload(T car){
        return workshop.unload(car);
    }


    //gets number of cars currently in workshop
    public int getNumberOfCars(){
        return workshop.size();
    }

    //gets the max capacity for the workshop
    public int getCapacity()
    {return workshop.getCapacity();}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
