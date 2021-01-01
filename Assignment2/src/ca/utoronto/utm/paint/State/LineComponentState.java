package ca.utoronto.utm.paint.State;

import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Line.LineComponent;

public interface LineComponentState extends State{
    public LineComponent getLineComponentCreated();

    public void setConfiguration(Configuration configuration);
}
