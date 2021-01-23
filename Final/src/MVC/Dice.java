package MVC;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Dice extends Observable {
    private int d1, d2;
    Random r = new Random();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void roll(){
        d1 = r.nextInt(6) + 1;
        d2 = r.nextInt(6) + 1;

        this.setChanged();
        notifyObservers();
    }

    public int getD1(){return d1;}
    public int getD2(){return d2;}

    public void attachObserver(Observer o){
        this.observers.add(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}
