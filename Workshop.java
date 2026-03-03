import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SuppressWarnings("ALL")
public class Workshop < T extends Car > {
    private final Storable <T> workshop;
    private final Point position;
    private BufferedImage image;

    public Workshop(int capacity, Point position, String imagePath) {
        workshop = new Storable<>(capacity);
        this.position = position;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public BufferedImage getImage(){
        return image;
    }
    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
       return image.getHeight();
    }
}
