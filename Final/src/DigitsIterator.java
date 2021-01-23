import java.util.Iterator;

public class DigitsIterator implements Iterator<Integer> {
    private int value;

    public DigitsIterator(int value){
        this.value = value;
    }

    public boolean hasNext(){
        return value != 0;
    }

    public Integer next() {
        if(hasNext()){
            int result = value % 10;
            this.value = value / 10;
            return result;
        }
        return null;
    }
}
