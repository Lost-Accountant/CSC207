package ca.utoronto.utm.paint;

public class Point {
    private int x, y;
    private String color;
    private int stroke;


    Point(int x, int y, String color, int stroke){
        this.x=x; this.y=y;
        this.color = color;
        this.stroke = stroke;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistance(Point p1){
        return (int) Math.hypot(Math.abs(this.getX() - p1.getX()), Math.abs(this.getY() - p1.getY()));
    }
}