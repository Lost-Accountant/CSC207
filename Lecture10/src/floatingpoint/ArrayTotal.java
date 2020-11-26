package floatingpoint;

import java.util.Arrays;
import java.util.Random;

public class ArrayTotal {
    /**
     * Creates an array of n doubles.
     * @param n the size of the array to create.
     * @return An array of size n doubles.
     */
    public static double[] createList(int n){
        Random r = new Random();
        double[] list = new double[n];

        list[0] = 1;

        for (int i = 1; i < n; i++){
            list[i] = r.nextDouble() * 1.0e-17;
            // over 17, not saved by 17 shifts
            // if smaller than 17, many decimals can be saved.
        }

        // Large quantity then many small quantities.

        return list;
    }

    /**
     * Sums the items of array list.
     * @param list An array of doubles.
     * @return The sum of the items in list
     */
    public static double sum1(double[] list){
        double answer = 0.0;
        for (int i = 0; i < list.length; i++){
            answer += list[i];
        }
        return answer;
        // add Large quantity directly with next small quantity. Might lose Mantissa.
    }

    /**
     * Sums the items of array list.
     * @param list An array of doubles.
     * @return The sum of the items in list
     */
    public static double sum2(double[] list){
        Arrays.sort(list);

        double answer = 0.0;
        for (int i = 0; i < list.length; i++){
            answer += list[i];
        }
        return answer;
        // accumulate small quantities first then add large quantity, will not lose Mantissa.
    }

    public static void main(String [] args){
        double[] list = createList(1000000);
        double v1 = sum1(list);
        double v2 = sum2(list);

        System.out.println(v1 + " vs " + v2);
        // 1.0 vs 1.0000000000004996
        // first one completely lost all its small numbers
    }
}
