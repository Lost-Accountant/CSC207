package Appendix;

import javafx.application.Application;
import javafx.stage.Stage;

public class DiceApplication extends Application {
    public void start(Stage stage) throws Exception {
        Dice dice = new Dice();
        dice.initApplication(stage);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
