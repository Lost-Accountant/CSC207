public class children extends parent{
    public children(int data){
        super(data);
    }

    //public children(double data2){
    //    super(data2);
    // would error since constructor is private in the parent
    //}

    public int somemethod4(){
        super.somemethod();
        // no error. since public

        super.somemethod2();
        // no error. children can access protected method in parent

        //super.somemethod3();
        // error, since it is private
        return this.data;
    }

    // can override

    @Override
    public int somemethod() {
        // do something different
        return this.data;
    }
}
