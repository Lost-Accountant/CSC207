package ca.utoronto.utm.paint.Command;

import ca.utoronto.utm.paint.Line.LineComponent;
import ca.utoronto.utm.paint.PaintModel;

public class AddLineCommand implements Command{

    private PaintModel model;
    private LineComponent line;
    private boolean executed;

    public AddLineCommand(PaintModel model, LineComponent line){
        this.model = model;
        this.line = line;

    }

    public void execute(){
        model.addLine(line);
        this.executed = true;
    }

    public void unexecute(){
        model.removeLine(line);
        this.executed = false;
    }

    public boolean isReversable(){
        return true;
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }

    public LineComponent getLine(){
        return line;
    }

    public String toString(){
        String type = "Line";

        String lineType = "";

        String config = this.getLine().getConfiguration().toString();



        return "";
    }
}
