package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.ShapeConfiguration;

/**
 * Draw a rectangle that is part of the shape interface.
 * With width and height that can be the same or different.
 */
public class Rectangle implements Shape{
    private int width;
    private int height;
    private Point centre;
    private ShapeConfiguration configuration;

    public Rectangle(Point centre, int height, int width, ShapeConfiguration configuration){
        this.centre = centre;
        this.height = height;
        this.width = width;
        this.configuration = configuration;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setConfiguration(ShapeConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public ShapeConfiguration getConfiguration() {
        return configuration;
    }
}
