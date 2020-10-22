import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableFibonacci implements Iterable<Integer> {
    private int maxIndex;

    /**
     * Creates a new IterableFibonacci
     *
     * @param - maxIndex
     *            -- the index of the last Fibonacci number returned in this
     *            sequence
     * @throws IllegalArgumentException
     *             if maxIndex < 0
     **/
    public IterableFibonacci(int madIndex){
        if (madIndex < 0){
            throw new IllegalArgumentException();
        }
        this.maxIndex = madIndex;
    }

    public void setMaxIndex(int maxIndex){
        this.maxIndex = maxIndex;
    }

    public Iterator<Integer> iterator(){
        return new IteratorFibonacci();
    }

    private class IteratorFibonacci implements Iterator<Integer>{
        // two latest fibonacci numbers
        private int fib1 = 0;
        private int fib2 = 1;

        /**
         * @return - true if there are more elements in the sequence, false otherwise.
         */
        public boolean hasNext(){
            return (fib1 + fib2) <= maxIndex;
        }

        public Integer next(){
            int current = fib1 + fib2;
            fib1 = fib2;
            fib2 = current;
            return fib2;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
