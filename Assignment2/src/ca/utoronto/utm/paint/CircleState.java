package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class CircleState implements State{
    private Circle circleCreated;

    public CircleState(){
        this.circleCreated = null;
    }

    public void mouseMoved(MouseEvent event){
        System.out.println("This doesn't do anything");
    }

    /**
     * When mouse pressed, create a circle centered at where mouse pressed.
     * Before mouse dragged, the radius is zero.
     * @param event
     */
    public void mousePressed(MouseEvent event){
        Point centre = new Point(event.getX(), event.getY());
        circleCreated = new Circle(centre, 0);
    }

    /**
     * When mouse dragged, increase the radius of the circle by taking the distance
     * between centre and current position.
     * @param event
     */
    public void mouseDragged(MouseEvent event){
        Point currentPosition = new Point(event.getX(), event.getY());
        int newRadius = circleCreated.getCentre().getDistance(currentPosition);
        circleCreated.setRadius(newRadius);
    }
}
