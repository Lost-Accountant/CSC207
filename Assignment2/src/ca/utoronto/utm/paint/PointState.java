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
        if(pointCreated == null){
            pointCreated = new Point(event.getX(), event.getY());
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
    }
}
