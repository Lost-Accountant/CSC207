public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {
    private OldCoffeeMachine OldMachine;

    public void connect(OldCoffeeMachine OldMachine){
        this.OldMachine = OldMachine;
    } // link with method "connect"

    // can also link two with public constructor
    //public CoffeeTouchscreenAdapter(OldCoffeeMachine oldMachine){
    //    OldMachine = oldMachine;
    //}

    public void chooseFirstSelection(){
        OldMachine.selectA();
    }

    public void chooseSecondSelection(){
        OldMachine.selectB();
    }
}
