package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class RectangleState implements State{
    private Rectangle rectangleCreated;

    public RectangleState(){
        this.rectangleCreated = null;
    }

    /**
     * When mouse pressed, create a rectangle centered at where
     * the mouse position is. Before mouse dragged, the width
     * and height are both zero.
     * @param event
     */
    public void mousePressed(MouseEvent event){
        if(rectangleCreated == null) {
            Point centre = new Point(event.getX(), event.getY());
            rectangleCreated = new Rectangle(centre, 0, 0);
        }
    }

    /**
     * When mouse dragged, update the width and height of the
     * rectangle based on the distance between current position
     * and centre.
     *
     * The height is twice the distance in Y.
     * The width is twice the distance in X.
     *
     * @param event
     */
    public void mouseDragged(MouseEvent event) {
        if (this.rectangleCreated != null) {
            // update width
            rectangleCreated.setWidth(2 * Math.abs(event.getX() - rectangleCreated.getCentre().getX()));
            // update height
            rectangleCreated.setHeight(2 * Math.abs(event.getY() - rectangleCreated.getCentre().getY()));
        }
    }
    /**
     * When mouse is released, stopped changing the width and height
     * by setting the width and height one last time.
     * @param event
     */
    public void mouseReleased(MouseEvent event){
        if (this.rectangleCreated != null){
            // update width
            rectangleCreated.setWidth(2 * Math.abs(event.getX() - rectangleCreated.getCentre().getX()));
            // update height
            rectangleCreated.setHeight(2 * Math.abs(event.getY() - rectangleCreated.getCentre().getY()));
        }
    }

    public void mouseMoved(MouseEvent event){
        System.out.println("This doesn't do anything");
    }

    public void mouseEntered(MouseEvent event){
        System.out.println("This doesn't do anything");
    }

    public void mouseExited(MouseEvent event){
        System.out.println("This doesn't do anything");
    }

    public void mouseClicked(MouseEvent event){
        System.out.println("This doesn't do anything");
    }

    public Rectangle getRectangleCreated(){
        return this.rectangleCreated;
    }

    public void reset(){
        this.rectangleCreated = null;
    }

}
