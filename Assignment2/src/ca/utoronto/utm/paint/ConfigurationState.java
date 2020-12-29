package ca.utoronto.utm.paint;

public class ConfigurationState {
    private String color;
    private int stroke;
    private boolean isFilled;

    public ConfigurationState(){
        // default setting
        this.color = "black";
        this.stroke = 1;
        this.isFilled = false;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public int getStroke() {
        return stroke;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }
}
