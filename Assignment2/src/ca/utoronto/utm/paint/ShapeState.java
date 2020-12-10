package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class ShapeState implements State {

    public void mouseMoved(MouseEvent mouseEvent){
        System.out.println("this doesn't do anything");
    }

}
