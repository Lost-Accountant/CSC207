package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.Command;
import ca.utoronto.utm.paint.Line.LineComponent;
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
	private int commandLog = 0; // index for to-be invoked command
	
	
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
			commandLog = commands.size();
			// downsize
			// this.downsizeCommands();
		}
		System.out.println(this.commands);
		System.out.println(this.commands.size());
		System.out.println(this.commandLog);
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
	 * Invoke the next command if there is command stored but not implemented.
	 */
	public void invokeNextCommand(){
		if (commandLog < commands.size()){
			commands.get(commandLog).execute();
			commandLog += 1;
		}
	}

	public void undoCommand(){
		if ( !commands.isEmpty() && commands.get(commandLog - 1).isReversable()) {
			commands.get(commandLog - 1).unexecute();
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
