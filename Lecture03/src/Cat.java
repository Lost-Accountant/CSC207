public class Cat extends Animal{
    public Cat(){
        super("cat", "meow");
    }

    public void walk(){
        System.out.println("LOL. no. sleeping.");
    }

    public void purr(){
        System.out.println(this.name + " says purrrr");
    }

    public static void main(String [] args){
        Cat c1 = new Cat();
        c1.makeNoise();
        c1.walk();
        c1.purr();
    }
}
