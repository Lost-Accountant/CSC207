package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.Command;
import ca.utoronto.utm.paint.Line.LineComponent;
import ca.utoronto.utm.paint.Shape.Shape;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Observable;

/**
 * The paint model that manages all points, shapes, and lines created.
 * It also acts as the command receiver and invoker for the command interface.
 */
public class PaintModel extends Observable {
	private ArrayList<Point> points;
	private ArrayList<Shape> shapes;
	private ArrayList<LineComponent> lines;


	private ArrayList<Command> commands;
	private int commandLog; // index for last invoked command

	public PaintModel(){
		this.points = new ArrayList<Point>();
		this.shapes = new ArrayList<Shape>();
		this.lines = new ArrayList<LineComponent>();

		this.commands = new ArrayList<Command>();
		this.commandLog = -1;

	}
	
	
	public void addPoint(Point p){
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Point> getPoints(){
		return points;
	}

	public void removePoint(Point point){
		if (this.points.contains(point)) {
			this.points.remove(point);
			this.setChanged();
			this.notifyObservers();
		}
	}

	public void addShape(Shape shape){
		this.shapes.add(shape);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Shape> getShapes(){
		return shapes;
	}

	public void removeShape(Shape shape){
		if(shapes.contains(shape)) {
			this.shapes.remove(shape);
			this.setChanged();
			this.notifyObservers();
		}
	}

	public void addLine(LineComponent line){
		this.lines.add(line);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<LineComponent> getLines(){
		return lines;
	}

	public void removeLine(LineComponent line){
		if(this.lines.contains(line)) {
			this.lines.remove(line);
			this.setChanged();
			this.notifyObservers();
		}
	}

	public ArrayList<Command> getCommands(){
		return commands;
	}

	public void setCommands(ArrayList<Command> commands){
		this.commands = commands;
	}

	public int getCommandLog(){
		return commandLog;
	}

	public void setCommandLog(int commandLog){
		this.commandLog = commandLog;
	}

	/**
	 * Execute the command received and then add to the list
	 * of executed commands. Clear command backlog at the end.
	 */
	public void invokeCommand(Command command){
		if (command != null) {
			command.execute();
			this.commands.add(command);
			// move command to the last
			// in case being undo in the middle
			commandLog = commands.size() - 1;
			// clear abandoned commands
			this.removeAbandonedCommands(commandLog);

		}
		System.out.println(this.commands);
		System.out.println(this.commands.size());
		System.out.println(this.commandLog);

		for (Command c: commands){
			System.out.println(c.isExecuted());
		}
	}

	/**
	 * Revoke the last command. (When undo is pressed)
	 */
	public void revokeCommand(){
		if ( !commands.isEmpty() && commands.get(commands.size() - 1).isReversable()) {
			commands.get(commands.size() - 1).unexecute();
			commands.remove(commands.size() - 1);
			if (commandLog >= 0) {
				commandLog -= 1;
			}
		}
	}

	/**
	 * Invoke the next command if there is command stored but not implemented.
	 */
	public void invokeNextCommand(){
		if (commandLog < commands.size() - 1){
			commandLog += 1;
			commands.get(commandLog).execute();

		}
	}

	public void undoCommand(){
		if ( !commands.isEmpty() && commands.get(commandLog).isReversable()) {
			commands.get(commandLog).unexecute();

			if (commandLog >= 0) {
				commandLog -= 1;
			}
		}
	}

	/**
	 * Reduce the size of commands to 5.
	 * Also shifts the commandLog down correspondingly, until it hits zero again.
	 */
	public void downsizeCommands(){
		while (commands.size() > 5){
			// remove the oldest command
			commands.remove(0);
			if (commandLog >= 0){
				commandLog -= 1;
			}
		}
	}

	/**
	 * Remove unexecuted commands until end point, exclusive of endpoint.
	 *
	 * @param end the last command before
	 */
	public void removeAbandonedCommands(int end){
		// use list iterator
		ListIterator<Command> iter = commands.listIterator();
		while(iter.hasNext() && iter.next() != commands.get(end)){
			if(!iter.next().isExecuted()){
				iter.remove();
			}
		}

		// index 0 unexecuted but not removed (probably related to index out of bound execption)
	}
}
