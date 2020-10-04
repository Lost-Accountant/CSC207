import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator implements Iterator{

    /**
     * The start of the range.
     */
    private final int start;

    /**
     * The end of the range.
     */
    private final int end;

    /**
     * The next number
     */
    private int next;

    /**
     * An iterator over the numbers in start .. end, inclusive.
     *
     * @param start the first number in the range.
     * @param end the last number in the range.
     */
    public RangeIterator(int start, int end){
        this.start = start;
        this.end = end;
        this.next = start;
    }

    @Override
    public boolean hasNext(){
        // whether the next is within the range
        return next <= end;
    }

    @Override
    public Object next(){
        if (!hasNext()){
            // not have next
            // the next number of out of range
            throw new NoSuchElementException(
                    String.format("End of range [%s .. %s]", start, end));
            // %s is where string falls in.
        }

        // pattern for method next:
        // 1. Remember the result
        // 2. Get ready for the next call to next (this is often in a helper method)
        // 3. Return what you remembered
        Integer result = next;
        next++;
        return result;
        // return current (previous) next
        // increment the next.
    }
}
