package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.ShapeConfiguration;
import ca.utoronto.utm.paint.Point;

public interface Shape {


    public Point getCentre();

    public abstract int getWidth();

    public abstract int getHeight();

    public void setCentre(Point centre);

    public abstract void setWidth(int width);

    public abstract void setHeight(int height);

    public void setConfiguration(ShapeConfiguration config);

    public ShapeConfiguration getConfiguration();
}
