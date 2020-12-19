package ca.utoronto.utm.paint;

import java.util.ArrayList;

public interface LineComponent {
    public Point getStartPoint();

    public Point getEndPoint();

    public void setStartPoint(Point point);

    public void setEndPoint(Point point);

    public ArrayList<Point> getPoints();
}
