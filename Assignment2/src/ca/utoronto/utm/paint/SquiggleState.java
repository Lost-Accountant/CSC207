package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class SquiggleState implements State{
    private Squiggle squiggleCreated;

    public SquiggleState(){
        this.squiggleCreated = null;
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

    public void mouseDragged(MouseEvent event){

    }
}
