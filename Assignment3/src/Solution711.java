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


    public static void main(String[] args){
        System.out.println(solve(7.11)); // solves within 1 sec, probably because of 1 less loop.
        // System.out.println(solve(7.11)); // very slow
    }
}
