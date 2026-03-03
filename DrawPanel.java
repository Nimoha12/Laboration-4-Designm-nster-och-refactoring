import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

// This panel represents the animated part of the view with the car images.
@SuppressWarnings("ALL")
public class DrawPanel extends JPanel {
    private CarController controller;

    //Map that matches cars to respective car image
    Map<Class<? extends Movable>, BufferedImage> images = new HashMap<>();

    //Map for workshop pictures
    Map<Class<? extends Workshop<?>>, BufferedImage> WorkshopImages = new HashMap<>();


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController controller) {
        this.controller = controller;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);

        try {
            //Add car images
            images.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            images.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            images.put(Scania.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

            WorkshopImages.put(VolvoWorkshop.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
        // This method is called each time the panel updates/refreshes/repaints itself
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);

            for (Car car : controller.getCars()) {
                BufferedImage image = images.get(car.getClass());

                int carX = (int) car.getX();
                int carY = (int) car.getY();
                if (image !=null) {
                    g.drawImage(image, carX, carY, null);
            }
        }

            for (Workshop<?> ws : controller.getWorkshops()) {
                BufferedImage img = WorkshopImages.get(ws.getClass());
                Point pos = ws.getPosition();
                if (img != null && pos != null) {
                    g.drawImage(img, pos.x, pos.y, null);
                }
            }
        }
    }
