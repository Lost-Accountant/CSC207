public class Person {
    // HAS-A: amountOfSodaDrunk
    String thirstStatus;
    int amountDrunk;

    // RESPONDS-TO: constructor, sipFrom(sodaCan), gulpFrom(sodaCan), getThirstStatus()
    public Person(){
        this.thirstStatus = "very thirsty";
        this.amountDrunk = 0;
    }

    // set thirst status
    private void setThirstStatus(){
        if (this.amountDrunk >= 375) {
            this.thirstStatus = "satisfied";
        } else if (this.amountDrunk >= 175) {
            this.thirstStatus = "thirsty";
        }
    }

    // get thirst status
    public String getThirstStatus(){
        return this.thirstStatus;
    }

    public void takeSip(SodaCan can){
        this.amountDrunk += can.sips();
        this.setThirstStatus();
    }

    public void takeGulp(SodaCan can){
        this.amountDrunk += can.gulps();
        this.setThirstStatus();
    }

    public String toString(){
        return("thirst status: " + this.getThirstStatus() +
                "; amount drunk: " + String.valueOf(this.amountDrunk));
    }

    // main method
    public static void main(String [] args) {
        SodaCan can1 = new SodaCan();
        SodaCan can2 = new SodaCan("Pepsi");
        Person boy = new Person();

        System.out.println(can1.toString());
        System.out.println(boy);

        boy.takeGulp(can1);
        boy.takeSip(can1);
        boy.takeGulp(can1);
        boy.takeGulp(can1);

        System.out.println(can1.toString());
        System.out.println(boy);
        boy.takeGulp(can2);
        boy.takeGulp(can2);

        System.out.println(can1.toString());
        System.out.println(can2.toString());
        System.out.println(boy);

        boy.takeGulp(can2);
        boy.takeGulp(can2);
        boy.takeGulp(can2);
        System.out.println(can2.toString());
        System.out.println(boy);

    }
}
