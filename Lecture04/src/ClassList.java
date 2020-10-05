import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassList implements Iterable<Student>{
    private List<Student> studentsEnrolled = new ArrayList<>();

    public void add(Student s){
        studentsEnrolled.add(s);
    }

    public void drop(Student s){
        studentsEnrolled.remove(s);
    }

    @Override
    public Iterator iterator(){
        return new ClassListiterator();
    }

    private class ClassListiterator implements Iterator<Student>{
        /**
         * The index of the next item in the class list.
         */
        int nextIndex = 0;
        @Override
        public boolean hasNext(){
            return nextIndex != studentsEnrolled.size();
        }

        @Override
        public Student next(){
            // use index to go around.
            Student result = studentsEnrolled.get(nextIndex);
            nextIndex++;
            return result;
        }
    }
}
