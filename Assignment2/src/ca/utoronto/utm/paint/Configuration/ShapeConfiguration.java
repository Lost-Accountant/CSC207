package ca.utoronto.utm.paint.Configuration;

import java.awt.*;

public class ShapeConfiguration implements Configuration{
    private Color color;
    private int lineThickness;
    private boolean isFilled;

    public ShapeConfiguration(Color color, int lineThickness, boolean filled){
        this.color = color;
        this.lineThickness = lineThickness;
        this.isFilled = filled;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean isFilled() {
        return isFilled;
    }

    @Override
    public int getLineThickness() {
        return lineThickness;
    }
}
