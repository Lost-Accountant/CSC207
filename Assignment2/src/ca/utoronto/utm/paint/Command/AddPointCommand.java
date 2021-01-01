package ca.utoronto.utm.paint.Command;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;

public class AddPointCommand implements Command{

    private PaintModel model; // invoker
    private Point point; // object to be passed

    public AddPointCommand(PaintModel model, Point point){
        this.model = model;
        this.point = point;
    }

    public void execute(){
        model.addPoint(point);
    }

    public void unexecute(){
        model.removePoint(point);
    }

    public boolean isReversable(){
        return true;
    }
}
