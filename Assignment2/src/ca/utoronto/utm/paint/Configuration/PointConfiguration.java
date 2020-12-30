package ca.utoronto.utm.paint.Configuration;

import java.awt.*;

public class PointConfiguration implements Configuration{
    private Color color;

    public PointConfiguration(Color color){
        this.color = color;
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
    public void setIsFilled(boolean isFilled) {
    }

    @Override
    public void setLineThickness(int lineThickness) {
    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public int getLineThickness() {
        return -1;
    }
}
