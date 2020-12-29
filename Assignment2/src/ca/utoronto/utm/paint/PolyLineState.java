package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class PolyLineState implements LineComponentState{
    private PolyLine polyLineCreated;
    private boolean completed;

    public PolyLineState(){
        this.polyLineCreated = null;
        this.completed = false;
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
            polyLineCreated.addPoint(new Point(event.getX(), event.getY()));
        }
    }

    /**
     * This doesn't do anything on the poly line created. But
     * it indicates the end of drawing by changing "completed"
     * to true.
     *
     * @param event
     */
    public void mouseExited(MouseEvent event){
        if (polyLineCreated != null) {
            this.completed = true;
            System.out.println("Polyline is completed");
        }
    }

    public void mouseMoved(MouseEvent event){
    }

    public void mouseDragged(MouseEvent event){
    }

    public void mousePressed(MouseEvent event){
    }

    public void mouseReleased(MouseEvent event){
    }

    public void mouseEntered(MouseEvent event){
    }

    public PolyLine getLineComponentCreated(){
        return this.polyLineCreated;
    }

    public void reset(){
        this.polyLineCreated = null;
        this.completed = false;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    public PolyLine getCreation(){
        return getLineComponentCreated();
    }
}
