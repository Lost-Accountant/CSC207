import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrate the use of an iterator
 */
public class DemoIterator {
    private static void rangeIntro(){
        Iterator range = new RangeIterator(3,6);
        System.out.println(range.hasNext()); //yes, next is 3
        System.out.println(range.next()); // return then increment, previous next is 3
        System.out.println(range.next()); // previous next is 4
        System.out.println(range.hasNext()); // yes, previous next is 4
        System.out.println(range.next()); // previous next is 5
        System.out.println(range.next()); // previous next is 6
        System.out.println(range.hasNext()); // previous next has been incremented, next is 7
        // System.out.println(range.next()); // cause exception, out of range.
    }

    private static int sumIterator(Iterator<Integer> range){
        int sum = 0;
        while (range.hasNext()){
            sum += (Integer) range.next();
        }
        return sum;
    }

    private static void iterableIntro(){
        List<Integer> myList = new ArrayList<>();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        Iterator<Integer> iter1 = myList.iterator();
        Iterator<Integer> iter2 = myList.iterator();
        System.out.println("iter1: " + iter1.next()); // 0
        System.out.println("iter1: " + iter1.next()); // 1
        System.out.println("iter2: " + iter2.next()); // 0
        System.out.println("iter1: " + iter1.next()); // 2
        System.out.println("iter1: " + iter1.hasNext()); // 3, no
        System.out.println("iter2: " + iter2.hasNext()); // 1, yes
        System.out.println("iter2: " + iter2.next()); // 1
    }

    private static void foreachDemo(){
        List<Integer> myList = new ArrayList<>();
        myList.add(0);
        myList.add(1);
        myList.add(2);

        // Why the independence is important; the foreach loop uses iterators under the hood.
        for (Integer i1 : myList){
            for (Integer i2: myList){
                System.out.println(i1 + " " + i2);
            }
        }
    }

    public static void main(String[] args){
        rangeIntro();

        Iterator range = new RangeIterator(3, 6);
        int sum = sumIterator(range);
        System.out.println(sum);

        iterableIntro();

        foreachDemo();
    }
}
