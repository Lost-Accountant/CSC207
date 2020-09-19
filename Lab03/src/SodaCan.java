public class SodaCan {
    // HAS-A: type, amount, isOpen
    String type;
    boolean isOpen;
    int amount;

    // RESPONDS-TO: constructor, open, sip and gulp

    /**
     *
     * Construct a class SodaCan to emulate a soda can
     *
     * @param type the name or type of the soda in the can
     */
    public SodaCan(String type){
        this.type = type;
        this.isOpen = false;
        this.amount = 250;
    }
    // no type
    public SodaCan(){
        this("unknown");
    }

    // open
    public void openSodaCan(){
        this.isOpen = true;
    }

    // sip
    /**
     *
     * takes a sip of the soda, which is at most 10ml
     *
     * @return the amount of soda drank, at 10 ml or below.
     */
    public int sips(){
        // if can is not open
        if (this.isOpen == false){
            this.openSodaCan();
        }

        int before = this.amount;
        this.amount -= 10;
        if (this.amount < 0){
            this.amount = 0;
            return(before);
        } else {
            return(10);
        }
    }

    // gulps

    /**
     *
     * takes a gulp of the soda, which is at most 50ml
     *
     * @return the amount of soda drank, at 50 ml or below.
     */
    public int gulps(){
        // if can is not open
        if (this.isOpen == false){
            this.openSodaCan();
        }

        int before = this.amount;
        this.amount -= 50;
        if (this.amount < 0){
            this.amount = 0;
            return(before);
        } else {
            return (50);
        }
    }

    public String toString(){
        return "type: " + this.type +
                " ; amount: " + String.valueOf(this.amount) +
                " ; is it open? " + String.valueOf(this.isOpen);
    }

    public static void main(String[] args){
        SodaCan can1 = new SodaCan();
        SodaCan can2 = new SodaCan("Pepsi");
        can2.sips();
        can2.gulps();
        can2.gulps();
        System.out.println(can1.toString());
        System.out.println(can2.toString());
    }
}
