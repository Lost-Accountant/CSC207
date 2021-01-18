import java.util.ArrayList;
import java.util.Arrays;

public class Solution711 {

    public static String solve(double price){
        int factor = 100;
        int transformed = (int) Math.round(price * factor);

        // minimum price is 1 cent
        for (int a = 1; a < transformed; a++){
            // limit the max of b (and c and d)
            int maxB = transformed - a;
            for (int b = 1; b < maxB; b++){
                // C limited by space occupied by b
                int maxC = maxB - b;
                for (int c = 1; c < maxC; c++){
                    // d limited by space occupied by c (and b)
                    int d = maxC - c;
                    // fully occupies space, so sum is always == transformed
                    // only need to check multiplication

                    // 100 ^ 3 because transformed already uses 100 ^ 1
                    if ( a * b * c * d == transformed * Math.pow(factor, 3)){
                        return ("a = " + (double) a/100 + ", " +
                                "b = " + (double) b/100 + ", " +
                                "c = " + (double) c/100 + ", " +
                                "d = " + (double) d/100);
                    }
                }
            }

        }
        // no solution
        return "";
    }

    public static ArrayList<Integer> solveRecursive(double price, int number, ArrayList<Integer> previous, double originalP){
        if (price == originalP){
            previous = new ArrayList<Integer>();
        }

        if (number == 1){
            int x = (int) Math.round(price * 100);
            int product = x;
            for (int each: previous){
                product = product * each;
            }

            int finalPrice = (int) Math.round(originalP * Math.pow(100, previous.size() + 1));
            if (product == finalPrice){
                previous.add(x);
                System.out.println("a = " + (double) previous.get(0)/100 + ", " +
                        "b = " + (double) previous.get(1)/100 + ", " +
                        "c = " + (double) previous.get(2)/100 + ", " +
                        "d = " + (double) previous.get(3)/100);
                return previous;
            } else {

            }
        } else {
            int transformed = (int) Math.round(price * 100);
            for (int x = 1; x < transformed; x++){
                int maxY = transformed -  x;
                previous.add(x);
                //System.out.println(previous);
                ArrayList<Integer> result = solveRecursive((double) maxY/100, number - 1, previous, originalP);
                if (result != null){
                    return null;
                }
                previous.remove(previous.size() - 1);
                //System.out.println(previous);
                // if that was a dead end.
            }
        }
        return null;
    }


    public static void main(String[] args){
        System.out.println(solve(7.11)); // solves within 1 sec, probably because of 1 less loop.
        System.out.println(solveRecursive(7.11, 4, null, 7.11));

    }
}
