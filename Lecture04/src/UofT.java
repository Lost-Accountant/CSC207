import java.util.Iterator;

/**
 * Manage people at the UofT
 */

public class UofT {

    // There are no functions. only methods.

    /**
     * The main method
     *
     * @param args the command-line arguments.
     */
    public static void main(String [] args){
        Student s1 = new Student("mary000", new String[]{"Mary"}, 1);
        Student s2 = new Student("mary001", new String[]{"Mary"}, 2);
        Student s3 = new Student("frank", new String[]{"frank"}, 3);

        ClassList classlist = new ClassList();
        classlist.add(s1);
        classlist.add(s2);
        classlist.add(s3);
        classlist.drop(s1);

        for (Student s:classlist){
            System.out.println(s);
        }

        Iterator<Student> myIter = classlist.iterator();
        System.out.println(myIter.hasNext());
        System.out.println(myIter.next());
        System.out.println(myIter.next());
        // equivalent to for loop
    }
}
