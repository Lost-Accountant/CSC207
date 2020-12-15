package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class PolyLineState implements State{
    private PolyLine polyLineCreated;

    public PolyLineState(){
        this.polyLineCreated = null;
    }

    /**
     * If there is no polyline that has been created,
     * initialize the creation of the polyline,
     * with only one point created, and no line
     * visible.
     *
     * Else, extend the existing polyline.
     *
     * @param event
     */
    public void mouseClicked(MouseEvent event){
       if (polyLineCreated == null){
           polyLineCreated = new PolyLine(new Point(event.getX(), event.getY()));
       } else {
           polyLineCreated.attachLine(new Point(event.getX(), event.getY()));
       }
    }

    /**
     * This doesn't do anything on the poly line created. But
     * it can be
     * @param event
     */
    public void mouseExited(MouseEvent event){

    }

}
