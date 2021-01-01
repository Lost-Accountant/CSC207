package ca.utoronto.utm.paint.State;

import ca.utoronto.utm.paint.Configuration.LineConfiguration;
import ca.utoronto.utm.paint.LineComponent;

public interface LineComponentState extends State{
    public LineComponent getLineComponentCreated();

    public void setConfiguration(LineConfiguration configuration);
}
