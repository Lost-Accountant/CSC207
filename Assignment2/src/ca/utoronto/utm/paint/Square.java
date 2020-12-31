package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Configuration.ShapeConfiguration;

/**
 * Draw a square that is a rectangle with the same
 * width and height.
 */
public class Square extends Rectangle{

    public Square(Point centre, int width, ShapeConfiguration configuration){
        super(centre, width, width, configuration);
    }

    @Override
    public void setWidth(int width){
        super.setWidth(width);
        super.setHeight(width); // ensure same width and height
    }

    @Override
    public void setHeight(int height){
        super.setHeight(height);
        super.setWidth(height); // ensure same width and height
    }
}
