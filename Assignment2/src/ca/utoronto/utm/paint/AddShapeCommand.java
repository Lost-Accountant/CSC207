package ca.utoronto.utm.paint;

public class AddShapeCommand implements Command{

    private PaintModel model; // invoker
    private Shape shape; // object to be passed

    public AddShapeCommand(PaintModel model, Shape shape){
        this.model = model;
        this.shape = shape;
    }

    public void execute(){
        model.addShape(shape);
    }

    public void unexecute(){
        model.removeShape(shape);
    }

    public boolean isReversable(){
        return true;
    }
}
