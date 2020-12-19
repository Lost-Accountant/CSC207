package ca.utoronto.utm.paint;

public class Point {
    private int x, y;
    Point(int x, int y){
        this.x=x; this.y=y;
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