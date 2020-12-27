package ca.utoronto.utm.paint;

public class ConfigurationState {
    private String color;
    private int lineThickness;
    private boolean isFilled;

    public ConfigurationState(){
        // default setting
        this.color = "black";
        this.lineThickness = 1;
        this.isFilled = false;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public int getLineThickness() {
        return lineThickness;
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

    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }
}
