// specific command implementation

public class PlusV2Command implements Command {
    Data d;
    // Constructor
    // incorporate attributes
    public PlusV2Command(Data d){
        this.d = d;
    }

    // Implement execution of interface
    public void execute(){
        // increment by 1
        this.d.v2++;
    }
}
