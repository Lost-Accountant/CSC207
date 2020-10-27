// specific command implementation

public class PlusV1Command implements Command {
    Data d;
    // Constructor
    // incorporate attributes
    public PlusV1Command(Data d){
        this.d = d;
    }

    // Implement execution of interface
    public void execute(){
        // increment by 1
        this.d.v1++;
    }
}
