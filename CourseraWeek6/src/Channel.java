import java.util.ArrayList;

public class Channel implements Subject{
    private ArrayList<Observer> observers;
    private String channelName;
    private String status;

    public Channel(String channelName){
        this.channelName = channelName;
        this.status = "not live";
        this.observers = new ArrayList<Observer>();
    }

    public String getChannelName() {
        return channelName;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers){
            o.update(status);
        }
    }

    @Override
    public void registerObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o){
        observers.remove(o);
    }
}
