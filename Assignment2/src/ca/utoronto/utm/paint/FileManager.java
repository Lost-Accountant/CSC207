package ca.utoronto.utm.paint;

import javax.swing.*;
import java.io.File;

public class FileManager {

    private JFileChooser fileChooser;

    public FileManager(){
        this.fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save your paint somewhere");

    }

    public void save(){
        // show directories only
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = fileChooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            System.out.println("File saves as: " + file.getAbsolutePath());
            // can maybe write file here.
        } else {
            System.out.println("File save failed");
        }
    }
}
