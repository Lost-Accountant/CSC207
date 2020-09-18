public class Circle {
    double radius;
    String color;
    static int numCircles = 0;

    // complete constructor
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
        numCircles += 1;
    }

    // Constructor, no input
    public Circle() {
        this(1.0, "white");
    }

    // Constructor, no radius
    public Circle(String color){
        this(1.0, color);
    }

    // Constructor, no color
    public Circle(double radius){
        this(radius, "white");
    }

    // getter for numCircles

    public static int getNumCircles() {
        return numCircles;
    }

    public static void main (String [] args){
        Circle c1 = new Circle("red");
        System.out.println(getNumCircles());

        Circle c2 = new Circle(3.0);
        System.out.println(getNumCircles());
    }
}
