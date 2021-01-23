import java.util.ArrayList;

public class Box {
    int val;
    public Box(int v){
        this.val = v;
    }

    public void increment(){
        this.val += 1;
    }

    public static void show(ArrayList<Box> lst){
        System.out.println("show");
        for (Box x: lst){
            System.out.println(x.val);
        }
    }

    public static ArrayList<Box> func(ArrayList<Box> lst){
        lst.get(0).increment();
        lst.remove(0);
        lst = new ArrayList<Box>();
        lst.add(new Box(11));
        return lst;
    }

    public static void main(String [] args){
        Box x = new Box(2);
        ArrayList<Box> lst = new ArrayList<Box>();
        lst.add(x);
        lst.add(new Box(7));
        x.increment();
        show(lst);
        show(func(lst));
        show(lst);
    }

}
