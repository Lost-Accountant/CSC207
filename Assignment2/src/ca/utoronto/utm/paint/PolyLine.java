package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class PolyLine extends Squiggle{

    private ArrayList<LineComponent> lines;

    public PolyLine(Point startPoint){
        super(startPoint);
    }

    public void attachLine(LineComponent newLine){
        this.addPoint(newLine.getStartPoint());
        this.addPoint(newLine.getEndPoint());
    }

    public void removeLastLine(){
        this.removeLastPoint();
        this.removeLastPoint();
    }
}
