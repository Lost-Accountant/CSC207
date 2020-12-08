package ca.utoronto.utm.paint;

/**
 * Draw a square that is a rectangle with the same
 * width and height.
 */
public class Square extends Rectangle{
    public Square(Point centre, int width){
        super(centre, width, width);
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
