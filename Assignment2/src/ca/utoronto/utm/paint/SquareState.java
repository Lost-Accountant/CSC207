package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class SquareState implements State{
    private Square squareCreated;

    public SquareState(){
        this.squareCreated = null;
    }

    /**
     * When mouse pressed, create a square centered at where
     *      * the mouse position is. Before mouse dragged, the width
     *      * and height are both zero.
     */
    public void mousePressed(MouseEvent event){
        if(squareCreated == null) {
            Point centre = new Point(event.getX(), event.getY());
            squareCreated = new Square(centre, 0);
        }
    }

    /**
     * When mouse dragged, update the width of the square based on the distance between current position
     * and centre.
     *
     * The width is twice the distance in X or Y, whichever is bigger.
     *
     * @param event
     */
    public void mouseDragged(MouseEvent event){
        if(squareCreated != null){
            // update width, taking max distance
            int maxDistance = Math.max(Math.abs(event.getX() - squareCreated.getCentre().getX()),
                    Math.abs(event.getY() - squareCreated.getCentre().getY()));
            squareCreated.setWidth(2 * maxDistance);
        }
    }

    /**
     * When mouse is released, stopped changing the width
     * by setting the width one last time.
     *
     * @param event
     */
    public void mouseReleased(MouseEvent event){
        if(squareCreated != null){
            // update width, taking max distance
            int maxDistance = Math.max(Math.abs(event.getX() - squareCreated.getCentre().getX()),
                    Math.abs(event.getY() - squareCreated.getCentre().getY()));
            squareCreated.setWidth(2 * maxDistance);
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

    public Square getSquareCreated(){
        return this.squareCreated;
    }

    public void reset(){
        this.squareCreated = null;
    }
}
