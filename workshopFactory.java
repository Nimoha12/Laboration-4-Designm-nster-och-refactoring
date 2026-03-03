import java.awt.*;

public class workshopFactory {
    public static Workshop<Volvo240> createVolvoWorkshop(int capacity, Point pos){
        return new VolvoWorkshop(capacity, pos);
    }

}
