import java.io.*;
import java.util.*;

public class SunNums {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String line;
        int start, end;
        while(true){
            System.out.println("Starting number: ");
            start = scanner.nextInt();
            System.out.println("Ending number: ");
            end = scanner.nextInt();
            int sum = sumup(start, end);
            System.out.println("The sum from " + start + " to " + end + " is: " + sum);
        }
    }
    // Create static method sumup(s,e) which returns sum s + s+1 + ... + e-1 + e
    // or 0 if this sum does not make sense
    public static int sumup(int s, int e){
        if (s > e){
            return(0);
        } else{
            return((s+e) * (e-s+1)/2);
        }
    }
}

class CountTo10 {
    public static void main(String[] args){
        int i = 1;
        while (i <= 10){
            System.out.println(i);
            i += 1;
        }
    }
}

class PrimeTester {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String line;
        int input;
        while(true){
            System.out.println("Your chosen number: ");
            input = scanner.nextInt();
            if (isPrime(input)){
                System.out.println(input + " is prime");
            } else{
                System.out.println(input + " is not prime");
            }
        }
    }

    public static boolean isPrime(int n){
        // n is not positive integer
        if (n <= 1){
            return false;
        }
        else if (n <= 3){
            return true;
        }
        else if (n % 2 == 0 || n % 3 == 0){
            return false;
        }
        int i = 5;

        while (i*i <= n){
            if (n % i == 0 || n % (i + 2) == 0){
                return false;
            }
            i += 6;
        }
        return true;
    }
}