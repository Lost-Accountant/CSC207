package ca.utoronto.utm.paint;

public interface Shape {
    public Point getCentre();

    public int getWidth();

    public int getHeight();

    public void setCentre(Point center);

    public void setWidth(int width);

    public void setHeight(int height);
}
