package ca.utoronto.utm.paint;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private State currentState; // Set different behavior based on states.
	private Command commandCreated; // create command to sent to Paint Model.

	private String mode; // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.mode="Circle"; // bad code here?
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view = view;

		this.currentState = null;
		this.commandCreated = null;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.white);
        g2d.drawString ("i="+i, 50, 75);
		i=i+1;

		// Draw Points
		this.paintAllPoints(g2d);

		// Draw Lines
		this.paintAllLines(g2d);
		
		// Draw Circles
		this.paintAllShapes(g2d);
		
		g2d.dispose();
	}

	/**
	 * Draw all existing points in PaintModel as tiny circles.
	 * @param g2d
	 */
	public void paintAllPoints(Graphics2D g2d){
		ArrayList<Point> existingPoints = this.model.getPoints();
		for(Point p: existingPoints){
			int x = p.getX();
			int y = p.getY();
			// draw points by drawing tiny circles
			g2d.drawOval(x, y, 1, 1);
		}
	}

	/**
	 * Drw all existing shapes in PaintModel depending on specific type
	 * @param g2d
	 */
	public void paintAllShapes(Graphics2D g2d){
		ArrayList<Shape> existingShapes = this.model.getShapes();
		for(Shape s: existingShapes){
			Point centre = s.getCentre();
			// if shape is circle
			if (s instanceof Circle){
				g2d.drawOval(centre.getX(), centre.getY(), s.getWidth(), s.getHeight());
			} // same way to draw rectangle and square
			else if (s instanceof Rectangle){
				g2d.drawRect(centre.getX(), centre.getY(), s.getWidth(), s.getHeight());
			}
		}
	}

	public void paintAllLines(Graphics2D g2d){
		ArrayList<LineComponent> existingLines = this.model.getLines();
		for (LineComponent l: existingLines){
			// for each LineComponent, connect all points within each.
			ArrayList<Point> points = l.getPoints();
			for (int i = 0; i < points.size() - 1; i++){
				Point p1 = points.get(i);
				Point p2 = points.get(i + 1);
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this.
	 *
	 *  Old code. can be deleted once everything done.
	 */
	public void setMode(String mode){
		this.mode=mode;
	}

	/**
	 * Controller aspect of this. Change the state
	 * based on string received.
	 *
	 * @param mode
	 */
	public void setCurrentState(String mode){
		switch(mode){
			case "Circle":
				currentState = new CircleState();
				break;
			case "Rectangle":
				currentState = new RectangleState();
				break;
			case "Square":
				currentState = new SquareState();
				System.out.println("Square state selected.");
				break;
			case "Point":
				currentState = new PointState();
				break;
			case "Squiggle":
				currentState = new SquiggleState();
			case "Line":
				currentState = new LineState();
				break;
			case "Polyline":
				currentState = new PolyLineState();
				break;
		}
	}

	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		// revoke previous command to set up new command later
		if (this.commandCreated != null && this.commandCreated.isReversable()){
			this.commandCreated.unexecute();
		}

		// do action based on current state
		currentState.mouseMoved(MouseEvent e);

		// check whether work is done

		// if work done. reset state's work and status.

		// construct and send command even if not done.
		// Because needs live update.
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(), e.getY()));
		} else if(this.mode=="Circle"){
			
		}
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			// Problematic notion of radius and centre!!
			Point centre = new Point(e.getX(), e.getY());
			int radius = 0;
			this.circle=new Circle(centre, 0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			if(this.circle!=null){
				// Problematic notion of radius and centre!!
				int radius = Math.abs(this.circle.getCentre().getX()-e.getX());
				this.circle.setRadius(radius);
				this.model.addShape(this.circle);
				this.circle=null;
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}
}
