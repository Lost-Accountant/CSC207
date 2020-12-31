package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.ShapeConfiguration;

/**
 * Draw a circle that is part of the shape interface.
 * width and height are the same, being double the radius
 */
public class Circle implements Shape{
    private Point centre;
    private int radius;
    private ShapeConfiguration configuration;

    public Circle(Point centre, int radius, ShapeConfiguration configuration){
        this.centre = centre;
        this.radius = radius;
        this.configuration = configuration;
    }

    public Point getCentre(){
        return centre;
    }

    public int getWidth() {
        return (2 * radius);
    }

    public int getHeight(){
        return (2 * radius);
    }

    public int getRadius(){
        return radius;
    }

    public void setWidth(int width){
        this.radius = width / 2; // integer division
    }

    public void setHeight(int height){
        this.radius = height / 2; // integer division
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public void setCentre(Point centre){
        this.centre = centre;
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
