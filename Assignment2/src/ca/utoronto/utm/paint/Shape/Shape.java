package ca.utoronto.utm.paint.Shape;

import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Point;

public interface Shape {


    public Point getCentre();

    public abstract int getWidth();

    public abstract int getHeight();

    public void setCentre(Point centre);

    public abstract void setWidth(int width);

    public abstract void setHeight(int height);

    public void setConfiguration(Configuration config);

    public Configuration getConfiguration();

    public String toString();
}
