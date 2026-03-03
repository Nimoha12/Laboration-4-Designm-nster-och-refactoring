import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings("ALL")

public class CarController {
    //20 updates a sec (hz)
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    //Logic object
    private Model model;

    // view
    CarView frame;


    public CarController(){
        //Create view
        frame = new CarView("CarSim 1.0", this);

        int panelWidth = frame.drawPanel.getWidth();
        int panelHeight = frame.drawPanel.getHeight();
        //Logic object
        model = new Model(panelWidth,panelHeight);

        timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
            frame.drawPanel.repaint();
        }
    }

    //Methods
    void startAllEngines() {
        model.startAllEngines();
    }

    void stopAllEngines(){
        model.stopAllEngines();
    }

    void brake(int amount) {
        model.brake(amount);
    }

    void gas(int amount) {
        model.gas(amount);
    }

    void stopTurbo(){
        model.stopTurbo();
    }
    void startTurbo(){
        model.startTurbo();
    }
    void liftTheBed(double degrees){
        model.liftTheBed(degrees);
    }


    void lowerTheBed(double degrees){
        model.lowerTheBed(degrees);
    }

    public void addCar() {
       model.addCar();

    }

    public void removeCar() {
      model.removeCar();
    }

    public List<Car> getCars() {
        return model.getCars();
    }

    public List<Workshop<Volvo240>> getWorkshops(){
        return model.getWorkshops();
    }
}
