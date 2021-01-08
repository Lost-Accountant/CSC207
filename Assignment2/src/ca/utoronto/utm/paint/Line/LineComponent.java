package ca.utoronto.utm.paint.Line;

import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Point;

import java.util.ArrayList;

public interface LineComponent {
    public Point getStartPoint();

    public Point getEndPoint();

    public void setStartPoint(Point point);

    public void setEndPoint(Point point);

    public ArrayList<Point> getPoints();

    public void setConfiguration(Configuration configuration);

    public Configuration getConfiguration();

    public String toString();
}
