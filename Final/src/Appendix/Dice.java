package Appendix;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
public class Dice extends Label {//implements EventHandler<ActionEvent> {
    private int d1, d2;
    Random r = new Random();
    Label label=new Label();
    public void initApplication(Stage stage) {
        /**
        Button button = new Button("roll");
        HBox root = new HBox();
        root.setPadding(new Insets(5));
        root.getChildren().addAll(label, button);
        button.setOnAction(this);
        Scene scene = new Scene(root);
        stage.setTitle("Dice");
        stage.setScene(scene);
        this.roll();
         **/

    }
    public void roll() {
        d1 = r.nextInt(6)+1;
        d2 = r.nextInt(6)+1;
        this.label.setText("("+this.getD1()+","+this.getD2()+")");
    }
    public int getD1() { return this.d1; }
    public int getD2() { return this.d2; }
    public void handle(ActionEvent event) {
        this.roll();
        this.setText(this.getD1()+" "+this.getD2());
    }
}

