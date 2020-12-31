package ca.utoronto.utm.paint;


import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Configuration.PointConfiguration;
import sun.security.krb5.Config;

public class Point {
    private int x, y;
    private PointConfiguration configuration;

    Point(int x, int y, PointConfiguration config){
        this.x=x; this.y=y;
        this.configuration = config;
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

    public void setConfiguration(PointConfiguration config){
        this.configuration = config;
    }

    public Configuration getConfiguration(){
        return configuration;
    }

    public int getDistance(Point p1){
        return (int) Math.hypot(Math.abs(this.getX() - p1.getX()), Math.abs(this.getY() - p1.getY()));
    }
}