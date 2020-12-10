package ca.utoronto.utm.paint;

public class AddLineCommand implements Command{

    private PaintModel model;
    private LineComponent line;

    public AddLineCommand(PaintModel model, LineComponent line){
        this.model = model;
        this.line = line;
    }

    public void execute(){
        model.addLine(line);
    }

    public void unexecute(){
        model.removeLine(line);
    }

    public boolean isReversable(){
        return true;
    }
}
