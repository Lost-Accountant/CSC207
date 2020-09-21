public abstract class Animal {
    String name;
    String sound;

    // constructor
    public Animal(String name, String sound){
        this.name = name;
        this.sound = sound;
    }

    // makes noise
    public void makeNoise(){
        System.out.println(this.name + " says " + this.sound);
    }

    // walk, abstract
    public abstract void walk();
}
