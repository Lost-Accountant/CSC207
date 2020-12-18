package ca.utoronto.utm.paint;

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

	// temporary old code
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	
	
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
		command.execute();
		this.commands.add(command);
		commandLog += 1;
		// downsize
		this.downsizeCommands();
	}

	/**
	 * Revoke the last command. (When undo is pressed)
	 */
	public void revokeCommand(){
		if ( !commands.isEmpty() && commands.get(commands.size() - 1).isReversable()) {
			commands.get(commands.size() - 1).unexecute();
			commands.remove(commands.size() - 1);
			commandLog -= 1;
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

	/**
	 * WIP as add shapes disrupts old code
	 * @param c
	 */
	public void addCircle(Circle c){
		this.circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * WIP as get shapes disruptes old code
	 * @return
	 */
	public ArrayList<Circle> getCircles(){
		return circles;
	}


}
