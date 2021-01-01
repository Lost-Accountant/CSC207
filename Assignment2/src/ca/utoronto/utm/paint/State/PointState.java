package ca.utoronto.utm.paint.State;

import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Configuration.PointConfiguration;
import ca.utoronto.utm.paint.Point;

import java.awt.event.MouseEvent;

public class PointState implements State{
    private Point pointCreated;
    private boolean completed;
    private PointConfiguration configuration;

    public PointState(PointConfiguration configuration){
        this.pointCreated = null;
        this.completed = false;
        this.configuration = configuration;
    }

    /**
     * Create the point where mouse clicked
     * @param event
     */
    public void mouseClicked(MouseEvent event){}
    public void mouseMoved(MouseEvent mouseEvent){
    }
    public void mouseDragged(MouseEvent mouseEvent){
    }

    public void mousePressed(MouseEvent event){
        if(pointCreated == null) {
            pointCreated = new Point(event.getX(), event.getY(), configuration);
        }
    }
    public void mouseReleased(MouseEvent event){
        this.completed = true;
    }

    public void mouseEntered(MouseEvent mouseEvent){
    }
    public void mouseExited(MouseEvent mouseEvent){
    }

    public Point getPointCreated(){
        return this.pointCreated;
    }

    public void reset(){
        this.pointCreated = null;
        this.completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Point getCreation(){
        return getPointCreated();
    }

    /**
     * Update both current state and the current creation.
     * @param configuration
     */
    public void setConfiguration(PointConfiguration configuration){
        this.configuration = configuration;
        this.getCreation().setConfiguration(configuration);
    }

    public PointConfiguration getConfiguration(){
        return configuration;
    }
}
