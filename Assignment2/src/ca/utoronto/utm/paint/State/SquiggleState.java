package ca.utoronto.utm.paint.State;

import ca.utoronto.utm.paint.Configuration.LineConfiguration;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.Squiggle;

import java.awt.event.MouseEvent;

public class SquiggleState implements LineComponentState{
    private Squiggle squiggleCreated;
    private boolean completed;
    private LineConfiguration configuration;

    public SquiggleState(LineConfiguration configuration){
        this.squiggleCreated = null;
        this.completed = false;
        this.configuration = configuration;
    }

    /**
     * Create the initial point of the squiggle.
     * @param event
     */
    public void mousePressed(MouseEvent event){
        if(squiggleCreated == null){
            squiggleCreated = new Squiggle(new Point(event.getX(), event.getY(), null), configuration);
        }
    }

    /**
     * Extends the squiggle created by adding point as mouse dragged
     *
     * @param event
     */
    public void mouseDragged(MouseEvent event){
        if(squiggleCreated != null){
            squiggleCreated.addPoint(new Point(event.getX(), event.getY(), null));
        }
    }

    /**
     * Add last point to the squiggle
     * @param event
     */
    public void mouseReleased(MouseEvent event){
        if(squiggleCreated != null){
            squiggleCreated.setEndPoint(new Point(event.getX(), event.getY(), null));
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

    @Override
    public void setConfiguration(LineConfiguration configuration) {
        this.configuration = configuration;
        this.getCreation().setConfiguration(configuration);
    }

    @Override
    public LineConfiguration getConfiguration() {
        return configuration;
    }
}
