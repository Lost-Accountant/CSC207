package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class SquiggleState implements LineComponentState{
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
        System.out.println("Pressing!");
    }

    /**
     * Extends the squiggle created by adding point as mouse dragged
     *
     * @param event
     */
    public void mouseDragged(MouseEvent event){
        if(squiggleCreated != null){
            System.out.println("Not null anymore");
            squiggleCreated.addPoint(new Point(event.getX(), event.getY()));
        }
        System.out.println("Dragging!");
    }

    /**
     * Add last point to the squiggle
     * @param event
     */
    public void mouseReleased(MouseEvent event){
        if(squiggleCreated != null){
            squiggleCreated.setEndPoint(new Point(event.getX(), event.getY()));
            this.completed = true;
        }
    }

    public void mouseMoved(MouseEvent mouseEvent){
    }

    public void mouseEntered(MouseEvent mouseEvent){
    }

    public void mouseExited(MouseEvent mouseEvent){
    }

    public void mouseClicked(MouseEvent event){
    }

    public void reset(){
        this.squiggleCreated = null;
        this.completed = false;
    }

    public Squiggle getLineComponentCreated(){
        return this.squiggleCreated;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Squiggle getCreation(){
        return getLineComponentCreated();
    }
}
