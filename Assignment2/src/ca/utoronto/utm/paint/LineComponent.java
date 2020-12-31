package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.LineConfiguration;

import java.util.ArrayList;

public interface LineComponent {
    public Point getStartPoint();

    public Point getEndPoint();

    public void setStartPoint(Point point);

    public void setEndPoint(Point point);

    public ArrayList<Point> getPoints();

    public void setConfiguration(LineConfiguration configuration);

    public LineConfiguration getConfiguration();
}
