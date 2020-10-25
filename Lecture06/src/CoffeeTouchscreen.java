public class CoffeeTouchscreen {
    private CoffeeMachineInterface requester;

    public CoffeeTouchscreen(CoffeeMachineInterface requester){
        this.requester = requester;
    };

    public void chooseFirstSelection(){
        requester.chooseFirstSelection();
    }

    public void chooseSecondSelection(){
        requester.chooseSecondSelection();
    }


    public static void main(String [] args){
        OldCoffeeMachine oldMachine = new OldCoffeeMachine();
        CoffeeTouchscreenAdapter adapter = new CoffeeTouchscreenAdapter();

        adapter.connect(oldMachine);

        CoffeeTouchscreen newMachine = new CoffeeTouchscreen(adapter);
        newMachine.chooseFirstSelection();
        newMachine.chooseSecondSelection();
    }
}
