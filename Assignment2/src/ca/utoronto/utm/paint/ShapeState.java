package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class ShapeState implements State {

    private Shape shapeCreated;
    private String shapeType;

    public ShapeState(String shapeType){
        this.shapeType = shapeType;
    }

    public void mouseMoved(MouseEvent mouseEvent){
        System.out.println("this doesn't do anything");
    }

    /**
     * Create the shape by pressing the mouse. Initial width and
     * height are both zero.
     */
    public void mousePressed(MouseEvent e){
        // Create the center of the shape
        Point centre = new Point(e.getX(), e.getY());

        // call different constructor based on shape type provided
        switch(shapeType){
            case "Circle":
                shapeCreated = new Circle(centre, 0);
            case "Rectangle":
                shapeCreated = new Rectangle(centre, 0, 0);
            case "Square":
                shapeCreated = new Square(centre, 0);
        }
    }

    /**
     * Update the radius/width/height of the shape when mouse is dragged.
     * Difference in x between current coordinate and center is half of width.
     * Difference in y between current coordinate and center is half of height.
     */
    public void mouseDragged(MouseEvent e){
        // for circle and square, use diagonal line/radius,
        // and math transformation to set width and height.

        // for rectangle, uses set width and height normally

    }

    public void mouseClicked(MouseEvent mouseEvent){};
    public void mouseReleased(MouseEvent mouseEvent){};
    public void mouseEntered(MouseEvent mouseEvent){};
    public void mouseExited(MouseEvent mouseEvent){};
}
