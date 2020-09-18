public class balloon {
    // make variables private
    private String color;
    private double capacity;

    // non-static constructor = initialization
    public balloon(String color){
        this.color = color;
    }

    public balloon(double capa){
        this.capacity = capa;
    }

    // if user enter both constructor
    // can reuse constructor to save space
    public balloon(String color, double capa){
        //this(capa);
        //this(color);
        this.color = color;
        this.capacity = capa;
    }

    // interface methods
    // Getter
    public String getColor(){
        return this.color;
    }

    public double getCapacity(){
        return this.capacity;
    }

    // Setter
    public void setColor(String color){
        this.color = color;
    }

    public void setCapacity(double c){
        this.capacity = c;
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