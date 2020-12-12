package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class PointState implements State{
    private Point pointCreated;

    public PointState(){
        this.pointCreated = null;
    }

    /**
     * Create the point where mouse clicked
     * @param event
     */
    public void mouseClicked(MouseEvent event){
        pointCreated = new Point(event.getX(), event.getY());
    }

    public void mouseMoved(MouseEvent mouseEvent){

    }
    public void mouseDragged(MouseEvent mouseEvent){}
    public void mousePressed(MouseEvent mouseEvent){}
    public void mouseReleased(MouseEvent mouseEvent){}
    public void mouseEntered(MouseEvent mouseEvent){}
    public void mouseExited(MouseEvent mouseEvent){}

    public Point getPointCreated(){
        return this.pointCreated;
    }
}
