import java.util.Observable;

public class Model extends Observable{
    String a;
    public Model(){
        this.a = "1";
    }
    public void You_changed(){
        this.a = "2";
        // actual change is optional
        this.setChanged();
        // set flag to changed
        this.notifyObservers();
        // notify View
    }
}
