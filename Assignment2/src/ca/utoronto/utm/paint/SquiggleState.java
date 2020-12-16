package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class SquiggleState implements State{
    private Squiggle squiggleCreated;
    private boolean completed;

    public SquiggleState(){
        this.squiggleCreated = null;
        this.completed = false;
    }

    /**
     * Create the initial point of the squiggle.
     * @param event
     */
    public void mousePressed(MouseEvent event){
        if(squiggleCreated == null){
            squiggleCreated = new Squiggle(new Point(event.getX(), event.getY()));
        }
    }

    /**
     * Extends the squiggle created by adding point as mouse dragged
     *
     * @param event
     */
    public void mouseDragged(MouseEvent event){
        if(squiggleCreated != null){
            squiggleCreated.addPoint(new Point(event.getX(), event.getY()));
        }
    }

    /**
     * Add last point to the squiggle
     * @param event
     */
    public void mouseReleased(MouseEvent event){
        if(squiggleCreated != null){
            squiggleCreated.addPoint(new Point(event.getX(), event.getY()));
            this.completed = true;
        }
    }

    public void mouseMoved(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    public void mouseEntered(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    public void mouseExited(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    public void mouseClicked(MouseEvent event){
        System.out.println("This doesn't do anything");
    }

    public void reset(){
        this.squiggleCreated = null;
        this.completed = false;
    }

    public Squiggle getSquiggleCreated(){
        return this.squiggleCreated;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }
}
