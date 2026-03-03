import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    //list of cars from CarController
    ArrayList<Car> cars;
    ArrayList<Workshop<Volvo240>> workshops;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars, ArrayList<Workshop<Volvo240>> workshops) {
        this.cars = cars;
        this.workshops = workshops;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars){
            int x = (int) car.getX();
            int y = (int) car.getY();
            g.drawImage(car.getImage(), x, y, null);
        }

        for (Workshop<?> ws : workshops){
            BufferedImage img = ws.getImage();
            Point pos = ws.getPosition();
            if(img !=null && pos !=null){
            g.drawImage(img, pos.x, pos.y, null);
        }}
    }}