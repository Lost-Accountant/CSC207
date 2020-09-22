public class parent {
    int data;
    double data2;
    private parent(double data2){
        this.data2 = data2;
    }

    public parent(int data){
        this.data = data;
    }

    public int somemethod(){
        // does something with data then return it
        return this.data;
    }

    protected int somemethod2(){
        // does something with data then return it
        return this.data;
    }

    private int somemethod3(){
        // does something with data then return it
        return this.data;
    }
}
