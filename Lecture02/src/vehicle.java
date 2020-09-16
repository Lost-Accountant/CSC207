public class vehicle {
    int fuel;
    public vehicle(int fuel){ // constructor
        this.fuel = fuel;
    }
}

// IS-A: subtype relationship
class car extends vehicle{
    int something = 2;

    // constructor
    public car(int fuel) {
        super(fuel);
    }
    // some method
    public int otherstuff(){
        return something;
    }
}

// HAS-A: composition relationship
class car2{
    vehicle v;
    // construct the class based on an existing class
    public car2 (int fuel){
        this.v = new vehicle(fuel);
    }

    public void otherstuff(){
        // other stuff
    }
}

// RESPONDS-TO: communication between objects
class person {
    car c;
    // constructor
    public person (){
        this.c = new car(100);
    }

    // method
    public int something(){
        // calls method of another class
        return this.c.otherstuff();
    }
}

class someotherthing {
    public static void main(String[] args){
        person p = new person();
        System.out.println(p.something());
    }
}