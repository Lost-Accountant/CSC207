import java.util.Observable;

public class data extends Observable {
    String data;
    public data(String s){
        this.data = s;
    }
    public void changedata(){
        this.data = "changes in data";
        this.notifyObservers();
    }
    public void attach(view v){
        this.addObserver(v);
    }
}
