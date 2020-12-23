package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class PolyLine implements LineComponent{

    private ArrayList<Point> points;

    public PolyLine(Point startPoint){
        this.points = new ArrayList<Point>();
        this.setStartPoint(startPoint);
    }

    public Point getStartPoint(){
        return points.get(0);
    }

    public Point getEndPoint(){
        return points.get(points.size() - 1);
    }

    public void setStartPoint(Point startPoint){
        points.set(0, startPoint);
    }

    public void setEndPoint(Point endPoint){
        points.set(points.size() - 1, endPoint);
    }

    public void addPoint(Point newPoint){
        points.add(newPoint);
    }

    public void removeLastPoint(){
        points.remove(points.size() - 1);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
