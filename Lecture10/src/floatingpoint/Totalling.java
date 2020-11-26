package floatingpoint;

public class Totalling {

    public static double sum1(double startingAmount, double amount, int howMany){

        double answer = startingAmount;
        for (int i = 0; i < howMany; i++){
            answer += amount;
        }

        return answer;
        // add small quantity at first, accumulate, will not lose Mantissa
    }

    public static double sum2(double startingAmount, double amount, int howMany){

        double answer = 0;
        for (int i = 0; i < howMany; i++){
            answer += amount;
        }

        answer += startingAmount;
        // add small quantity at the end, might lose its Mantissa
        return answer;
    }

    public static void main(String [] args){
        double v1 = sum1(1, 10e-17, 10);
        double v2 = sum2(1, 10e-17, 10);
        System.out.println(v1 + " vs " + v2); // 1.0 vs 1.000000000000001
    }
}
