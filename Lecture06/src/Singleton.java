public class Singleton {
    // the object starts with nothing
    private static Singleton instance = null;
    private String color;

    // private constructor makes sure that
    // we can only call it wihtin the same object
    private Singleton(){
        this.color = "red";
    }

    // "synchronized" makes sure that two threads
    // cannot accidentally create two singleton objects
    // at the same time
    public static synchronized Singleton getInstance(){
        // if haven't been initialized
        if (instance == null){
            // already specified the type of instance at first.
            instance = new Singleton();
        }

        return instance;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
