package ca.utoronto.utm.paint.Command;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.Point;

public class AddPointCommand implements Command{

    private PaintModel model; // invoker
    private Point point; // object to be passed
    private boolean executed;

    public AddPointCommand(PaintModel model, Point point){
        this.model = model;
        this.point = point;
    }

    public void execute(){
        model.addPoint(point);
        this.executed = true;
    }

    public void unexecute(){
        model.removePoint(point);
        this.executed = false;
    }

    public boolean isReversable(){
        return true;
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }

    public Point getPoint(){
        return point;
    }

    public String toString(){
        return "Point, " + point.toString();
    }
}
