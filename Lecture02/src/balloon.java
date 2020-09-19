import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class balloon {
    // make variables private
    private String color;
    private double capacity;
    private int amount;
    private boolean popped;
    private static int numBalloons = 0;

    public balloon(String color, double capa,
                   int amount, boolean popped){
        this.color = color;
        this.capacity = capa;
        this.amount = amount;
        this.popped = popped;
        numBalloons += 1;
    }

    public balloon(){
        this("invisible", 1.0, 0, false);
    }

    // interface methods
    // Getter
    public String getColor(){
        return this.color;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public static int getNumBalloons(){
        return numBalloons;
    }

    // Setter
    public void setColor(String color){
        this.color = color;
    }

    public void setCapacity(double c){
        this.capacity = c;
    }

    public static void main(String[] args){
        balloon b1 = new balloon();
        System.out.println(getNumBalloons());
        System.out.println(b1);
        balloon b2 = new balloon("green", 50, 500, true);
        System.out.println(b2);
        balloon b3 = new balloon();
        System.out.println(getNumBalloons());
    }
}

// use of static
class someotherthing1 {
    static int a = 1;
    public static void main (String [] args){
        System.out.println(a);
        // a is an independent variable
    }
}

// without static
//public class someotherthing2{
  //  int a = 1;
   // public static void main(String[] args){
     //   System.out.println(this.a);
        // a becomes a property of this class
   // }
//}