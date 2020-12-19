package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class Line implements LineComponent {

    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getStartPoint(){
        return startPoint;
    }

    public void setStartPoint(Point point){
        this.startPoint = point;
    }

    public void setEndPoint(Point point){
        this.endPoint = point;
    }

    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(this.getStartPoint());
        points.add(this.getEndPoint());
        return points;
    }
}
