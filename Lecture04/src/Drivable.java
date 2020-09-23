public interface Drivable {
    // has to be public methods
    public void accelerate();
    public void brake();
    public void steer();

    // static final constant is okay too
    public static final int CONSTANT = 1;
}
