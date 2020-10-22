import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableString implements Iterable<Character> {
    private String theString;

    public IterableString(String string){
        theString = string;
    }

    /**
     * Returns an iterator for the string that iterates character by character
     **/
    public Iterator<Character> iterator() {
        return new StringIterator();
    }

    // the iterator is a private inner class
    private class StringIterator implements Iterator<Character>{
        private int position = 0;

        public boolean hasNext(){
            return position < theString.length();
        }

        public Character next(){
            if (hasNext()){
                Character current = theString.charAt(position);
                ++position;
                return current;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new NoSuchElementException();
        }
    }
}
