package ca.utoronto.utm.paint;

public interface Command {
    public void execute();

    public void unexecute();

    public boolean isReversable();
}
