package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.LineConfiguration;

import java.util.ArrayList;

public class PolyLine implements LineComponent{

    private ArrayList<Point> points;
    private LineConfiguration configuration;

    public PolyLine(Point startPoint, LineConfiguration configuration){
        this.points = new ArrayList<Point>();
        this.points.add(startPoint);
        this.configuration = configuration;
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
        if (points.size() > 1) {
            return points;
        } else{
            ArrayList<Point> initialPoints = new ArrayList<Point>();
            initialPoints.add(this.getStartPoint());
            initialPoints.add(this.getEndPoint());
            return initialPoints;
        }
    }

    @Override
    public void setConfiguration(LineConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public LineConfiguration getConfiguration() {
        return configuration;
    }
}
