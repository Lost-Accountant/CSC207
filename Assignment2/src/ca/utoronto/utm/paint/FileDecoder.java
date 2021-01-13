package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.AddLineCommand;
import ca.utoronto.utm.paint.Command.AddPointCommand;
import ca.utoronto.utm.paint.Command.AddShapeCommand;
import ca.utoronto.utm.paint.Command.Command;
import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Line.Line;
import ca.utoronto.utm.paint.Line.LineComponent;
import ca.utoronto.utm.paint.Line.PolyLine;
import ca.utoronto.utm.paint.Line.Squiggle;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDecoder {

    private Command constructedCommand;


    public FileDecoder(){
        this.constructedCommand = null;
    }

    public Command recognizeCommand(String line, PaintModel model){
        Pattern commandPattern = Pattern.compile("[A-Z][a-z]+,.*}");

        // match entire string
        Matcher commandMatcher = commandPattern.matcher(line);
        if(commandMatcher.matches()){
            // step 1: find out command type
            String commandType = line.substring(0, line.indexOf(","));
            //System.out.println(commandType);

            // step 2: find out configuration
            Configuration storedConfig = recognizeConfiguration(line);
            //System.out.println(storedConfig);

            // step 3: find out about the object
            Object creation = recognizeObject(line, commandType);
            //System.out.println(creation);

            // step 4: construct and deliver the command
            constructedCommand = constructCommand(commandType, creation, model);
            //System.out.println(constructedCommand);
            return constructedCommand;
        }
        return null;
    }

    public Configuration recognizeConfiguration(String line){
        Pattern configPattern = Pattern.compile("configuration=\\(java\\.awt\\.Color\\[" +
                "r=(\\d{1,3})\\,g=(\\d{1,3}),b=(\\d{1,3})]\\,\\s(10|[1-9])\\, (true|false)\\)");
        // Find section
        Matcher configMatcher = configPattern.matcher(line);
        if(configMatcher.find()){
            //System.out.println(configMatcher.group(0));

            Color storedColor = new Color(Integer.parseInt(configMatcher.group(1)),
                    Integer.parseInt(configMatcher.group(2)),
                    Integer.parseInt(configMatcher.group(3)));
            int storedLineThickness = Integer.parseInt(configMatcher.group(4));
            boolean storedFill = Boolean.parseBoolean(configMatcher.group(5));

            Configuration storedConfig = new Configuration(storedColor, storedLineThickness, storedFill);

            return storedConfig;
        }
        return null;
    }


    public Object recognizeObject(String line, String commandType){
        // judge based on rough type
        if (commandType.equals("Shape")){
            return recognizeShape(line);
        } else if (commandType.equals("Line")){
            return recognizeLine(line);
        } else if (commandType.equals("Point")){
            return recognizePoint(line);
        } else {
            return null;
        }
    }

    public LineComponent recognizeLine(String line){

        // judge specific line
        Matcher lineMatcher = Pattern.compile(",\\s([a-zA-z]*)\\{").matcher(line);
        if (lineMatcher.find()){
            ArrayList<Point> pointsSaved = recognizePoints(line);

            String lineType = lineMatcher.group(1);
            if (lineType.equals("Line")){
                Line storedLine = new Line(pointsSaved.get(0), pointsSaved.get(1), recognizeConfiguration(line));
                return storedLine;
            } else if (lineType.equals("Squiggle")){
                Squiggle storedLine = new Squiggle(pointsSaved.get(0), recognizeConfiguration(line));

                int i = 1;
                while(i < pointsSaved.size()){
                    storedLine.addPoint(pointsSaved.get(i));
                    i += 1;
                }
                return storedLine;

            } else if (lineType.equals("PolyLine")){
                PolyLine storedLine = new PolyLine(pointsSaved.get(0), recognizeConfiguration(line));

                int i = 1;
                while(i < pointsSaved.size()){
                    storedLine.addPoint(pointsSaved.get(i));
                    i += 1;
                }

                return storedLine;
            } else {
                return null;
            }
        }
        return null;
    }

    public Shape recognizeShape(String line){
        // judge specific shape

        return null;
    }

    private Point recognizePoint(String line){
        return recognizePoints(line).get(0);
    }

    private ArrayList<Point> recognizePoints(String line){
        Pattern simplePointPattern = Pattern.compile("\\(\\d+\\,\\s\\d+\\)\\,");
        ArrayList<Point> collectedPoints = new ArrayList<Point>();
        // find section
        Matcher simplePointMatcher = simplePointPattern.matcher(line);
        // a loop to collect all points
        while(simplePointMatcher.find()){

            // remove brackets and comma
            String point = simplePointMatcher.group().replaceAll("\\p{P}","");
            // extract coordinates
            String[] coordinates = point.split("\\s+");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            // build point
            Point eachPoint = new Point(x, y, recognizeConfiguration(line));

            // add each point to collection
            collectedPoints.add(eachPoint);
        }
        return collectedPoints;
    }

    private Command constructCommand(String commandType, Object creation, PaintModel model){
        if (commandType.equals("Point") && creation instanceof Point){
            constructedCommand = new AddPointCommand(model, (Point) creation);
        } else if (commandType.equals("Line") && creation instanceof LineComponent){
            constructedCommand = new AddLineCommand(model, (LineComponent) creation);
        } else if (commandType.equals("Shape") && creation instanceof Shape){
            constructedCommand = new AddShapeCommand(model, (ca.utoronto.utm.paint.Shape.Shape) creation);
        }
        return constructedCommand;
    }
}
