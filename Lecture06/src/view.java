import java.util.Observable;
import java.util.Observer;

public class view implements Observer {
    @Override
    public void update(Observable o, Object arg){
        // this method will be called
        // when observable calls notifyObserver()

        // type cast to data
        data tdata = (data)o;

        // tdata is just a data object

        System.out.println("observer is notified");
    }
}
