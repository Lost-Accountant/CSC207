import java.util.ArrayList;
import java.util.Iterator;

public class SimpleIteratorDemo {

    public static void main(String [] args){

        ArrayList<String> names = new ArrayList<String>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Doug");

        // these iterators are independent of each other
        Iterator<String> it = names.iterator();
        Iterator<String> it2 = names.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        // to show that it2 is independent
        System.out.println(it2.hasNext());
        System.out.println(it2.next());
        System.out.println(it2.next());

        // a for loop implementation
        for (String s : names){
            System.out.println(s);
        }

    }
}
