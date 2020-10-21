public class demoSingleton {

    public static void main(String [] args){
        LazySingleton s1 = LazySingleton.getInstance();
        System.out.println(s1.getNum());

        LazySingleton s2 = LazySingleton.getInstance();
        s2.setNum(2);
        System.out.println(s1.getNum());
    }
}
