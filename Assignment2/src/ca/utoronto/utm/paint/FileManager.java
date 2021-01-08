package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.Command.AddLineCommand;
import ca.utoronto.utm.paint.Command.AddPointCommand;
import ca.utoronto.utm.paint.Command.Command;

import javax.swing.*;
import java.io.*;

public class FileManager {

    private JFileChooser fileChooser;
    private View view;

    public FileManager(View view){
        this.fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save your paint somewhere");
        this.view = view;

    }

    public void save(){
        // show directories only
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = fileChooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            createSaveFile(file.getAbsolutePath());
            System.out.println("File saves as: " + file.getAbsolutePath() + ".txt");
            // can maybe write file here.
        } else {
            System.out.println("File save failed");
        }
    }

    public void load(){

    }

    public File createSaveFile(String filePath){
        // create save file
        File saveFile = new File(filePath + ".txt");
        this.saveCommands(saveFile);

        return saveFile;
    }

    public void saveCommands(File file){
        try {
            PrintStream commandWriter = new PrintStream(file);

            // write each command's attributes
            for (Command command : view.getModel().getCommands()) {
                    commandWriter.println(command.toString());
            }
            commandWriter.close();

        } catch (IOException e){
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }

    public void readSaveFile(File file){

    }

}
