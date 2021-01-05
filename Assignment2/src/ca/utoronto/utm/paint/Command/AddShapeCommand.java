package ca.utoronto.utm.paint.Command;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Shape.Shape;

public class AddShapeCommand implements Command{

    private PaintModel model; // invoker
    private Shape shape; // object to be passed
    private boolean executed;

    public AddShapeCommand(PaintModel model, Shape shape){
        this.model = model;
        this.shape = shape;
    }

    public void execute(){
        model.addShape(shape);
        this.executed = true;
    }

    public void unexecute(){
        model.removeShape(shape);
        this.executed = false;
    }

    public boolean isReversable(){
        return true;
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }
}
