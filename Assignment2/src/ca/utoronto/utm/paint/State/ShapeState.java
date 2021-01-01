package ca.utoronto.utm.paint.State;

import ca.utoronto.utm.paint.Configuration.ShapeConfiguration;
import ca.utoronto.utm.paint.Shape.Shape;

public interface ShapeState extends State {
    public Shape getShapeCreated();

    public void setConfiguration(ShapeConfiguration configuration);
}
