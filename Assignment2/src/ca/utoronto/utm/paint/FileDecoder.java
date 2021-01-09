package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.AddLineCommand;
import ca.utoronto.utm.paint.Command.Command;
import ca.utoronto.utm.paint.Configuration.Configuration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDecoder {

    private Scanner scanner;


    public FileDecoder(){
    }

    public String recognizeCommand(String line){
        Pattern commandPattern = Pattern.compile("[A-Z][a-z]+,.*}");

        // match entire string
        Matcher commandMatcher = commandPattern.matcher(line);
        if(commandMatcher.matches()){
            String commandType = line.substring(0, line.indexOf(","));
            return commandType;
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
            // can use each group for specific settings
        }
        return null;
    }

}
