package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class LineState implements State{
    private Line lineCreated;
    private boolean completed;

    public LineState(){
        this.lineCreated = null;
        this.completed = false;
    }

    public void mouseMoved(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    /**
     * Keep updating the end point of the line created.
     *
     * @param mouseEvent
     */
    public void mouseDragged(MouseEvent mouseEvent){
        if(this.lineCreated != null){
            lineCreated.setEndPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
        }
    };

    public void mouseClicked(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    /**
     * When mouse is pressed, create the start point and endpoint
     * of the line, and both points are the same point, at the current
     * position of the mouse.
     *
     * @param mouseEvent
     */
    public void mousePressed(MouseEvent mouseEvent){
        if(lineCreated == null) {
            Point startPoint = new Point(mouseEvent.getX(), mouseEvent.getY());
            Point endPoint = new Point(mouseEvent.getX(), mouseEvent.getY());

            lineCreated = new Line(startPoint, endPoint);
        }
    };

    /**
     * When mouse is released, change the line end point one last time.
     *
     * @param mouseEvent
     */
    public void mouseReleased(MouseEvent mouseEvent){
        if(this.lineCreated != null){
            lineCreated.setEndPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
            this.completed = true;
        }
    };

    public void mouseEntered(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    public void mouseExited(MouseEvent mouseEvent){
        System.out.println("This doesn't do anything");
    }

    public Line getLineCreated(){
        return lineCreated;
    }

    public void reset(){
        this.lineCreated = null;
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
