import java.util.Iterator;

public class Digits implements Iterable<Integer>{
    private int value;

    public Digits(int value){
        System.out.println("Digits of " + value);
        this.value = value;
    }

    public Iterator<Integer> iterator(){
        return new DigitsIterator(this.value);
    }

    public static void main(String[] args){
        for (int d: new Digits(2019)){
            System.out.println(d);
        }

        for (int d: new Digits(9)){
            System.out.println(d);
        }
    }
}
