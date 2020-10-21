public final class LazySingleton {
    private static volatile LazySingleton instance = null;
    private int num;

    private LazySingleton(){
        this.num = 1;
    }

    public static synchronized LazySingleton getInstance(){
        // instance is static. independent of LazySingleton
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public int getNum(){
        return this.num;
    }

    public void setNum(int num){
        this.num = num;
    }
}
