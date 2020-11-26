package floatingpoint;

public class FunctionValues {

    public static void functionValues_v1(double start, double stop, double increment){
        double x;
        // don't expect floating point numbers to be exact.
        for (x=start; x <= stop; x += increment){
            System.out.println("x=" + x);
        }
    }

    public static void functionValues_v2(double start, double stop, double increment){
        double x = 0;
        for (int i = 1; i <= 5; i += 1){
            x = start + i *0.1;
            System.out.println("x=" + x);
        }
    }

    public static void main (String [] args){
        System.out.println("v1(0.1,0.5,0.1)");
        functionValues_v1(0.1,0.5,0.1);
        // accumulate small quantities.

        System.out.println("v1(1.1, 1.5, 0.1)");
        functionValues_v1(1.1,1.5,0.1);
        // only 4 iterations, expect 5


        System.out.println("v2(0.1,0.5,0.1)");
        functionValues_v2(0.1, 0.5, 0.1);
        // goes over the stop by 0.1

        System.out.println("v2(1.1,1.5,0.1)");
        functionValues_v2(1.1,1.5,0.1);
        // exactly right
    }
}
