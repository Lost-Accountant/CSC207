package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class PolyLine extends Squiggle{

    public PolyLine(Point startPoint, Point endPoint){
        super(startPoint, endPoint);
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
