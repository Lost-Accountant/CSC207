import java.util.ArrayList;

public class Operator {
    ArrayList<Command> commands = new ArrayList<>();

    public void executeAll(){
        for (Command command: commands){
            command.execute();
        }
    }

    public void acceptCommand(Command c){
        this.commands.add(c);
    }
}
