package MVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiceApplication extends Application implements ActionListener {

    private Dice model;
    private DiceController controller;
    private DiceView view;

    @Override
    public void start(Stage stage) throws Exception{
        Dice dice = new Dice();
        DiceController diceController = new DiceController(dice);

        DiceView diceView = new DiceView(diceController);
        Button button = new Button("roll");
        button.addActionListener(this);

        HBox root = new HBox();
        root.getChildren().addAll();

        diceController.addView(diceView);

        dice.attachObserver(diceView);

        Scene scene = new Scene(root);
        stage.setTitle("Dice");

        stage.setScene(scene);
        dice.roll();
        stage.show();
    }

    public void actionPerformed(ActionEvent event){
        controller.roll();
    }

    public static void main(String[] args){
        launch(args);
    }
}
