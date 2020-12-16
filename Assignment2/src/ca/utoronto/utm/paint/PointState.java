package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class PointState implements State{
    private Point pointCreated;
    private boolean completed;

    public PointState(){
        this.pointCreated = null;
        this.completed = false;
    }

    /**
     * Create the point where mouse clicked
     * @param event
     */
    public void mouseClicked(MouseEvent event){
        if(pointCreated == null){
            pointCreated = new Point(event.getX(), event.getY());
            this.completed = true;
        }
    }

    public void mouseMoved(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }
    public void mouseDragged(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }
    public void mousePressed(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }
    public void mouseReleased(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }
    public void mouseEntered(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }
    public void mouseExited(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    public Point getPointCreated(){
        return this.pointCreated;
    }

    public void reset(){
        this.pointCreated = null;
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
