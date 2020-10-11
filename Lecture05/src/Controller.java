import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.jws.WebParam;


// the GUI itself
// initializes View, Model, and has the main GUI configuration.

public class Controller extends Application{
    public static void main(String [] args){
        launch(args);
    }

    public void start(Stage stage){
        initUI(stage);
    }

    private void initUI(Stage stage){
        // initializing stuff
        Model model = new Model();
        View view = new View();
        model.addObserver(view);

        HBox pane = new HBox(5);
        pane.setPadding(new Insets(10));
        // name for button
        Button button = new Button("press me, I am in controller");

        // adds action listener
        button.setOnAction(new some_eventhandler(model));

        // GUI
        // add View and Listener button to pane
        pane.getChildren().add(button);
        pane.getChildren().add(view);
        // add pane to Scene
        Scene scene = new Scene(pane);
        // set stage to scene
        stage.setScene(scene);
        stage.setTitle("Hi Bye JavaFX");
        // show stage
        stage.show();
    }
}
