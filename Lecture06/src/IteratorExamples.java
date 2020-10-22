// from: http://cda.mrs.umn.edu/~elenam/2101Spring2016/examples/iterators.html

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class IteratorExamples {
    public static void main (String [ ] args){
        // For loop
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //initialize the array list to integers 0 to 9
        for (int i = 0; i < 10; ++i){
            numbers.add(i);
        }

        // printing the ArrayList in a for-each loop
        System.out.println("The array list:");
        for (Integer element: numbers) {
            System.out.print(element + " ");
        }
        System.out.println(); // print new line

        // adding all array list elements in a for-each loop:
        int sum = 0;
        for (Integer element: numbers) {
            sum += element;
        }
        System.out.println("The sum of all elements is " + sum);

        Stack<Integer> numStack = new Stack<Integer>();

        // pushing all elements of the array list onto the stack
        for (Integer element: numbers) {
            numStack.push(element);
        }

        // printing the stack in a for-each loop:
        System.out.println("The stack:");
        for (Integer element: numStack) {
            System.out.print(element + " ");
        }
        System.out.println(); // print new line

        // printing out stack in its order
        System.out.println("The stack:");
        while (!numStack.isEmpty()){
            System.out.println(numStack.pop());
        }
        System.out.println(); // print new line

        // Behind the scenes of a for-each loop.
        // This loop is equivalent to the sum loop above
        sum = 0;
        Iterator<Integer> theIterator = numbers.iterator();
        while (theIterator.hasNext()) {
            sum = sum + theIterator.next();
        }
        System.out.println("The sum of all elements is " + sum);

    }

}

