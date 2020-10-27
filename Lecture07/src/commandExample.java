public class commandExample {

    public static void main(String[] args){
        Data d = new Data(123, 456);
        Operator o = new Operator();

        // add commands
        o.acceptCommand(new PlusV1Command(d));
        o.acceptCommand(new PlusV2Command(d));

        // execute
        o.executeAll();

        // result
        System.out.println(d.v1);
        System.out.println(d.v2);
    }
}
