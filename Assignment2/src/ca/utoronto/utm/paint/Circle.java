package ca.utoronto.utm.paint;

/**
 * Draw a circle that is part of the shape interface.
 * width and height are the same, being double the radius
 */
public class Circle implements Shape{

    private int radius;
    private Point centre;

    public Circle(Point centre, int radius){
        this.radius = radius;
        this.centre = centre;
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

    public void setCentre(Point centre){
        this.centre = centre;
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
}
