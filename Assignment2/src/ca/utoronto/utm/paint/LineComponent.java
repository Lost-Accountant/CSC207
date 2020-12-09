package ca.utoronto.utm.paint;

public interface LineComponent {
    public Point getStartPoint();

    public Point getEndPoint();

    public void setStartPoint(Point point);

    public void setEndPoint(Point point);
}
