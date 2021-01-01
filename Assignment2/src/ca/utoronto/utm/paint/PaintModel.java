package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.Command;
import ca.utoronto.utm.paint.Shape.Shape;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The paint model that manages all points, shapes, and lines created.
 * It also acts as the command receiver and invoker for the command interface.
 */
public class PaintModel extends Observable {
	private ArrayList<Point> points=new ArrayList<Point>();
	private ArrayList<Shape> shapes =new ArrayList<Shape>();
	private ArrayList<LineComponent> lines = new ArrayList<LineComponent>();


	private ArrayList<Command> commands = new ArrayList<Command>();
	private int commandLog = 0; // allow redo feature of up to 5 commands.
	
	
	public void addPoint(Point p){
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Point> getPoints(){
		return points;
	}

	public void removePoint(Point point){
		this.points.remove(point);
		this.setChanged();
		this.notifyObservers();
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
		this.shapes.remove(shape);
		this.setChanged();
		this.notifyObservers();
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
		this.lines.remove(line);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Execute the command received and then add to the list
	 * of executed commands. Clear command backlog at the end.
	 */
	public void invokeCommand(Command command){
		if (command != null) {
			command.execute();
			this.commands.add(command);
			commandLog += 1;
			// downsize
			// this.downsizeCommands();
		}
	}

	/**
	 * Revoke the last command. (When undo is pressed)
	 */
	public void revokeCommand(){
		if ( !commands.isEmpty() && commands.get(commands.size() - 1).isReversable()) {
			commands.get(commands.size() - 1).unexecute();
			commands.remove(commands.size() - 1);
			if (commandLog > 0) {
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
			if (commandLog > 0){
				commandLog -= 1;
			}
		}
	}


}
