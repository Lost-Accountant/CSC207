package ca.utoronto.utm.paint.Command;

public interface Command {
    public void execute();

    public void unexecute();

    public boolean isReversable();

    public boolean isExecuted();
}
