package ca.utoronto.utm.paint;

public interface Shape {


    public Point getCentre();

    public abstract int getWidth();

    public abstract int getHeight();

    public void setCentre(Point centre);

    public abstract void setWidth(int width);

    public abstract void setHeight(int height);
}
