package ca.utoronto.utm.paint;

import java.util.ArrayList;

public class PolyLine {

    private Point lastPoint;
    private ArrayList<Line> lines;

    public PolyLine(Point startPoint){
        this.lastPoint = startPoint;
        this.lines = new ArrayList<LineComponent>();
    }

    /**
     * Create a new line in the lines by linking last point
     * with next point. Then shift last point to next point.
     *
     * @param nextPoint the point to be connected with last
     *                  point for a new line
     */
    public void attachLine(Point nextPoint){
        if (this.lastPoint != null) {
            lines.add(new Line(this.lastPoint, nextPoint));
            this.lastPoint = nextPoint;
        }
    }

    /**
     * Change the last line back to the start point of the
     * line to be deleted, and then delete the current last line.
     *
     */
    public void removeLastLine(){
       this.lastPoint = lines.get(lines.size() - 1).getStartPoint();
       lines.remove(lines.size() - 1);
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}
