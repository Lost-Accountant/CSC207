package ca.utoronto.utm.paint.Configuration;


import java.awt.*;

public interface Configuration {
    public void setColor(Color color);

    public Color getColor();

    public void setLineThickness(int lineThickness);

    public int getLineThickness();

    public void setIsFilled(boolean isFilled);

    public boolean isFilled();
}
