package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.LineConfiguration;

import java.util.ArrayList;

public class Line implements LineComponent {

    private Point startPoint;
    private Point endPoint;
    private LineConfiguration configuration;

    public Line(Point startPoint, Point endPoint, LineConfiguration configuration){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.configuration = configuration;
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

    @Override
    public void setConfiguration(LineConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public LineConfiguration getConfiguration() {
        return configuration;
    }
}
