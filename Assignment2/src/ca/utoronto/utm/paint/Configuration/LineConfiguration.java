package ca.utoronto.utm.paint.Configuration;

import java.awt.*;

public class LineConfiguration implements Configuration{
    private Color color;
    private int lineThickness;

    public LineConfiguration(Color color, int lineThickness){
        this.color = color;
        this.lineThickness = lineThickness;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    @Override
    public int getLineThickness() {
        return lineThickness;
    }

    @Override
    public void setIsFilled(boolean isFilled) {
    }

    @Override
    public boolean isFilled() {
        return false;
    }
}
