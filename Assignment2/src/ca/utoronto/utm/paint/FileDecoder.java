package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.AddLineCommand;
import ca.utoronto.utm.paint.Command.AddPointCommand;
import ca.utoronto.utm.paint.Command.AddShapeCommand;
import ca.utoronto.utm.paint.Command.Command;
import ca.utoronto.utm.paint.Configuration.Configuration;
import ca.utoronto.utm.paint.Line.LineComponent;

import java.awt.*;
import java.util.Scanner;
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

            // step 2: find out configuration
            Configuration storedConfig = recognizeConfiguration(line);

            // step 3: find out about the object
            Object creation = recognizeObject(line);

            // step 4: construct and deliver the command
            constructedCommand = constructCommand(commandType, creation, model);
        }
        return null;
    }

    public Configuration recognizeConfiguration(String line){
        Pattern configPattern = Pattern.compile("configuration=\\(java\\.awt\\.Color\\" +
                "[r=(0*(?:[0-9][0-9]?|[0-2][0-5][0-5]))\\,g=(0*(?:[0-9][0-9]?|[0-2][0-5][0-5]))," +
                "b=(0*(?:[0-9][0-9]?|[0-2][0-5][0-5]))]\\,(10 | [1-9])\\, (true|false)\\)");
        // Find section
        Matcher configMatcher = configPattern.matcher(line);
        if(configMatcher.find()){
            System.out.println(configMatcher.group(0));
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


    public Object recognizeObject(String line){
        // judge based on rough type

        return null;
    }

    public LineComponent recognizeLine(String line){
        // judge specific line

        return null;
    }

    public Shape recognizeShape(String line){
        // judge specific shape

        return null;
    }

    private Point recognizePoint(String line){
        // create Point

        return null;
    }

    private Point recognizePointSimplified(String line){
        Pattern simplePointPattern = Pattern.compile("\\(\\d+\\,\\s\\d+\\)\\,");

        return null;
    }

    private Command constructCommand(String commandType, Object creation, PaintModel model){
        if (commandType == "Point" && creation instanceof Point){
            constructedCommand = new AddPointCommand(model, (Point) creation);
        } else if (commandType == "Line" && creation instanceof LineComponent){
            constructedCommand = new AddLineCommand(model, (LineComponent) creation);
        } else if (commandType == "Shape" && creation instanceof Shape){
            constructedCommand = new AddShapeCommand(model, (ca.utoronto.utm.paint.Shape.Shape) creation);
        }
        return constructedCommand;
    }
}
